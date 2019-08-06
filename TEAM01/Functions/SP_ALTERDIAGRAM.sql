CREATE OR REPLACE FUNCTION team01.sp_alterdiagram
(
  v_diagramname IN VARCHAR2,
  iv_owner_id IN NUMBER DEFAULT NULL ,
  v_version IN NUMBER,
  v_definition IN RAW
)
RETURN NUMBER
AUTHID DEFINER
AS
   v_owner_id NUMBER(10,0) := iv_owner_id;
   v_theId NUMBER(10,0);
   v_retval NUMBER(10,0);
   v_IsDbo NUMBER(10,0);
   v_UIDFound NUMBER(10,0);
   v_DiagId NUMBER(10,0);
   v_ShouldChangeUID NUMBER(10,0);

BEGIN

   IF ( v_diagramname IS NULL ) THEN

   BEGIN
      utils.raiserror( 0, 'Invalid ARG' );
      RETURN -1;

   END;
   END IF;
   /*TODO:SQLDEV*/ execute as caller /*END:SQLDEV*/
   v_theId := DATABASE_PRINCIPAL_ID() ;
   v_IsDbo := /*TODO:SQLDEV*/ IS_MEMBER(u'db_owner') /*END:SQLDEV*/ ;
   IF ( v_owner_id IS NULL ) THEN
    v_owner_id := v_theId ;
   END IF;
   /*TODO:SQLDEV*/ revert /*END:SQLDEV*/
   v_ShouldChangeUID := 0 ;
   SELECT diagram_id ,
          principal_id 

     INTO v_DiagId,
          v_UIDFound
     FROM team01.sysdiagrams 
    WHERE  principal_id = v_owner_id
             AND NAME = v_diagramname;
   IF ( v_DiagId IS NULL
     OR ( v_IsDbo = 0
     AND v_theId <> v_UIDFound ) ) THEN

   BEGIN
      utils.raiserror( 0, 'Diagram does not exist or you do not have permission.' );
      RETURN -3;

   END;
   END IF;
   IF ( v_IsDbo <> 0 ) THEN

   BEGIN
      IF ( v_UIDFound IS NULL
        OR USER IS NULL ) THEN

       -- invalid principal_id
      BEGIN
         v_ShouldChangeUID := 1 ;

      END;
      END IF;

   END;
   END IF;
   -- update dds data			
   UPDATE team01.sysdiagrams
      SET DEFINITION = v_definition
    WHERE  diagram_id = v_DiagId;
   -- change owner
   IF ( v_ShouldChangeUID = 1 ) THEN
    UPDATE team01.sysdiagrams
      SET principal_id = v_theId
    WHERE  diagram_id = v_DiagId;
   END IF;
   -- update dds version
   IF ( v_version IS NOT NULL ) THEN
    UPDATE team01.sysdiagrams
      SET version = v_version
    WHERE  diagram_id = v_DiagId;
   END IF;
   RETURN 0;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
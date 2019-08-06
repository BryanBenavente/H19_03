CREATE OR REPLACE FUNCTION team01.sp_helpdiagramdefinition
(
  v_diagramname IN VARCHAR2,
  iv_owner_id IN NUMBER DEFAULT NULL 
)
RETURN NUMBER
AUTHID DEFINER
AS
   v_owner_id NUMBER(10,0) := iv_owner_id;
   v_theId NUMBER(10,0);
   v_IsDbo NUMBER(10,0);
   v_DiagId NUMBER(10,0);
   v_UIDFound NUMBER(10,0);
   v_cursor SYS_REFCURSOR;

BEGIN

   IF ( v_diagramname IS NULL ) THEN

   BEGIN
      utils.raiserror( 0, u'E_INVALIDARG' );
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
   SELECT diagram_id ,
          principal_id 

     INTO v_DiagId,
          v_UIDFound
     FROM team01.sysdiagrams 
    WHERE  principal_id = v_owner_id
             AND NAME = v_diagramname;
   IF ( v_DiagId IS NULL
     OR ( v_IsDbo = 0
     AND v_UIDFound <> v_theId ) ) THEN

   BEGIN
      utils.raiserror( 0, 'Diagram does not exist or you do not have permission.' );
      RETURN -3;

   END;
   END IF;
   OPEN  v_cursor FOR
      SELECT version ,
             DEFINITION 
        FROM team01.sysdiagrams 
       WHERE  diagram_id = v_DiagId ;
      DBMS_SQL.RETURN_RESULT(v_cursor);
   RETURN 0;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
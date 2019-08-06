CREATE OR REPLACE FUNCTION team01.sp_creatediagram
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
   v_userName VARCHAR2(128);
   v_temp NUMBER(1, 0) := 0;

BEGIN

   IF ( v_version IS NULL
     OR v_diagramname IS NULL ) THEN

   BEGIN
      utils.raiserror( 0, u'E_INVALIDARG' );
      RETURN -1;

   END;
   END IF;
   /*TODO:SQLDEV*/ execute as caller /*END:SQLDEV*/
   v_theId := DATABASE_PRINCIPAL_ID() ;
   v_IsDbo := /*TODO:SQLDEV*/ IS_MEMBER(u'db_owner') /*END:SQLDEV*/ ;
   /*TODO:SQLDEV*/ revert /*END:SQLDEV*/
   IF v_owner_id IS NULL THEN

   BEGIN
      v_owner_id := v_theId ;

   END;
   ELSE

   BEGIN
      IF v_theId <> v_owner_id THEN

      BEGIN
         IF v_IsDbo = 0 THEN

         BEGIN
            utils.raiserror( 0, u'E_INVALIDARG' );
            RETURN -1;

         END;
         END IF;
         v_theId := v_owner_id ;

      END;
      END IF;

   END;
   END IF;
   -- next 2 line only for test, will be removed after define name unique
   BEGIN
      SELECT 1 INTO v_temp
        FROM DUAL
       WHERE EXISTS ( SELECT diagram_id 
                      FROM team01.sysdiagrams 
                       WHERE  principal_id = v_theId
                                AND NAME = v_diagramname );
   EXCEPTION
      WHEN OTHERS THEN
         NULL;
   END;

   IF v_temp = 1 THEN

   BEGIN
      utils.raiserror( 0, 'The name is already used.' );
      RETURN -2;

   END;
   END IF;
   INSERT INTO team01.sysdiagrams
     ( NAME, principal_id, version, DEFINITION )
     VALUES ( v_diagramname, v_theId, v_version, v_definition );
   v_retval := utils.getidentity ;
   RETURN v_retval;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
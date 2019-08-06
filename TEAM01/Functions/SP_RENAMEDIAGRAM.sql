CREATE OR REPLACE FUNCTION team01.sp_renamediagram
(
  v_diagramname IN VARCHAR2,
  iv_owner_id IN NUMBER DEFAULT NULL ,
  v_new_diagramname IN VARCHAR2
)
RETURN NUMBER
AUTHID DEFINER
AS
   v_owner_id NUMBER(10,0) := iv_owner_id;
   v_theId NUMBER(10,0);
   v_IsDbo NUMBER(10,0);
   v_UIDFound NUMBER(10,0);
   v_DiagId NUMBER(10,0);
   v_DiagIdTarg NUMBER(10,0);
   v_u_name VARCHAR2(128);

BEGIN

   IF ( ( v_diagramname IS NULL )
     OR ( v_new_diagramname IS NULL ) ) THEN

   BEGIN
      utils.raiserror( 0, 'Invalid value' );
      RETURN -1;

   END;
   END IF;
   /*TODO:SQLDEV*/ EXECUTE AS CALLER /*END:SQLDEV*/
   v_theId := DATABASE_PRINCIPAL_ID() ;
   v_IsDbo := /*TODO:SQLDEV*/ IS_MEMBER(u'db_owner') /*END:SQLDEV*/ ;
   IF ( v_owner_id IS NULL ) THEN
    v_owner_id := v_theId ;
   END IF;
   /*TODO:SQLDEV*/ REVERT /*END:SQLDEV*/
   v_u_name := USER ;
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
   -- if((@u_name is not null) and (@new_diagramname = @diagramname))	-- nothing will change
   --	return 0;
   IF ( v_u_name IS NULL ) THEN
    SELECT diagram_id 

     INTO v_DiagIdTarg
     FROM team01.sysdiagrams 
    WHERE  principal_id = v_theId
             AND NAME = v_new_diagramname;
   ELSE
      SELECT diagram_id 

        INTO v_DiagIdTarg
        FROM team01.sysdiagrams 
       WHERE  principal_id = v_owner_id
                AND NAME = v_new_diagramname;
   END IF;
   IF ( ( v_DiagIdTarg IS NOT NULL )
     AND v_DiagId <> v_DiagIdTarg ) THEN

   BEGIN
      utils.raiserror( 0, 'The name is already used.' );
      RETURN -2;

   END;
   END IF;
   IF ( v_u_name IS NULL ) THEN
    UPDATE team01.sysdiagrams
      SET name = v_new_diagramname,
          principal_id = v_theId
    WHERE  diagram_id = v_DiagId;
   ELSE
      UPDATE team01.sysdiagrams
         SET name = v_new_diagramname
       WHERE  diagram_id = v_DiagId;
   END IF;
   RETURN 0;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
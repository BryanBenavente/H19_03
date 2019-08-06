CREATE OR REPLACE PROCEDURE team01.sp_helpdiagrams
(
  v_diagramname IN VARCHAR2 DEFAULT NULL ,
  v_owner_id IN NUMBER DEFAULT NULL 
)AUTHID DEFINER
AS
   v_user VARCHAR2(128);
   v_dboLogin NUMBER(1,0);
   v_cursor SYS_REFCURSOR;

BEGIN

   /*TODO:SQLDEV*/ EXECUTE AS CALLER /*END:SQLDEV*/
   v_user := USER ;
   v_dboLogin := UTILS.CONVERT_TO_NUMBER(/*TODO:SQLDEV*/ IS_MEMBER('db_owner') /*END:SQLDEV*/,1,0) ;
   /*TODO:SQLDEV*/ REVERT /*END:SQLDEV*/
   OPEN  v_cursor FOR
      SELECT SYS_CONTEXT('USERENV','') Database  ,
             NAME Name  ,
             diagram_id ID  ,
             USER Owner  ,
             principal_id OwnerID  
        FROM sysdiagrams 
       WHERE  ( v_dboLogin = 1
                OR USER = v_user )
                AND ( v_diagramname IS NULL
                OR NAME = v_diagramname )
                AND ( v_owner_id IS NULL
                OR principal_id = v_owner_id )
        ORDER BY 4,
                 5,
                 1 ;
      DBMS_SQL.RETURN_RESULT(v_cursor);

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
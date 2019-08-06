CREATE OR REPLACE FUNCTION team01.sp_upgraddiagrams
RETURN NUMBER
AS

BEGIN

   IF utils.object_id(u'dbo.sysdiagrams') IS NOT NULL THEN
    RETURN 0;
   END IF;
   DELETE FROM team01.sysdiagrams;
   -- we may change it to varbinary(85)
   /* Add this if we need to have some form of extended properties for diagrams */
   /*
   		IF OBJECT_ID(N'dbo.sysdiagram_properties') IS NULL
   		BEGIN
   			CREATE TABLE dbo.sysdiagram_properties
   			(
   				diagram_id int,
   				name sysname,
   				value varbinary(max) NOT NULL
   			)
   		END
   		*/
   IF utils.object_id(u'dbo.dtproperties') IS NOT NULL THEN

   BEGIN
      INSERT INTO team01.sysdiagrams
        ( name, principal_id, version, definition )
        ( SELECT UTILS.CONVERT_TO_VARCHAR2(dgnm.uvalue,128) ,
                 DATABASE_PRINCIPAL_ID(u'dbo' 
                 ) ,-- will change to the sid of sa

                 0 ,-- zero for old format, dgdef.[version],

                 dgdef.lvalue 
          FROM team01.dtproperties dgnm
                 JOIN team01.dtproperties dggd   ON dggd.property = 'DtgSchemaGUID'
                 AND dggd.objectid = dgnm.objectid
                 JOIN team01.dtproperties dgdef   ON dgdef.property = 'DtgSchemaDATA'
                 AND dgdef.objectid = dgnm.objectid
           WHERE  dgnm.property = 'DtgSchemaNAME'
                    AND dggd.uvalue LIKE u'_EA3E6268-D998-11CE-9454-00AA00A3F36E_' );
      RETURN 2;

   END;
   END IF;
   RETURN 1;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
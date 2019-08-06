CREATE OR REPLACE FUNCTION team01.fn_diagramobjects
RETURN NUMBER
AUTHID DEFINER
AS
   v_id_upgraddiagrams NUMBER(10,0);
   v_id_sysdiagrams NUMBER(10,0);
   v_id_helpdiagrams NUMBER(10,0);
   v_id_helpdiagramdefinition NUMBER(10,0);
   v_id_creatediagram NUMBER(10,0);
   v_id_renamediagram NUMBER(10,0);
   v_id_alterdiagram NUMBER(10,0);
   v_id_dropdiagram NUMBER(10,0);
   v_InstalledObjects NUMBER(10,0);

BEGIN
   v_InstalledObjects := 0 ;
   v_id_upgraddiagrams := utils.object_id(u'dbo.sp_upgraddiagrams') ;
   v_id_sysdiagrams := utils.object_id(u'dbo.sysdiagrams') ;
   v_id_helpdiagrams := utils.object_id(u'dbo.sp_helpdiagrams') ;
   v_id_helpdiagramdefinition := utils.object_id(u'dbo.sp_helpdiagramdefinition') ;
   v_id_creatediagram := utils.object_id(u'dbo.sp_creatediagram') ;
   v_id_renamediagram := utils.object_id(u'dbo.sp_renamediagram') ;
   v_id_alterdiagram := utils.object_id(u'dbo.sp_alterdiagram') ;
   v_id_dropdiagram := utils.object_id(u'dbo.sp_dropdiagram') ;
   IF v_id_upgraddiagrams IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 1 ;
   END IF;
   IF v_id_sysdiagrams IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 2 ;
   END IF;
   IF v_id_helpdiagrams IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 4 ;
   END IF;
   IF v_id_helpdiagramdefinition IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 8 ;
   END IF;
   IF v_id_creatediagram IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 16 ;
   END IF;
   IF v_id_renamediagram IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 32 ;
   END IF;
   IF v_id_alterdiagram IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 64 ;
   END IF;
   IF v_id_dropdiagram IS NOT NULL THEN
    v_InstalledObjects := v_InstalledObjects + 128 ;
   END IF;
   RETURN v_InstalledObjects;

EXCEPTION WHEN OTHERS THEN utils.handleerror(SQLCODE,SQLERRM);
END;
/
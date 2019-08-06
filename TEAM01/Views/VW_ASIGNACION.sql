CREATE OR REPLACE FORCE VIEW team01.vw_asignacion (fecasig,dia,codmen) AS
SELECT FECASIG ,
          utils.datename('DW', FECASIG) DIA  ,
          CODMEN 
     FROM venta_team01.ASIGNACION 
    WHERE  FECASIG BETWEEN utils.dateadd('DAY', -3, SYSDATE) AND utils.dateadd('DAY', 4, SYSDATE);
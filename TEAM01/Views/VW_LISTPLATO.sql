CREATE OR REPLACE FORCE VIEW team01.vw_listplato (fecasig,tippla,nompla,fotpla,despla,prepla) AS
SELECT A.FECASIG ,
          P.TIPPLA ,
          P.NOMPLA ,
          P.FOTPLA ,
          P.DESPLA ,
          P.PREPLA 
     FROM venta_team01.ASIGNACION A
            JOIN venta_team01.MENU M   ON M.CODMEN = A.CODMEN
            JOIN venta_team01.MENU_DETALLE MD   ON MD.CODMEN = M.CODMEN
            JOIN venta_team01.PLATO P   ON P.CODPLA = MD.CODPLA;
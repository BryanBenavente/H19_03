CREATE OR REPLACE FORCE VIEW team01.vw_menusem (fecasig,dia,tippla,nompla,despla,prepla) AS
SELECT A.FECASIG ,
          utils.datename('DW', FECASIG) DIA  ,
          CASE P.TIPPLA
                       WHEN 'E' THEN 'Entrada'
                       WHEN 'S' THEN 'Segundo'
                       WHEN 'P' THEN 'Bebida'
                       WHEN 'B' THEN 'Bebida'   END TIPPLA  ,
          P.NOMPLA ,
          P.DESPLA ,
          P.PREPLA 
     FROM venta_team01.ASIGNACION A
            JOIN venta_team01.MENU M   ON M.CODMEN = A.CODMEN
            JOIN venta_team01.MENU_DETALLE MD   ON MD.CODMEN = M.CODMEN
            JOIN venta_team01.PLATO P   ON P.CODPLA = MD.CODPLA
    WHERE  A.FECASIG BETWEEN utils.dateadd('DAY', -3, SYSDATE) AND utils.dateadd('DAY', 4, SYSDATE);
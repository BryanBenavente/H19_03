CREATE OR REPLACE FORCE VIEW team01.vw_cocina (tippla,cant,cante,cants,cantp) AS
SELECT PLATO.TIPPLA ,
          SUM(CANT)  CANT  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(SUM(CANT) ,4) 
                        FROM venta_team01.VENTA_DETALLE 
                               LEFT JOIN venta_team01.VENTA    ON VENTA.CODVEN = VENTA_DETALLE.CODVEN
                               LEFT JOIN venta_team01.PLATO    ON PLATO.CODPLA = VENTA_DETALLE.CODPLA
                         WHERE  VENTA.FECVEN = UTILS.CONVERT_TO_VARCHAR2(SYSDATE,12,p_style=>111)
                                  AND ESTDETVENT = 'A'
                                  AND TIPPLA = 'E'
                          GROUP BY TIPPLA ), 1, 1, ' ') CANTE  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(SUM(CANT) ,4) 
                        FROM venta_team01.VENTA_DETALLE 
                               LEFT JOIN venta_team01.VENTA    ON VENTA.CODVEN = VENTA_DETALLE.CODVEN
                               LEFT JOIN venta_team01.PLATO    ON PLATO.CODPLA = VENTA_DETALLE.CODPLA
                         WHERE  VENTA.FECVEN = UTILS.CONVERT_TO_VARCHAR2(SYSDATE,12,p_style=>111)
                                  AND ESTDETVENT = 'A'
                                  AND TIPPLA = 'S'
                          GROUP BY TIPPLA ), 1, 1, ' ') CANTS  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(SUM(CANT) ,4) 
                        FROM venta_team01.VENTA_DETALLE 
                               LEFT JOIN venta_team01.VENTA    ON VENTA.CODVEN = VENTA_DETALLE.CODVEN
                               LEFT JOIN venta_team01.PLATO    ON PLATO.CODPLA = VENTA_DETALLE.CODPLA
                         WHERE  VENTA.FECVEN = UTILS.CONVERT_TO_VARCHAR2(SYSDATE,12,p_style=>111)
                                  AND ESTDETVENT = 'A'
                                  AND TIPPLA = 'P'
                          GROUP BY TIPPLA ), 1, 1, ' ') CANTP  
     FROM venta_team01.VENTA_DETALLE 
            LEFT JOIN venta_team01.VENTA    ON VENTA.CODVEN = VENTA_DETALLE.CODVEN
            LEFT JOIN venta_team01.PLATO    ON PLATO.CODPLA = VENTA_DETALLE.CODPLA
    WHERE  VENTA.FECVEN = UTILS.CONVERT_TO_VARCHAR2(SYSDATE,12,p_style=>111)
             AND ESTDETVENT = 'A'
             AND TIPPLA = 'B'
     GROUP BY TIPPLA;
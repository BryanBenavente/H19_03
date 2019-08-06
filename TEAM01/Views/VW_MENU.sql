CREATE OR REPLACE FORCE VIEW team01.vw_menu (codasig,codmen,codent,entrada,pent,codseg,segundo,pseg,codpos,postre,ppos,codbeb,bebida,pbeb) AS
SELECT ASIGNACION.CODASIG ,
          ASIGNACION.CODMEN ,
          PLATO.CODPLA CODENT  ,
          NOMPLA ENTRADA  ,
          PREPLA PENT  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PLATO.CODPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'S' ), 1, 1, ' ') CODSEG  ,
          utils.stuff(( SELECT ',' || NOMPLA 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'S' ), 1, 1, ' ') SEGUNDO  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PREPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'S' ), 1, 1, ' ') PSEG ,-->SEGUNDO

          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PLATO.CODPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'P' ), 1, 1, ' ') CODPOS  ,
          utils.stuff(( SELECT ',' || NOMPLA 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'P' ), 1, 1, ' ') POSTRE  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PREPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'P' ), 1, 1, ' ') PPOS ,--> POSTRE

          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PLATO.CODPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'B' ), 1, 1, ' ') CODBEB  ,
          utils.stuff(( SELECT ',' || NOMPLA 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'B' ), 1, 1, ' ') BEBIDA  ,
          utils.stuff(( SELECT ',' || UTILS.CONVERT_TO_VARCHAR2(PREPLA,8) 
                        FROM venta_team01.ASIGNACION 
                               JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
                               JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
                         WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
                                  AND TIPPLA = 'B' ), 1, 1, ' ') PBEB --> BEBIDA
            
     FROM venta_team01.ASIGNACION 
            JOIN venta_team01.MENU_DETALLE    ON MENU_DETALLE.CODMEN = ASIGNACION.CODMEN
            JOIN venta_team01.PLATO    ON PLATO.CODPLA = MENU_DETALLE.CODPLA
    WHERE  FECASIG = UTILS.CONVERT_TO_VARCHAR2(SYSDATETIME(),10)
             AND TIPPLA = 'E';
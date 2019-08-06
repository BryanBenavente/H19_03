CREATE TABLE venta_team01.venta_detalle (
  coddetven NUMBER(11) NOT NULL,
  codven CHAR(8 BYTE),
  codasigmen NUMBER(11),
  codpla NUMBER(11),
  codpro NUMBER(11),
  cant NUMBER(11),
  obsvendet VARCHAR2(50 BYTE),
  estdetvent CHAR,
  CONSTRAINT venta_detalle_pk PRIMARY KEY (coddetven)
);
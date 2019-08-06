CREATE TABLE venta_team01.venta (
  codven CHAR(8 BYTE) NOT NULL,
  fecven DATE,
  codcli NUMBER(11),
  codmes NUMBER(11),
  estven CHAR,
  tipven CHAR,
  CONSTRAINT venta_pk PRIMARY KEY (codven)
);
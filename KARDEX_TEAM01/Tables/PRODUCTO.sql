CREATE TABLE kardex_team01.producto (
  codpro NUMBER(11) NOT NULL,
  nompro VARCHAR2(50 BYTE),
  catpro VARCHAR2(30 BYTE),
  unipro VARCHAR2(3 BYTE),
  estpro CHAR,
  cantpro NUMBER(11),
  CONSTRAINT producto_pk PRIMARY KEY (codpro)
);
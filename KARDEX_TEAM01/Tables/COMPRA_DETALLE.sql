CREATE TABLE kardex_team01.compra_detalle (
  coddetcomp NUMBER(11) NOT NULL,
  codcomp CHAR(8 BYTE),
  codpro NUMBER(11),
  cantpro NUMBER(11),
  CONSTRAINT compra_detalle_pk PRIMARY KEY (coddetcomp)
);
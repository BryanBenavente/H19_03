CREATE TABLE kardex_team01.compra (
  codcomp CHAR(8 BYTE) NOT NULL,
  feccomp DATE,
  codper NUMBER(11),
  codprov NUMBER(11),
  CONSTRAINT compra_pk PRIMARY KEY (codcomp)
);
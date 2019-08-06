CREATE TABLE kardex_team01.proveedor (
  codprov NUMBER(11) NOT NULL,
  nomprov VARCHAR2(30 BYTE),
  tipprov VARCHAR2(30 BYTE),
  rucprov CHAR(11 BYTE),
  telfprov VARCHAR2(14 BYTE),
  dirprov VARCHAR2(200 BYTE),
  estprov CHAR,
  codubi CHAR(6 BYTE),
  CONSTRAINT codprov_pk PRIMARY KEY (codprov)
);
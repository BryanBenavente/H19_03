CREATE TABLE venta_team01.plato (
  codpla NUMBER(11) NOT NULL,
  nompla VARCHAR2(50 BYTE),
  despla VARCHAR2(150 BYTE),
  prepla NUMBER,
  tippla CHAR,
  estpla CHAR,
  fotpla VARCHAR2(500 BYTE),
  CONSTRAINT plato_pk PRIMARY KEY (codpla)
);
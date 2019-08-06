CREATE TABLE venta_team01.movimiento (
  idmov NUMBER(11) NOT NULL,
  fecmov DATE,
  codpro NUMBER(11),
  ingreso NUMBER(11),
  salida NUMBER(11),
  stock NUMBER(11),
  tipmov CHAR,
  CONSTRAINT pk_codinv PRIMARY KEY (idmov)
);
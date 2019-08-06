CREATE TABLE team01.persona (
  codper NUMBER(11) NOT NULL,
  nomper VARCHAR2(50 BYTE),
  apeper VARCHAR2(80 BYTE),
  dniper VARCHAR2(11 BYTE),
  celper CHAR(9 BYTE),
  dirper VARCHAR2(200 BYTE),
  codubi CHAR(6 BYTE),
  tipper CHAR,
  estper CHAR,
  CONSTRAINT persona_pk PRIMARY KEY (codper),
  CONSTRAINT persona_ubigeo FOREIGN KEY (codubi) REFERENCES team01.ubigeo (codubi)
);
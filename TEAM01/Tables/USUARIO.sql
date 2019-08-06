CREATE TABLE team01.usuario (
  codusu NUMBER(11) NOT NULL,
  codper NUMBER(11),
  usuper VARCHAR2(30 BYTE),
  pasper VARCHAR2(50 BYTE),
  CONSTRAINT usuario_pk PRIMARY KEY (codusu),
  CONSTRAINT usuario_persona FOREIGN KEY (codper) REFERENCES team01.persona (codper)
);
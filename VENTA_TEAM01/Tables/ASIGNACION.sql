CREATE TABLE venta_team01.asignacion (
  codasig NUMBER(11) NOT NULL,
  fecasig DATE,
  codmen NUMBER(11),
  CONSTRAINT asignacion_pk PRIMARY KEY (codasig),
  CONSTRAINT asignacion_menu FOREIGN KEY (codmen) REFERENCES venta_team01.menu (codmen)
);
CREATE TABLE venta_team01.menu_detalle (
  coddetmen NUMBER(11) NOT NULL,
  codmen NUMBER(11),
  codpla NUMBER(11),
  CONSTRAINT menu_detalle_pk PRIMARY KEY (coddetmen),
  CONSTRAINT menu_detalle_menu FOREIGN KEY (codmen) REFERENCES venta_team01.menu (codmen),
  CONSTRAINT menu_detalle_plato FOREIGN KEY (codpla) REFERENCES venta_team01.plato (codpla)
);
INSERT INTO PERSONA.UBIGEO
	(CODUBI, DISTUBI, PROUBI, DEPUBI)
VALUES
	('150501','Imperial','Cañete','Lima'),
	('150502','San Vicente','Cañete','Lima'),
	('150401','Chincha Alta','Chincha','Lima'),
	('150402','Chincha Baja','Chincha','Lima'),
	('150601','Atte Vitarte','Lima Metropolitana','Lima'),
	('150602','La victoria','Lima','Lima') 


INSERT INTO PERSONA.PERSONA
	(NOMPER, APEPER, DNIPER, CELPER, DIRPER, CODUBI, TIPPER)
VALUES
	('Alexander','Cárdenas','74120152','987456321', 'av. las malvinas', '150501', 'C'),
	('Pedro','López','04180152','987450321', 'av. las malvinas', '150501', 'C'),
	('Jorge','Poemape','84120102','980456301', 'av. las malvinas', '150501', 'C'),
	('Alberto','Zelada','75410455',' ', 'av. las malvinas', '150501', 'C'),
	('Jaime','De la Cruz','44120152','980406321', 'av. las malvinas', '150501', 'C')


INSERT INTO VENTA.EQUIPO
	(NOMEQUI, DESCEQU, CATEQUI, PREEQUI)
VALUES
	('teclados HP','','TC',120.0),
	('Computadora','','CP',2020.0)

INSERT INTO  PERSONA.SUCURSAL
	(NOMSUC, DESCSUC, DIRSUC, CODUBI, ESTSUC)
VALUES
	('las viñas', 'sucursal central', 'Av. las marinas', '150501', 'A')
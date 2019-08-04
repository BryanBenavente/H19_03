USE [VENTA]
GO
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150401', N'Chincha Alta', N'Chincha', N'Lima')
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150402', N'Chincha Baja', N'Chincha', N'Lima')
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150501', N'Imperial', N'Cañete', N'Lima')
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150502', N'San Vicente', N'Cañete', N'Lima')
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150601', N'Atte Vitarte', N'Lima Metropolitana', N'Lima')
INSERT [PERSONA].[UBIGEO] ([CODUBI], [DISTUBI], [PROUBI], [DEPUBI]) VALUES (N'150602', N'La victoria', N'Lima', N'Lima')
SET IDENTITY_INSERT [PERSONA].[SUCURSAL] ON 

INSERT [PERSONA].[SUCURSAL] ([IDSUC], [NOMSUC], [DESCSUC], [DIRSUC], [CODUBI], [ESTSUC]) VALUES (1, N'Las viñas', N'Sucursal central', N'Av. las marinas', N'150501', N'A')
INSERT [PERSONA].[SUCURSAL] ([IDSUC], [NOMSUC], [DESCSUC], [DIRSUC], [CODUBI], [ESTSUC]) VALUES (2, N'Los olivos', N'sads', N'Av. las marinas', N'150401', N'A')
INSERT [PERSONA].[SUCURSAL] ([IDSUC], [NOMSUC], [DESCSUC], [DIRSUC], [CODUBI], [ESTSUC]) VALUES (3, N'Computech A', N'Distribuidora de equipos', N'Av. San juan', N'150401', N'A')
SET IDENTITY_INSERT [PERSONA].[SUCURSAL] OFF
SET IDENTITY_INSERT [PERSONA].[PERSONA] ON 

INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (1, N'Alexander', N'Cárdenas', N'74120152', N'987456321', N'av. las malvinas', N'150501', N'C', NULL, NULL, NULL, N'I')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (2, N'Pedro', N'López', N'04180152', N'987450321', N'av. las malvinas', N'150501', N'C', NULL, NULL, NULL, N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (3, N'Jorge', N'Poemape', N'84120102', N'980456301', N'av. las malvinas', N'150501', N'C', NULL, NULL, NULL, N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (4, N'Alberto', N'Zelada', N'75410455', N'999000000', N'av. las malvinas', N'150502', N'C', NULL, NULL, N'd41d8cd98f00b204e9800998ecf8427e', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (5, N'Jaime Jorge', N'De la Cruz', N'44120152', N'980406321', N'av. las malvinas', N'150501', N'V', NULL, N'123', N'202cb962ac59075b964b07152d234b70', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (6, N'Bryan', N'Benavente Casas', N'71431184', N'976315987', N'Av. la mar Nº 586', N'150501', N'A', 1, N'admin', N'21232f297a57a5a743894a0e4a801fc3', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (7, N'Angel Moises', N'Benavente Casas', N'71431190', N'989219319', N'Av. la mar Nº 586', N'150501', N'J', 1, N'angel', N'f4f068e71e0d87bf0ad51e6214ab84e9', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (8, N'Alex Jaime', N'Benavente Deza', N'02431558', N'980740291', N'Jr. 15 de Noviembre Nº586', N'150501', N'J', 1, N'jefe', N'8d6d3e8b969523e95759e85628aec9ce', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (9, N'Alexandra Hillary', N'Benavente Casas', N'71431183', N'981032131', N'Av. la mar', N'150501', N'J', 2, N'vendedor3', N'0953ce35a1c04be5eaa07cb81c768eae', N'A')
INSERT [PERSONA].[PERSONA] ([IDPER], [NOMPER], [APEPER], [DNIPER], [CELPER], [DIRPER], [CODUBI], [TIPPER], [IDSUC], [USUPER], [PASPER], [ESTPER]) VALUES (10, N'Arturo', N'Cavero López', N'78102312', N'989123320', N'Av. los libertadores Mz E Lt 5', N'150502', N'V', 2, N'vendedor1', N'22981ee8bebef1155b820e13b18f0e53', N'A')
SET IDENTITY_INSERT [PERSONA].[PERSONA] OFF
INSERT [VENTA].[VENTA] ([IDVEN], [IDPER], [IDVED], [FECVEN], [ESTVEN]) VALUES (1, 6, NULL, CAST(N'2019-08-02' AS Date), N'A')
INSERT [VENTA].[VENTA] ([IDVEN], [IDPER], [IDVED], [FECVEN], [ESTVEN]) VALUES (2, 6, NULL, CAST(N'2019-08-02' AS Date), N'A')
INSERT [VENTA].[VENTA] ([IDVEN], [IDPER], [IDVED], [FECVEN], [ESTVEN]) VALUES (3, 4, NULL, CAST(N'2019-08-04' AS Date), N'A')
INSERT [VENTA].[VENTA] ([IDVEN], [IDPER], [IDVED], [FECVEN], [ESTVEN]) VALUES (4, 8, NULL, CAST(N'2019-08-04' AS Date), N'A')
SET IDENTITY_INSERT [VENTA].[EQUIPO] ON 

INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (1, N'Teclado AS', N'', N'PF', 26, N'A', N'http://d26lpennugtm8s.cloudfront.net/stores/349/695/products/k120_11-c48d1e2f354a86573a15398975703670-640-0.jpg', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (2, N'Computador', N'', N'CP', 13, N'A', N'https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/1/9/191628179022_4.jpg', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (3, N'Celular Nokia', N'A34 tamaño 12', N'TB', 28, N'A', N'https://cdn1.coppel.com/images/catalog/pm/2029643-1.jpg', N'Motorola')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (4, N'L450', N'Cartucho de 345', N'DM', 45, N'A', N'https://http2.mlstatic.com/impresora-epson-l3110-ecotank-sist-continuo-4-tintas-1143-D_NQ_NP_915980-MLA31044902197_062019-Q.jpg', N'Lenovo')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (6, N'LED XII K', N'', N'TV', 28, N'A', N'https://http2.mlstatic.com/pantalla-computadora-lg-D_NQ_NP_635649-MLV28305169107_102018-Q.jpg', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (7, N'Impresora LDF', N'Impresora de cartucho', N'DM', 0, N'A', N'https://http2.mlstatic.com/impresora-epson-l3110-ecotank-sist-continuo-4-tintas-1143-D_NQ_NP_915980-MLA31044902197_062019-Q.jpg', N'EPSON')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (8, N'Prueba', N'asfdsgsdad', N'CP', 0, N'I', N'', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (9, N'Laptop', N'', N'LP', 0, N'A', N'', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (10, N'sdfg', N'ghjk', N'LP', 0, N'A', N'', N'sdfgh')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (11, N'fe', N'dfgh', N'LP', 0, N'I', N'', N'hop')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (12, N'Galaxy SV', N'', N'TB', 90, N'A', N'', N'Samsung')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (13, N'Galaxy SVI', N'', N'TB', 15, N'A', N'', N'Samsung')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (14, N'Galaxy Plus', N'', N'TB', 0, N'A', N'', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (15, N'Impresora Laser', N'', N'DM', 0, N'A', N'', N'HP')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (16, N'JV', N'', N'TB', 0, N'A', N'https://media.aws.alkosto.com/media/catalog/product/cache/6/image/69ace863370f34bdf190e4e164b6e123/1/9/191628179022_4.jpg', N'Samsung')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (17, N'Tablet 234', N'', N'TB', 19, N'A', N'https://images-na.ssl-images-amazon.com/images/I/61IpbbZpDpL._SL1500_.jpg', N'Lenovo')
INSERT [VENTA].[EQUIPO] ([IDEQU], [NOMEQUI], [DESCEQU], [CATEQUI], [CANTEQU], [ESTEQU], [IMGEQU], [MAREQU]) VALUES (18, N'Tablet MQ', N'', N'TB', 18, N'A', N'https://images-na.ssl-images-amazon.com/images/I/719Sf-ZpH3L._SY606_.jpg', N'HP')
SET IDENTITY_INSERT [VENTA].[EQUIPO] OFF
SET IDENTITY_INSERT [VENTA].[MOVIMIENTO] ON 

INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (1, 7, 1, CAST(N'2019-08-02' AS Date), 5, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (2, 7, 1, CAST(N'2019-08-02' AS Date), 15, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (3, 7, 2, CAST(N'2019-08-02' AS Date), 16, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (4, 7, 1, CAST(N'2019-08-02' AS Date), 10, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (5, 7, 3, CAST(N'2019-08-02' AS Date), 30, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (6, 1, 3, CAST(N'2019-08-02' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (7, 1, 1, CAST(N'2019-08-02' AS Date), 2, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (8, 1, 2, CAST(N'2019-08-02' AS Date), 2, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (9, 1, 1, CAST(N'2019-08-02' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (10, 1, 2, CAST(N'2019-08-04' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (11, 1, 1, CAST(N'2019-08-04' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (12, 7, 6, CAST(N'2019-08-04' AS Date), 30, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (13, 7, 12, CAST(N'2019-08-04' AS Date), 90, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (14, 7, 4, CAST(N'2019-08-04' AS Date), 45, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (15, 7, 1007, CAST(N'2019-08-04' AS Date), 20, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (16, 7, 1008, CAST(N'2019-08-04' AS Date), 20, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (17, 1002, 13, CAST(N'2019-08-04' AS Date), 15, N'I', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (18, 1, 1008, CAST(N'2019-08-04' AS Date), 2, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (19, 1, 3, CAST(N'2019-08-04' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (20, 1, 1007, CAST(N'2019-08-04' AS Date), 1, N'V', N'A')
INSERT [VENTA].[MOVIMIENTO] ([IDMOV], [IDPER], [IDEQU], [FECMOV], [CANTMOV], [TIPMOV], [ESTMOV]) VALUES (21, 1, 6, CAST(N'2019-08-04' AS Date), 2, N'V', N'A')
SET IDENTITY_INSERT [VENTA].[MOVIMIENTO] OFF
SET IDENTITY_INSERT [VENTA].[VENTA_DETALLE] ON 

INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (1, 1, 3, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (2, 1, 1, 2)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (3, 1, 2, 2)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (4, 2, 1, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (5, 3, 2, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (6, 3, 1, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (7, 3, 1008, 2)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (8, 3, 3, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (9, 4, 1007, 1)
INSERT [VENTA].[VENTA_DETALLE] ([IDVENDET], [IDVEN], [IDEQU], [CANT]) VALUES (10, 4, 6, 2)
SET IDENTITY_INSERT [VENTA].[VENTA_DETALLE] OFF
SET IDENTITY_INSERT [VENTA].[PRECIO] ON 

INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1, 1, CAST(35.00 AS Decimal(8, 2)), CAST(50.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (2, 2, CAST(1900.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (4, 9, CAST(1770.00 AS Decimal(8, 2)), CAST(2200.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (5, 7, CAST(1700.00 AS Decimal(8, 2)), CAST(2000.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (6, 1, CAST(30.00 AS Decimal(8, 2)), CAST(45.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (7, 3, CAST(1500.00 AS Decimal(8, 2)), CAST(1895.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (8, 4, CAST(1200.00 AS Decimal(8, 2)), CAST(1650.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (9, 6, CAST(600.00 AS Decimal(8, 2)), CAST(950.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (10, 8, CAST(200.00 AS Decimal(8, 2)), CAST(120.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (11, 8, CAST(45.00 AS Decimal(8, 2)), CAST(120.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (12, 8, CAST(2000.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (13, 11, CAST(800.00 AS Decimal(8, 2)), CAST(900.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (14, 1, CAST(56.00 AS Decimal(8, 2)), CAST(45.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (15, 12, CAST(0.00 AS Decimal(8, 2)), CAST(0.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (16, 13, CAST(500.00 AS Decimal(8, 2)), CAST(1000.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (17, 14, CAST(3400.00 AS Decimal(8, 2)), CAST(5678.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (18, 2, CAST(0.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (19, 2, CAST(1200.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (20, 12, CAST(1200.00 AS Decimal(8, 2)), CAST(1500.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (21, 12, CAST(980.00 AS Decimal(8, 2)), CAST(1500.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (22, 7, CAST(1700.00 AS Decimal(8, 2)), CAST(2000.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (23, 1, CAST(30.00 AS Decimal(8, 2)), CAST(45.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (24, 2, CAST(1200.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (25, 15, CAST(1400.00 AS Decimal(8, 2)), CAST(1560.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1002, 1006, CAST(1400.00 AS Decimal(8, 2)), CAST(1560.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1003, 6, CAST(600.00 AS Decimal(8, 2)), CAST(950.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1004, 14, CAST(3400.00 AS Decimal(8, 2)), CAST(5678.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1005, 6, CAST(600.00 AS Decimal(8, 2)), CAST(950.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1006, 7, CAST(1700.00 AS Decimal(8, 2)), CAST(2000.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1007, 9, CAST(1770.00 AS Decimal(8, 2)), CAST(2200.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1008, 12, CAST(980.00 AS Decimal(8, 2)), CAST(1500.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1009, 1, CAST(30.00 AS Decimal(8, 2)), CAST(45.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1010, 2, CAST(1200.00 AS Decimal(8, 2)), CAST(2450.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1011, 3, CAST(1500.00 AS Decimal(8, 2)), CAST(1895.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1012, 4, CAST(1200.00 AS Decimal(8, 2)), CAST(1650.00 AS Decimal(8, 2)), N'I')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1013, 4, CAST(1200.00 AS Decimal(8, 2)), CAST(1650.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1014, 1007, CAST(450.00 AS Decimal(8, 2)), CAST(700.00 AS Decimal(8, 2)), N'A')
INSERT [VENTA].[PRECIO] ([IDPRE], [IDEQU], [PRECOM], [PREVEN], [ESTPRE]) VALUES (1015, 1008, CAST(450.00 AS Decimal(8, 2)), CAST(550.00 AS Decimal(8, 2)), N'A')
SET IDENTITY_INSERT [VENTA].[PRECIO] OFF

-- Insertar tallas
INSERT INTO Talla (id, nombre) VALUES (1, 'S');
INSERT INTO Talla (id, nombre) VALUES (2, 'M');
INSERT INTO Talla (id, nombre) VALUES (3, 'L');
INSERT INTO Talla (id, nombre) VALUES (4, 'XL');
INSERT INTO Talla (id, nombre) VALUES (5, 'SN');

-- Insertar marcas
INSERT INTO Marca (id, nombre) VALUES (1, 'ORBEA');
INSERT INTO Marca (id, nombre) VALUES (2, 'CANNONDALE');
INSERT INTO Marca (id, nombre) VALUES (3, 'SPECIALIZED');
INSERT INTO Marca (id, nombre) VALUES (4, 'MEGAMO');
INSERT INTO Marca (id, nombre) VALUES (5, 'MMR');
INSERT INTO Marca (id, nombre) VALUES (6, 'BTWIN');
INSERT INTO Marca (id, nombre) VALUES (7, 'SHIMANO');
INSERT INTO Marca (id, nombre) VALUES (8, 'SRAM');
INSERT INTO Marca (id, nombre) VALUES (9, 'GIRO');
INSERT INTO Marca (id, nombre) VALUES (10, 'ENDURA');
INSERT INTO Marca (id, nombre) VALUES (11, 'LEZYNE');
INSERT INTO Marca (id, nombre) VALUES (12, 'GARMIN');
INSERT INTO Marca (id, nombre) VALUES (13, 'GIRO');

-- Insertar colores
INSERT INTO Color (id, nombre) VALUES (1, 'Rojo');
INSERT INTO Color (id, nombre) VALUES (2, 'Azul');
INSERT INTO Color (id, nombre) VALUES (3, 'Verde');
INSERT INTO Color (id, nombre) VALUES (4, 'Negro');
INSERT INTO Color (id, nombre) VALUES (5, 'Blanco');

-- Insertar productos
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (1, 'Bicicleta Orbea Alma M50', 1999.00, 1599.00, 'https://www.fabreguesbicicletas.es/1560522-large_default/bicicleta-orbea-alma-m50-2023-n219.jpg', 'La Orbea Alma M50 es una bicicleta de montaña de alto rendimiento, ideal para competiciones de cross-country.', 1, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (2, 'Bicicleta Cannondale Scalpel Carbon SE 1', 6499.00, 5199.00, 'https://embed.widencdn.net/img/dorelrl/ou3jhkydp5/1700px@1x/C21_C24251M_Scalpel_Crb_SE_1_ABB_PD.webp?color=E2ECF2&q=99', 'La Cannondale Scalpel Carbon SE 1 es una bicicleta de montaña diseñada para el rendimiento en competiciones de cross-country y trail.', 2, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (3, 'Bicicleta Specialized Stumpjumper Expert 29', 6299.00, 5029.00, 'https://assets.specialized.com/i/specialized/95718-31_SJ-FSR-MEN-EXPERT-CARBON-29-STRMGRY-RKTRED_HERO?$scom-pdp-product-image$&fmt=auto', 'La Specialized Stumpjumper Expert 29 es una bicicleta de trail versátil y ágil, ideal para disfrutar de terrenos variados con confianza.', 3, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (4, 'Bicicleta Megamo Natural 50', 1199.00, 959.00, 'https://www.megamo.com/tmp/images/BIBLIOTECA_FOTOS_ERP_16602_W_1200_Q_100.PNG', 'La Megamo Natural 50 es una bicicleta de montaña versátil y resistente, perfecta para iniciarse en el mundo del ciclismo de montaña.', 4, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (5, 'Bicicleta MMR Rakish SL 70', 2699.00, 2159.00, 'https://mmrbikes.com/cdn/shop/products/75093_RAKISH_00_PEARL_WHITE.N.BLACK-min_0c44b30c-114a-4979-b01c-6e39b6c1e936.jpg?v=1683814419&width=1680', 'La MMR Rakish SL 70 es una bicicleta de carretera de alto rendimiento, diseñada para competiciones y entrenamientos exigentes.', 5, 'BICICLETAS');

INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (6, 'Manillar Btwin Rockrider', 29.99, 19.99, 'https://contents.mediadecathlon.com/p1708811/k$7eeaa6b6b64fbcdac1a47d360d593baa/sq/manillar-bicicleta-montana-diametro-318-mm-longitud-760-mm-elevado-30-mm.jpg?format=auto&f=800x0', 'El manillar Btwin Rockrider es ligero y resistente, ideal para el ciclismo de montaña recreativo.', 6, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (7, 'Cambio Shimano Deore XT M8100', 129.99, 99.99, 'https://dassets.shimano.com/content/dam/global/cg1SHICCycling/final/products/cg2SHICComponent/cg3SHICRearDerailleur/cg4SHICRearDerailleur/RD-M8100-SGS_C219_1.jpg/jcr:content/renditions/RD-M8100-SGS_C219_1_750_750.jpeg', 'La potencia Shimano Deore XT M8100 ofrece un diseño resistente y un excelente rendimiento en las condiciones más exigentes del ciclismo de montaña.', 7, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (8, 'Freno Sram GX Eagle', 499.00, 399.00, 'https://cdn.deporvillage.com/cdn-cgi/image/h=1800,w=1800,dpr=1,f=auto,q=75,fit=contain,background=white/product/sr-00.7018.431.000.jpg', 'El freno Sram GX Eagle ofrece una potencia de frenado excepcional y un control óptimo en todo tipo de terrenos, desde descensos técnicos hasta senderos de cross-country.', 8, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (9, 'Casco Giro Montaro MIPS', 149.99, 119.99, 'https://www.bfgcdn.com/1500_1500_90/851-0187/giro-montaro-mips-casco-de-ciclismo-detail-2.jpg', 'El casco Giro Montaro MIPS ofrece una excelente protección y comodidad para el ciclismo de montaña agresivo.', 9, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (10, 'Protector Endura MT500', 79.99, 59.99, 'https://cdn.idealo.com/folder/Product/202876/0/202876006/s11_produktbild_max/endura-mt500-d3o-protector-vest-black-orange.jpg', 'El protector Endura MT500 ofrece una protección adicional para tus rodillas y codos durante las rutas de enduro y descenso.', 10, 'COMPONENTES');

INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (11, 'Chaqueta Specialized Element', 149.99, 119.99, 'https://jormabike.com/44956-thickbox_default/chaqueta-specialized-element-rbx-comp-team-ni-o.jpg', 'La chaqueta Specialized Element ofrece protección contra el viento y la lluvia, manteniéndote cómodo en condiciones climáticas adversas.', 11, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (12, 'Guantes Giro DND', 24.99, 19.99, 'https://ik.imagekit.io/w4c/santafixiecom/catalog/product/cache/e716fc8f32d310560199b44cedc4c64b/g/u/guantes-giro-dnd-lime--bre.jpg', 'Los guantes Giro DND son duraderos y cómodos, ideales para proteger tus manos durante tus rutas en bicicleta de montaña.', 12, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (13, 'Calcetines Giro HRC Team', 14.99, 9.99, 'https://www.fabreguesbicicletas.es/1292674-large_default/calcetines-giro-hrc-team-3unds-azul-amarillo-fluor-naranja.jpg', 'Los calcetines Giro HRC Team ofrecen comodidad y rendimiento para tus salidas en bicicleta de carretera y montaña.', 13, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (14, 'Maillot Endura MT500', 89.99, 69.99, 'https://www.apedals.es/cdn/shop/products/endura-mt500-ink-l-s-t-ltd-maillot-de-ciclismo.jpg?v=1678399253', 'El maillot Endura MT500 ofrece comodidad y durabilidad para tus rutas de enduro y descenso en bicicleta de montaña.', 10, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (15, 'Gafas Giro Blok', 59.99, 39.99, 'https://endubikes.com/wp-content/uploads/2021/04/Gafas-Mascara-Giro-Blok-NegroRojo-1.jpg', 'Las gafas Giro Blok ofrecen protección y estilo para tus salidas en bicicleta de carretera y montaña.', 13, 'ROPAYEQUIPAMIENTO');

INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (16, 'Cuentakilómetros Garmin Edge 130 Plus', 199.99, 159.99, 'https://www.worten.es/i/82a9e7f999af65abf8e025ff6a4fcc451bbba9c2.jpg', 'El cuentakilómetros Garmin Edge 130 Plus ofrece funciones avanzadas de navegación y seguimiento de rendimiento para mejorar tus entrenamientos y salidas.', 12, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (17, 'Luces Lezyne Micro Drive 600XL', 49.99, 39.99, 'https://cdn2.lvr-cycles.com/2087-large_default/lezyne-micro-drive-600xl-av-ar-pack-d-eclairage-velo-led-usb.jpg', 'Las luces Lezyne Micro Drive 600XL ofrecen visibilidad y seguridad durante tus salidas nocturnas en bicicleta.', 11, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (18, 'Portabidón Syncros', 14.99, 9.99, 'https://cdn1.biciescapa.com/67468-large_default/portabidon-syncros-syncros-tailor-cage-10-r-68907.jpg.webp', 'El portabidón Syncros ofrece un agarre seguro para tu botella de agua durante tus rutas en bicicleta.', 4, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (19, 'Selle Italia Model X (MMR)', 59.99, 44.99, 'https://www.tradeinn.com/f/13808/138083797_3/selle-italia-sillin-model-x-green-superflow.jpg', 'El sillín Selle Italia Model X montado en bicis MMR ofrece comodidad y rendimiento para tus salidas en bicicleta de carretera y montaña.', 5, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (20, 'Pedales Shimano PD-M520', 49.99, 39.99, 'https://dassets.shimano.com/content/dam/global/cg1SHICCycling/final/products/cg2SHICComponent/cg3SHICPedal/cg4SHICPedalSPD/PD-M520-shic138-1.jpg/jcr:content/renditions/PD-M520-shic138-1_750_750.jpeg', 'Los pedales Shimano PD-M520 ofrecen un rendimiento fiable y duradero para tus salidas en bicicleta de montaña y carretera.', 7, 'ACCESORIOS');

-- Asociaciones producto-talla para productos de bicicletas y ropa
INSERT INTO producto_talla (producto_id, talla_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 1), (2, 2), (2, 3), (2, 4),
(3, 1), (3, 2), (3, 3), (3, 4),
(4, 1), (4, 2), (4, 3), (4, 4),
(5, 1), (5, 2), (5, 3), (5, 4),
(11, 1), (11, 2), (11, 3), (11, 4),
(12, 1), (12, 2), (12, 3), (12, 4),
(13, 1), (13, 2), (13, 3), (13, 4),
(14, 1), (14, 2), (14, 3), (14, 4),
(15, 1), (15, 2), (15, 3), (15, 4);

-- Asociaciones producto-color para productos de bicicletas y ropa
INSERT INTO producto_color (producto_id, color_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5),
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5),
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5),
(11, 1), (11, 2), (11, 3), (11, 4), (11, 5),
(12, 1), (12, 2), (12, 3), (12, 4), (12, 5),
(13, 1), (13, 2), (13, 3), (13, 4), (13, 5),
(14, 1), (14, 2), (14, 3), (14, 4), (14, 5),
(15, 1), (15, 2), (15, 3), (15, 4), (15, 5);

-- Asociaciones producto-talla para productos de componente y accesorio
INSERT INTO producto_talla (producto_id, talla_id) VALUES
(6, 5), (7, 5), (8, 5), (9, 5), (10, 5),
(16, 5), (17, 5), (18, 5), (19, 5), (20, 5);

-- Asociaciones producto-color para productos de componente y accesorio
INSERT INTO producto_color (producto_id, color_id) VALUES
(6, 5), (7, 5), (8, 5), (9, 5), (10, 5),
(16, 5), (17, 5), (18, 5), (19, 5), (20, 5);


ALTER SEQUENCE MARCA_SEQ RESTART WITH (1000);
ALTER SEQUENCE COLOR_SEQ RESTART WITH (1000);
ALTER SEQUENCE TALLA_SEQ RESTART WITH (1000);
AlTER SEQUENCE PRODUCTO_SEQ RESTART WITH (10000);
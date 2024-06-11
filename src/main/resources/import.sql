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

-- Insertar colores
INSERT INTO Color (id, nombre) VALUES (1, 'Rojo');
INSERT INTO Color (id, nombre) VALUES (2, 'Azul');
INSERT INTO Color (id, nombre) VALUES (3, 'Verde');
INSERT INTO Color (id, nombre) VALUES (4, 'Negro');
INSERT INTO Color (id, nombre) VALUES (5, 'Blanco');

-- Insertar productos
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (1, 'Bicicleta Orbea', 1000.00, 800.00, 'imagen1.jpg', 'Descripción de la bicicleta Orbea', 1, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (2, 'Componente Cannondale', 50.00, 40.00, 'imagen2.jpg', 'Descripción del componente Cannondale', 2, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (3, 'Chaqueta Specialized', 80.00, 60.00, 'imagen3.jpg', 'Descripción de la chaqueta Specialized', 3, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (4, 'Casco Megamo', 30.00, 20.00, 'imagen4.jpg', 'Descripción del casco Megamo', 4, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (5, 'Pantalón MMR', 60.00, 45.00, 'imagen5.jpg', 'Descripción del pantalón MMR', 5, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (6, 'Bicicleta Cannondale', 1200.00, 900.00, 'imagen6.jpg', 'Descripción de la bicicleta Cannondale', 2, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (7, 'Manillar Orbea', 40.00, 30.00, 'imagen7.jpg', 'Descripción del manillar Orbea', 1, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (8, 'Guantes Specialized', 35.00, 25.00, 'imagen8.jpg', 'Descripción de los guantes Specialized', 3, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (9, 'Maillot Megamo', 70.00, 55.00, 'imagen9.jpg', 'Descripción del maillot Megamo', 4, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (10, 'Bicicleta Specialized', 1500.00, 1100.00, 'imagen10.jpg', 'Descripción de la bicicleta Specialized', 3, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (11, 'Pedales MMR', 25.00, 15.00, 'imagen11.jpg', 'Descripción de los pedales MMR', 5, 'COMPONENTES');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (12, 'Calcetines Cannondale', 15.00, 10.00, 'imagen12.jpg', 'Descripción de los calcetines Cannondale', 2, 'ACCESORIOS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (13, 'Camiseta Orbea', 45.00, 35.00, 'imagen13.jpg', 'Descripción de la camiseta Orbea', 1, 'ROPAYEQUIPAMIENTO');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (14, 'Bicicleta Megamo', 1100.00, 850.00, 'imagen14.jpg', 'Descripción de la bicicleta Megamo', 4, 'BICICLETAS');
INSERT INTO Producto (id, nombre, precio_venta, precio_fabrica, imagen, descripcion, marca_id, categoria) VALUES (15, 'Cadena Specialized', 20.00, 12.00, 'imagen15.jpg', 'Descripción de la cadena Specialized', 3, 'COMPONENTES');


ALTER SEQUENCE MARCA_SEQ RESTART WITH (1000);
ALTER SEQUENCE COLOR_SEQ RESTART WITH (1000);
ALTER SEQUENCE TALLA_SEQ RESTART WITH (1000);
AlTER SEQUENCE PRODUCTO_SEQ RESTART WITH (10000);
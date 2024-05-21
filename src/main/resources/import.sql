INSERT INTO Talla (id, nombre) VALUES (1, 'S');
INSERT INTO Talla (id, nombre) VALUES (2, 'M');
INSERT INTO Talla (id, nombre) VALUES (3, 'L');
INSERT INTO Talla (id, nombre) VALUES (4, 'XL');
INSERT INTO Talla (id, nombre) VALUES (5, 'XXL');
INSERT INTO Marca (id, nombre) VALUES (1, 'ORBEA');
INSERT INTO Marca (id, nombre) VALUES (2, 'CANNONDALE');
INSERT INTO Marca (id, nombre) VALUES (3, 'SPECIALIZED');
INSERT INTO Marca (id, nombre) VALUES (4, 'MEGAMO');
INSERT INTO Marca (id, nombre) VALUES (5, 'MMR');
INSERT INTO Color (id, nombre) VALUES (1, 'Rojo');
INSERT INTO Color (id, nombre) VALUES (2, 'Azul');
INSERT INTO Color (id, nombre) VALUES (3, 'Verde');
INSERT INTO Color (id, nombre) VALUES (4, 'Negro');
INSERT INTO Color (id, nombre) VALUES (5, 'Blanco');

ALTER SEQUENCE MARCA_SEQ RESTART WITH (1000);
ALTER SEQUENCE COLOR_SEQ RESTART WITH (1000);
ALTER SEQUENCE TALLA_SEQ RESTART WITH (1000);
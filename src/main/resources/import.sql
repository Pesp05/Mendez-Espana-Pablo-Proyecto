INSERT INTO Talla (id, nombre) VALUES (1, 'S');
INSERT INTO Talla (id, nombre) VALUES (2, 'M');
INSERT INTO Talla (id, nombre) VALUES (3, 'L');
INSERT INTO Talla (id, nombre) VALUES (4, 'XL');
INSERT INTO Talla (id, nombre) VALUES (5, 'XXL');
INSERT INTO Marca (id, nombre) VALUES (1, 'Marca 1');
INSERT INTO Marca (id, nombre) VALUES (2, 'Marca 2');
INSERT INTO Marca (id, nombre) VALUES (3, 'Marca 3');
INSERT INTO Marca (id, nombre) VALUES (4, 'Marca 4');
INSERT INTO Marca (id, nombre) VALUES (5, 'Marca 5');
INSERT INTO Color (id, nombre) VALUES (1, 'Rojo');
INSERT INTO Color (id, nombre) VALUES (2, 'Azul');
INSERT INTO Color (id, nombre) VALUES (3, 'Verde');
INSERT INTO Color (id, nombre) VALUES (4, 'Negro');
INSERT INTO Color (id, nombre) VALUES (5, 'Blanco');

ALTER SEQUENCE MARCA_SEQ RESTART WITH (1000);
ALTER SEQUENCE COLOR_SEQ RESTART WITH (1000);
ALTER SEQUENCE TALLA_SEQ RESTART WITH (1000);
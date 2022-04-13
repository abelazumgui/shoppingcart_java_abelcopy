CREATE TABLE `tienda`.`clientes` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
INSERT INTO tienda.clientes
VALUES (1,'pedro',123123123,'p@p.p');

INSERT INTO tienda.clientes
VALUES (2,'ana',321321321, 'a@a.a');


CREATE TABLE `tienda`.`productos` (
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DOUBLE NOT NULL,
  `catidad` INT NOT NULL,

  PRIMARY KEY (`nombre`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE);
  
INSERT INTO tienda.productos
VALUES ('telefono', 299.99, 10);

INSERT INTO tienda.productos
VALUES ('laptop',899.99, 10);


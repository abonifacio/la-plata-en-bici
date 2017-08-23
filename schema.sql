-- CREATE DATABASE LaPlataEnBici;



USE laplataenbici;


DROP TABLE IF EXISTS `Bicicleta`;
CREATE TABLE IF NOT EXISTS `Bicicleta` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fecha_ingreso` TIMESTAMP NULL,
	`fecha_devolucion` TIMESTAMP NULL,
	`estado` VARCHAR(45) NULL,
	`detalle` VARCHAR(255) NULL,
	`usuario_id` INT NULL,
	`estacion_id` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `HistorialBicicleta`;
CREATE TABLE IF NOT EXISTS `HistorialBicicleta` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fecha_ingreso` TIMESTAMP NULL,
	`fecha_devolucion` TIMESTAMP NULL,
	`estado` VARCHAR(45) NULL,
	`tipo` VARCHAR(45) NULL,
	`detalle` VARCHAR(255) NULL,
	`bicicleta_id` INT NOT NULL,
	`usuario_id` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `Estacion`;
CREATE TABLE IF NOT EXISTS `Estacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL,
	`capacidad` INT NULL,
	`estado` VARCHAR(45) NULL,
	`direccion` VARCHAR(255) NULL,
	`longitud` DOUBLE(20,10) NOT NULL,
	`latitud` DOUBLE(20,10) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE  IF EXISTS `Localidad`;
CREATE TABLE IF NOT EXISTS `Localidad` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL,
	`codigo_postal` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `Usuario`;
CREATE TABLE IF NOT EXISTS `Usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`DNI` INT NULL,
	`nombre` VARCHAR(40) NULL,
	`apellido` VARCHAR(50) NULL,
	`calle` VARCHAR(30) NULL,
	`numero` VARCHAR(10) NULL,
	`localidad_id` INT NOT NULL,
	`fecha_nac` TIMESTAMP NULL,
	`estado` VARCHAR(40) NULL,
	`sexo` VARCHAR(1) NULL,
	`email` VARCHAR(30) NULL,
	`username` VARCHAR(30) NULL,
	`password` VARCHAR(30) NULL,
	`rol` VARCHAR(20) NULL,

	PRIMARY KEY (`id`)
) ENGINE = InnoDB;



-- ---------------------------------------------------
-- - Localidades
-- ---------------------------------------------------

INSERT INTO Localidad (nombre,codigo_postal) VALUES ('City Bell',1896);
INSERT INTO Localidad (nombre,codigo_postal) VALUES ('Gonnet',1897);
INSERT INTO Localidad (nombre,codigo_postal) VALUES ('La Plata',1900);
INSERT INTO Localidad (nombre,codigo_postal) VALUES ('Villa Elisa',1894);
INSERT INTO Localidad (nombre,codigo_postal) VALUES ('Ensenada',1925);

-- ---------------------------------------------------
-- - Usuarios
-- ---------------------------------------------------
INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(38335081,'Augusto','Bonifacio','Falsa','123',1,TIMESTAMP('1995-05-09'),'HABILITADO','M','augusto@bonifacio.com','abonifacio','secreta','USER');

INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(38812381,'Juan','Perez','Falsa','123',2,TIMESTAMP('1995-06-09'),'HABILITADO','M','juan@perez.com','jperez','secreta','USER');

INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(00000001,'Admin','istrador','El cielo','7',1,TIMESTAMP('1990-07-09'),'HABILITADO','M','admin@admin.com','admin','admin','ADMIN');

-- ---------------------------------------------------
-- - Estaciones
-- ---------------------------------------------------
INSERT INTO Estacion (nombre,capacidad,estado,direccion,longitud,latitud)
	VALUES ('Plaza Moreno',6,'OPERATIVA','13 y 54', -57.954710,-34.921005);

INSERT INTO Estacion (nombre,capacidad,estado,direccion,longitud,latitud)
	VALUES ('Plaza Paso',3,'OPERATIVA','13 y 44', -57.961402,-34.916433);


-- ---------------------------------------------------
-- - Bicicletas
-- ---------------------------------------------------

-- bicicletas en estacion
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);

INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);

-- CREATE DATABASE  LaPlataEnBici;



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



DROP TABLE IF EXISTS `Estacion`;
CREATE TABLE IF NOT EXISTS `Estacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL,
	`capacidad` INT NULL,
	`estado` VARCHAR(45) NULL,
	`direccion` VARCHAR(255) NULL,
	`ubicacion_id` INT NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE  IF EXISTS `Localidad`;
CREATE TABLE IF NOT EXISTS `Localidad` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(255) NULL,
	`codigo_postal` INT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `Ubicacion`;
CREATE TABLE IF NOT EXISTS `Ubicacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`longitud` DOUBLE(20,10) NULL,
	`latitud` DOUBLE(20,10) NULL,
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

DROP TABLE IF EXISTS `TrackingItem`;
CREATE TABLE IF NOT EXISTS `TrackingItem` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`atributo` VARCHAR(255) NULL,
	`valor` VARCHAR(255) NULL,
	`anterior` VARCHAR(255) NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingUsuario_TrackingItem`;
CREATE TABLE IF NOT EXISTS `TrackingUsuario_TrackingItem` (
	`items_id` INT NOT NULL,
	`TrackingUsuario_id` INT NOT NULL,
	PRIMARY KEY (`items_id`,`TrackingUsuario_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingBicicleta_TrackingItem`;
CREATE TABLE IF NOT EXISTS `TrackingBicicleta_TrackingItem` (
	`items_id` INT NOT NULL,
	`TrackingBicicleta_id` INT NOT NULL,
	PRIMARY KEY (`items_id`,`TrackingBicicleta_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingEstacion_TrackingItem`;
CREATE TABLE IF NOT EXISTS `TrackingEstacion_TrackingItem` (
	`items_id` INT NOT NULL,
	`TrackingEstacion_id` INT NOT NULL,
	PRIMARY KEY (`items_id`,`TrackingEstacion_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingBicicleta`;
CREATE TABLE IF NOT EXISTS `TrackingBicicleta` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fecha` TIMESTAMP NULL,
	`operacion` VARCHAR(50) NULL,
	`usuario_id` INT NULL,
	`entity_id` INT NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingUsuario`;
CREATE TABLE IF NOT EXISTS `TrackingUsuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fecha` TIMESTAMP NULL,
	`operacion` VARCHAR(50) NULL,
	`usuario_id` INT NULL,
	`entity_id` INT NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `TrackingEstacion`;
CREATE TABLE IF NOT EXISTS `TrackingEstacion` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`fecha` TIMESTAMP NULL,
	`operacion` VARCHAR(50) NULL,
	`usuario_id` INT NULL,
	`entity_id` INT NOT NULL,
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
VALUES(38863081,'Augusto','Bonifacio','474','984',1,TIMESTAMP('1995-05-09'),'HABILITADO','M','augusto@bonifacio.com','abonifacio','secreta','USER');

INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(38812381,'Juan','Perez','494','123',2,TIMESTAMP('1995-06-09'),'HABILITADO','M','juan@perez.com','jperez','secreta','USER');

INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(38845681,'Camila','Casas','44','190',3,TIMESTAMP('1995-07-09'),'HABILITADO','F','camila@casas.com','cacasas','secreta','USER');

INSERT INTO Usuario (DNI,nombre,apellido,calle,numero,localidad_id,fecha_nac,estado,sexo,email,username,password,rol)
VALUES(00000001,'Ad','Min','1','2',1,TIMESTAMP('1990-07-09'),'HABILITADO','M','admin@admin.com','admin','admin','ADMIN');
-- ---------------------------------------------------
-- - Ubicaciones
-- ---------------------------------------------------
INSERT INTO Ubicacion (longitud,latitud) VALUES (-34.921005, -57.954710); -- PZA MORENO
INSERT INTO Ubicacion (longitud,latitud) VALUES (-34.916598, -57.961125); -- PZA PASO


--- --------------------------------------------------
-- - Estaciones
-- ---------------------------------------------------
INSERT INTO Estacion (nombre,capacidad,estado,direccion,ubicacion_id)
	VALUES ('Plaza Moreno',1230,'OPERATIVA','13 y 54',1);

INSERT INTO Estacion (nombre,capacidad,estado,direccion,ubicacion_id)
	VALUES ('Plaza Paso',800,'OPERATIVA','13 y 44',2);


-- ---------------------------------------------------
-- - Bicicletas
-- ---------------------------------------------------

-- biciletas alquiladas
INSERT INTO Bicicleta (fecha_ingreso,estado,usuario_id) VALUES (NOW(),'APTA',1);
INSERT INTO Bicicleta (fecha_ingreso,estado,usuario_id) VALUES (NOW(),'APTA',2);
INSERT INTO Bicicleta (fecha_ingreso,estado,usuario_id) VALUES (NOW(),'APTA',3);

-- bicicletas en estacion

INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',1);

INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);
INSERT INTO Bicicleta (fecha_ingreso,estado,estacion_id) VALUES (NOW(),'APTA',2);


INSERT INTO TrackingBicicleta (fecha,operacion,usuario_id,entity_id)
	VALUES (NOW(),'MODIFICACION',2,4);

INSERT INTO TrackingUsuario (fecha,operacion,usuario_id,entity_id)
	VALUES (NOW(),'MODIFICACION',4,2);

INSERT INTO TrackingEstacion (fecha,operacion,usuario_id,entity_id)
	VALUES (NOW(),'ALTA',4,1);


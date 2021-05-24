CREATE SCHEMA IF NOT EXISTS `areacomercial` DEFAULT CHARACTER SET utf8 ;
USE `areacomercial` ;

-- -----------------------------------------------------
-- Table `areacomercial`.`tbl_proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `areacomercial`.`tbl_proveedor` (
  `PK_id_proveedor` INT NOT NULL ,
  `nombre_proveedor` VARCHAR(45)NOT NULL,
  `direccion_proveedor` VARCHAR(200) NOT NULL,
  `contacto_proveedor` VARCHAR(200) NOT NULL,
  `telefono_proveedor` VARCHAR(200) NOT NULL,
   `nit_proveedor` VARCHAR(200) NOT NULL,
  `email_proveedor` VARCHAR(200) NOT NULL,
   `estatus_proveedor` VARCHAR(200) NOT NULL,
 PRIMARY KEY (`PK_id_proveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `areacomercial`.`tbl_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `areacomercial`.`tbl_producto` (
  `PK_id_producto` INT NOT NULL,
  `nombre_producto` VARCHAR(45) NoT NULL,
  `precio_producto` INT(200) NOT NULL,
  `descripcion_producto` VARCHAR(200) NOT NULL,
  `estatus_producto` VARCHAR(200) NOT NULL,
  `bodega` VARCHAR(200) NOT NULL,
  `fechaIngreso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PK_id_producto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `areacomercial`.`tbl_proceso_producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `areacomercial`.`tbl_proceso_producto` (
`PK_id_procesoproducto` INT NOT NULL,
`nombre_producto` VARCHAR(45) NoT NULL,
`nombre_bodega` VARCHAR(45) NoT NULL,
`existencias_producto` VARCHAR(45) NoT NULL,
`fechaActualizacion` VARCHAR(45) NoT NULL,
`ProductoNuevo` VARCHAR(45) NoT NULL,
`NuevaExistencia` VARCHAR(45) NoT NULL,
`BodegasNuevaExistencia` VARCHAR(45) NoT NULL,
PRIMARY KEY (`PK_id_procesoproducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `areacomercial`.`tbl_compra`
-- -----------------------------------------------------
CREATE TABLE tbl_compra
(
  Id_Factura int(30) primary key,
 Id_proveedor varchar(10),
Nombre_proveedor varchar(30) ,
Nit_proveedor varchar(30) ,
Id_producto varchar(30),
Nombre_producto varchar(30) ,
Precio_producto varchar(30) ,
Cantidad_producto varchar(30) ,
Subtotal_producto varchar(30) ,
Total_producto varchar(30) ,
Fecha_producto varchar(30),
Pago_producto varchar(30)


  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `areacomercial`.`tbl_pago`
-- -----------------------------------------------------

CREATE TABLE tbl_pago
(
  Id_numero int(30) primary key,
 fecha_tarjeta varchar(10),
Nombre_tarjeta varchar(30) ,
 password varchar(45) 

 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- ------------------------------------------------------VENTAS---------------------------------------------

CREATE TABLE  depositos (
Id_pedido INT NOT NULL AUTO_INCREMENT,
Cliente  VARCHAR(15)  NOT NULL, 
cuenta  VARCHAR(15)  NOT NULL,
Fecha_inicial VARCHAR(25)  NOT NULL,
Fecha_final VARCHAR(25)  NOT NULL,
Nit int (25)  NOT NULL, 
telefono int (25)  NOT NULL, 
producto VARCHAR (15)  NOT NULL, 
Detalle VARCHAR(25)  NOT NULL,
Cantidad VARCHAR(25)  NOT NULL, 
 PRIMARY KEY ( Id_pedido)
)ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE  tbl_pedido_factura (
 ID VARCHAR (15)  NOT NULL,
 Cliente  VARCHAR (15)  NOT NULL,
Nit   int (25)  NOT NULL,
telefono VARCHAR(25)  NOT NULL,
producto  VARCHAR (15)  NOT NULL,
Cantidad  int (25)  NOT NULL,
Precio_por_unidad  int (25)  NOT NULL,
Monto  int (25)  NOT NULL,
Total   VARCHAR(15)  NOT NULL,

 PRIMARY KEY (  ID)
);


CREATE TABLE  estatus_credito (
Id_cliente int (25)  NOT NULL,  
Fecha_inicial VARCHAR(25)  NOT NULL,
Fecha_final VARCHAR(25)  NOT NULL,
Nit int (25)  NOT NULL, 
Monto int (25)  NOT NULL, 
Estatus_Cliente VARCHAR(25)  NOT NULL, 
teléfono int (25)  NOT NULL, 
Id_producto int (25)  NOT NULL, 
Detalle VARCHAR(25)  NOT NULL,
Cantidad int (25)  NOT NULL, 
Precio_por_unidad int (25)  NOT NULL,
 PRIMARY KEY ( id_cliente)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE  solicitud (
Id_cliente int (25)  NOT NULL,  
Fecha_inicial VARCHAR(25)  NOT NULL,
Fecha_final VARCHAR(25)  NOT NULL,
Nit int (25)  NOT NULL, 
Monto int (25)  NOT NULL, 
Estatus_Cliente VARCHAR(25)  NOT NULL, 
teléfono int (25)  NOT NULL, 
Id_producto int (25)  NOT NULL, 
Detalle VARCHAR(25)  NOT NULL,
Cantidad int (25)  NOT NULL, 
Precio_por_unidad int (25)  NOT NULL,
 PRIMARY KEY ( id_cliente)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
CREATE TABLE  tbl_cliente (
Id_cliente INT NOT NULL AUTO_INCREMENT, 
cliente VARCHAR(25)  NOT NULL,  
Nit VARCHAR(25)  NOT NULL, 

Estatus_Cliente VARCHAR(25)  NOT NULL, 
telefono VARCHAR(25)  NOT NULL, 

  PRIMARY KEY (Id_cliente)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



/*INSERT INTO `areacomercial`.`tbl_cliente` (`Id_cliente`, `cliente`, `Nit`, `Monto`, `Estatus_Cliente`, `telefono`, `producto`, `cuenta`) VALUES ('1', 'Rayovac', '78687', '100', '1', '786', 'casa', '876');
 */
 CREATE TABLE  tbl_acreedores (
Id_acreedores INT NOT NULL AUTO_INCREMENT, 
acreedores VARCHAR(25)  NOT NULL,  
Nit VARCHAR(25)  NOT NULL, 
Monto VARCHAR(25)  NOT NULL, 
Estatus_Cliente VARCHAR(25)  NOT NULL, 
telefono VARCHAR(25)  NOT NULL, 
producto VARCHAR(25)  NOT NULL,  
  PRIMARY KEY (Id_acreedores)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `areacomercial`.`tbl_proveedor` (`PK_id_proveedor`, `nombre_proveedor`, `direccion_proveedor`, `contacto_proveedor`, `telefono_proveedor`, `nit_proveedor`, `email_proveedor`, `estatus_proveedor`) VALUES ('23', 'Pepsi', 'Cuidad,Guatemala', 'Juan Fernandez', '234400,', '236700-1', 'pepsi@gmail.com', '1');
INSERT INTO `areacomercial`.`tbl_proveedor` (`PK_id_proveedor`, `nombre_proveedor`, `direccion_proveedor`, `contacto_proveedor`, `telefono_proveedor`, `nit_proveedor`, `email_proveedor`, `estatus_proveedor`) VALUES ('13', 'CocaCola', 'Cuidad,Guatemala', 'Rosa Perez', '345670342', '459999345-1', 'Cocacola@gmail.com', '1');
INSERT INTO `areacomercial`.`tbl_proveedor` (`PK_id_proveedor`, `nombre_proveedor`, `direccion_proveedor`, `contacto_proveedor`, `telefono_proveedor`, `nit_proveedor`, `email_proveedor`, `estatus_proveedor`) VALUES ('45', 'Colgate', 'Cuidad,Guatemala', 'Mario Mendoza', '67892231', '899345-4', 'Colgate@gmail.com', '1');
INSERT INTO `areacomercial`.`tbl_proveedor` (`PK_id_proveedor`, `nombre_proveedor`, `direccion_proveedor`, `contacto_proveedor`, `telefono_proveedor`, `nit_proveedor`, `email_proveedor`, `estatus_proveedor`) VALUES ('100', 'Ideal', 'Cuidad,Guatemala', 'Fatima Lopez', '45667898', '22009877-6', 'ideal@gmail.com', '1');
INSERT INTO `areacomercial`.`tbl_proveedor` (`PK_id_proveedor`, `nombre_proveedor`, `direccion_proveedor`, `contacto_proveedor`, `telefono_proveedor`, `nit_proveedor`, `email_proveedor`, `estatus_proveedor`) VALUES ('86', 'Kerns', 'Cuidad,Guatemala', 'Jose Castañeda', '17220089', '5512380-7', 'kerns@gmail.com', '1');
INSERT INTO `areacomercial`.`tbl_cliente` (`id_cliente`, `cliente`, `Nit`, `Estatus_Cliente`, `telefono`) VALUES ('1', 'rita', '234423423', '1', '324234');
INSERT INTO `areacomercial`.`tbl_compra` (`Id_Factura`, `Id_proveedor`, `Nombre_proveedor`, `Nit_proveedor`, `Id_producto`, `Nombre_producto`, `Precio_producto`, `Cantidad_producto`, `Subtotal_producto`, `Total_producto`, `Fecha_producto`) VALUES ('2', '13', 'CocaCola', '459999345-1', '34', 'Jugo de La Granja', '14', '2', '28', '28', '17-may.-2021');

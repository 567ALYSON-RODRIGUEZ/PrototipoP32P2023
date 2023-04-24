CREATE SCHEMA IF NOT EXISTS `prototipoP32P2023` DEFAULT CHARACTER SET utf8 ;
USE `prototipoP32P2023` ;

CREATE TABLE IF NOT EXISTS tbl_personaTipo (
	perid INT (5),
	pernombre VARCHAR(45) NOT NULL,
	perestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (perid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_movimientoTipo (
    movid INT (5) NOT NULL PRIMARY KEY,
    movnombre VARCHAR(15) NOT NULL,
    movestatus VARCHAR (1) NOT NULL
)ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_usuario (
	usuid INT NOT NULL AUTO_INCREMENT,
	usunombre VARCHAR(45) NOT NULL,
	usucontrasena VARCHAR(25) NOT NULL,
	PRIMARY KEY (usuid)
    )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bitacora (
    bitid int auto_increment PRIMARY KEY,
    bitfecha datetime NULL, 
	bitaccion VARCHAR(10) NOT NULL,
    bitip VARCHAR(25) NOT NULL,
    usuid INT NOT NULL,
    movid INT NOT NULL,
	FOREIGN KEY (movid) references tbl_movimientotipo (movid),
	FOREIGN KEY (usuid) references tbl_usuario (usuid)    
) ENGINE=InnoDB DEFAULT CHARSET=latin1;	
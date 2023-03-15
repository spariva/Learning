ALTER SESSION SET NLS_DATE_FORMAT='DD/MM/YYYY';

DROP TABLE FACTURA CASCADE CONSTRAINT;
CREATE TABLE FACTURA(
    NUMERO VARCHAR2(4) PRIMARY KEY AUTO_INCREMENT,
    FECHA DATE NOT NULL,
    IVA NUMBER(3) NOT NULL
);

DROP TABLE CLIENTE CASCADE CONSTRAINT;
CREATE TABLE CLIENTE(
    DNI VARCHAR2(9) PRIMARY KEY,
    NOMBRE VARCHAR2(15) NOT NULL,
    DIRECCION VARCHAR2(20) NOT NULL,
    TELEFONO NUMBER(9) NOT NULL
);

DROP TABLE CABECERA_PEDIDO CASCADE CONSTRAINT;
CREATE TABLE CABECERA_PEDIDO(
    NUM_PEDIDO VARCHAR2(4) AUTO_INCREMENT PRIMARY KEY,
    FECHA DATE NOT NULL,
    DNI VARCHAR2(9) NOT NULL, 
    CONSTRAINT FK_DNI_PED FOREIGN KEY (DNI) REFERENCES CLIENTE(DNI) ON DELETE CASCADE
);

DROP TABLE CABECERA_ALBARAN CASCADE CONSTRAINT;
CREATE TABLE CABECERA_ALBARAN(
    NUM_ALBARAN VARCHAR2(9) AUTO_INCREMENT PRIMARY KEY,
    FECHA DATE NOT NULL,
    NUM_PEDIDO VARCHAR2(4) NOT NULL,
    NUMERO VARCHAR2(4) NOT NULL,
    CONSTRAINT FK_ALB_PED FOREIGN KEY (NUM_PEDIDO) REFERENCES CABECERA_PEDIDO(NUM_PEDIDO) ON DELETE CASCADE,
    CONSTRAINT FK_ALB_FAC FOREIGN KEY (NUMERO) REFERENCES FACTURA(NUMERO) ON DELETE CASCADE
);

DROP TABLE EMPRESA CASCADE CONSTRAINT;
CREATE TABLE EMPRESA(
    CIF VARCHAR2(9) PRIMARY KEY,
    NOMBRE VARCHAR2(20) NOT NULL,
    DIRECCION VARCHAR2(20) NOT NULL
);

DROP TABLE PRODUCTOS CASCADE CONSTRAINT;
CREATE TABLE PRODUCTOS(
    CODIGO VARCHAR2(9) PRIMARY KEY,
    NOMBRE VARCHAR2(15) NOT NULL,
    PRECIO NUMBER(4,2) NOT NULL,
    CIF VARCHAR2(9) NOT NULL,
    CONSTRAINT FK_PROD_EMP FOREIGN KEY (CIF) REFERENCES EMPRESA(CIF) ON DELETE CASCADE
);

DROP TABLE LINEA_PEDIDO CASCADE CONSTRAINT;
CREATE TABLE LINEA_PEDIDO(
    NUM_LINEA VARCHAR2(2) NOT NULL,
    CANTIDAD NUMBER(4) NOT NULL,
    NUM_PEDIDO VARCHAR2(4) NOT NULL,
    COD_PRODUCTO VARCHAR2(9) NOT NULL,
    CONSTRAINT FK_LINPED_PED FOREIGN KEY (NUM_PEDIDO) REFERENCES PEDIDO(NUMERO) ON DELETE CASCADE,
    CONSTRAINT FK_LINPED_PROD FOREIGN KEY (COD_PRODUCTO) REFERENCES PRODUCTOS(CODIGO) ON DELETE CASCADE,
    CONSTRAINT PK_LINEA_PED PRIMARY KEY (NUM_PEDIDO, NUM_LINEA, COD_PRODUCTO)
);

DROP TABLE LINEA_ALBARAN CASCADE CONSTRAINT;
CREATE TABLE LINEA_ALBARAN(
    NUM_ALBARAN VARCHAR2(4) NOT NULL,
    NUM_LINEA VARCHAR2(2) NOT NULL,
    CANTIDAD NUMBER(4) NOT NULL,
    COD_PROD VARCHAR2(9) NOT NULL,
    CONSTRAINT FK_LINALB_PROD FOREIGN KEY (COD_PROD) REFERENCES PRODUCTOS(CODIGO) ON DELETE CASCADE,
    CONSTRAINT FK_LINALB_CABALB FOREIGN KEY (NUM_ALBARAN) REFERENCES CABECERA_ALBARAN(NUM_ALBARAN) ON DELETE CASCADE,
    CONSTRAINT PK_LINALB PRIMARY KEY (NUM_ALBARAN, NUM_LINEA, COD_PROD)
);

INSERT INTO FACTURA VALUES('01/03/2023', 21);
INSERT INTO FACTURA VALUES('01/03/2023', 21);
INSERT INTO FACTURA VALUES('03/03/2023', 7);
INSERT INTO FACTURA VALUES('11/03/2023', 21);
INSERT INTO FACTURA VALUES('21/03/2023', 21);
COMMIT;

INSERT INTO CLIENTE VALUES('51125737J', 'MAKI', 'GLORIA FUERTES 2', '606404202');
INSERT INTO CLIENTE VALUES('51325899L', 'CATHA', 'MONIQUE WITTIG 23', '607404255');
INSERT INTO CLIENTE VALUES('61125707L', 'KARLA', 'AV OCAÑA 2', '606555204');
INSERT INTO CLIENTE VALUES('41125707L', 'EU', 'LOPE DE RUEDA 2', '606404103');
INSERT INTO CLIENTE VALUES('71125707L', 'AVE', 'AV OCAÑA 25', '606404202');
COMMIT;

INSERT INTO CABECERA_PEDIDO VALUES('01/03/2023','51125737J');
INSERT INTO CABECERA_PEDIDO VALUES('01/03/2023','51325899L');
INSERT INTO CABECERA_PEDIDO VALUES('03/03/2023','61125707L');
INSERT INTO CABECERA_PEDIDO VALUES('11/03/2023','41125707L');
INSERT INTO CABECERA_PEDIDO VALUES('21/03/2023','71125707L');
COMMIT;
--ME PONDRÁ EL NÚM PEDIDO Y OTRAS LLAVES FORÁNEAS EN LAS QUE HICE AUTO_INCREMENT??
INSERT INTO CABECERA_ALBARAN VALUES('01/03/2023',);
INSERT INTO CABECERA_ALBARAN VALUES('01/03/2023',);
INSERT INTO CABECERA_ALBARAN VALUES('03/03/2023',);
INSERT INTO CABECERA_ALBARAN VALUES('11/03/2023',);
INSERT INTO CABECERA_ALBARAN VALUES('21/03/2023',);
COMMIT;

INSERT INTO EMPRESA VALUES('123456789', 'TRANS PORTES', 'IZAN PARRA 23');
INSERT INTO EMPRESA VALUES('323456789', 'HEURA CO', 'PAUL PRECIADO 58');
INSERT INTO EMPRESA VALUES('1234560MJ', 'TRANS KINGS', 'AV REYES MAGOS 1');
COMMIT;

INSERT INTO PRODUCTOS VALUES('000000001','PROGESTERONA', 1, '123456789');
INSERT INTO PRODUCTOS VALUES('000000010','ESTRODIOL', 2, '123456789');
INSERT INTO PRODUCTOS VALUES('000000100','DEPAKINE', 1, '123456789');
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
INSERT INTO PRODUCTOS VALUES();
COMMIT;

INSERT INTO LINEA_PEDIDO VALUES();
INSERT INTO LINEA_PEDIDO VALUES();
INSERT INTO LINEA_PEDIDO VALUES();
INSERT INTO LINEA_PEDIDO VALUES();
INSERT INTO LINEA_PEDIDO VALUES();
COMMIT;

INSERT INTO LINEA_ALBARAN VALUES();
INSERT INTO LINEA_ALBARAN VALUES();
INSERT INTO LINEA_ALBARAN VALUES();
INSERT INTO LINEA_ALBARAN VALUES();
INSERT INTO LINEA_ALBARAN VALUES();
COMMIT;





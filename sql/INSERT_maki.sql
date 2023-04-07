INSERT INTO FACTURA VALUES('F001','01/03/2023', 1.21);
INSERT INTO FACTURA VALUES('F002','03/03/2023', 1.21);
INSERT INTO FACTURA VALUES('F003','11/03/2023', 1.21);
COMMIT;

INSERT INTO CLIENTE VALUES('51125737J', 'MAKI', 'GLORIA FUERTES 2', '606404202');
INSERT INTO CLIENTE VALUES('51325899L', 'ALEX', 'MONIQUE WITTIG 23', '607404255');
INSERT INTO CLIENTE VALUES('61125707L', 'PAULI', 'AV OCANA 2', '606555204');
COMMIT;

INSERT INTO CABECERA_PEDIDO VALUES('P001','01/03/2023','51125737J');
INSERT INTO CABECERA_PEDIDO VALUES('P002','01/03/2023','51125737J');
INSERT INTO CABECERA_PEDIDO VALUES('P003','03/03/2023','61125707L');
INSERT INTO CABECERA_PEDIDO VALUES('P004','03/03/2023','61125707L');
INSERT INTO CABECERA_PEDIDO VALUES('P005','09/03/2023','51325899L');
INSERT INTO CABECERA_PEDIDO VALUES('P006','11/03/2023','51325899L');
COMMIT;

INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB01','01/03/2023','P001','F001');
INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB02','01/03/2023','P002','F001');
INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB03','03/03/2023','P003','F002');
INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB04','03/03/2023','P004','F002');
INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB05','09/03/2023','P005','F003');
INSERT INTO CABECERA_ALBARAN VALUES('CAB_ALB06','11/03/2023','P006','F003');
COMMIT;

INSERT INTO EMPRESA VALUES('1234560MJ', 'TRANS KINGS', 'AV REYES MAGOS 1');
COMMIT;

INSERT INTO PRODUCTOS VALUES('000000001','PROGESTERONA', 1, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000000010','ESTRADIOL', 2, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000000100','DEPAKINE', 3, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000000011','HEURA', 10, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000000110','LECHE AVENA', 1, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000000111','LECHE SOJA', 1, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('001100000','TESTOGEL', 2, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000100001','MAKE UP', 5, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000100000','BINDER', 12, '1234560MJ');
INSERT INTO PRODUCTOS VALUES('000100111','BANDERA', 4, '1234560MJ');
COMMIT;

INSERT INTO LINEA_PEDIDO VALUES('P1', 6, 'P001', '000000001');
INSERT INTO LINEA_PEDIDO VALUES('P2', 2, 'P001', '000000011');
INSERT INTO LINEA_PEDIDO VALUES('P3', 1, 'P001', '000100001');
INSERT INTO LINEA_PEDIDO VALUES('P1', 3, 'P002', '000000110');
INSERT INTO LINEA_PEDIDO VALUES('P2', 4, 'P002', '000000010');
INSERT INTO LINEA_PEDIDO VALUES('P1', 5, 'P003', '000000010');
INSERT INTO LINEA_PEDIDO VALUES('P1', 6, 'P004', '000100111');
INSERT INTO LINEA_PEDIDO VALUES('P1', 7, 'P005', '000000100');
INSERT INTO LINEA_PEDIDO VALUES('P2', 4, 'P005', '001100000');
INSERT INTO LINEA_PEDIDO VALUES('P3', 2, 'P005', '000000111');
INSERT INTO LINEA_PEDIDO VALUES('P1', 1, 'P006', '000000100');
INSERT INTO LINEA_PEDIDO VALUES('P2', 1, 'P006', '000100000');
COMMIT;


INSERT INTO LINEA_ALBARAN VALUES('A1', 6, 'CAB_ALB01', '000000001');
INSERT INTO LINEA_ALBARAN VALUES('A2', 2, 'CAB_ALB01', '000000011');
INSERT INTO LINEA_ALBARAN VALUES('A3', 1, 'CAB_ALB01', '000100001');
INSERT INTO LINEA_ALBARAN VALUES('A1', 3, 'CAB_ALB02', '000000110');
INSERT INTO LINEA_ALBARAN VALUES('A2', 4, 'CAB_ALB02', '000000010');
INSERT INTO LINEA_ALBARAN VALUES('A1', 5, 'CAB_ALB03', '000000010');
INSERT INTO LINEA_ALBARAN VALUES('A1', 6, 'CAB_ALB04', '000100111');
INSERT INTO LINEA_ALBARAN VALUES('A1', 7, 'CAB_ALB05', '000000100');
INSERT INTO LINEA_ALBARAN VALUES('A2', 4, 'CAB_ALB05', '001100000');
INSERT INTO LINEA_ALBARAN VALUES('A3', 2, 'CAB_ALB05', '000000111');
INSERT INTO LINEA_ALBARAN VALUES('A1', 1, 'CAB_ALB06', '000000100');
INSERT INTO LINEA_ALBARAN VALUES('A2', 1, 'CAB_ALB06', '000100000');
COMMIT;
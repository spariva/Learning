SET WRAP OFF
SET VERIFY OFF
SET PAGESIZE 66
SET LINESIZE 120
SET FEEDBACK OFF
BTITLE OFF
CLEAR BREAK
CLEAR COLUMN 
CLEAR COMPUTES
CLEAR SCREEN

ACCEPT NUM_ALBARAN PROMPT 'INTRODUZCA EL NUMERO DE ALBARAN A LISTAR (CAB_ALB01):'

TTITLE  'CIF: 1234560MJ'-
SKIP 1  'TRANS KINGS'-
SKIP 1  'AV REYES MAGOS 1, 2009, MADRID'-
SKIP 2

COLUMN NUM_ALBARAN HEADING 'NUMERO DE ALBARAN:' FORMAT A20
COLUMN FECHA HEADING 'FECHA:'
COLUMN NOMBRE HEADING 'CLIENTE' FORMAT A30
COLUMN DIRECCION HEADING 'DIRECCION'
COLUMN NOMBRE_P HEADING 'PRODUCTO'
COLUMN CANTIDAD HEADING 'CANTIDAD'
COLUMN PRECIO HEADING 'PRECIO UNITARIO'

SELECT NUM_ALBARAN, FECHA FROM CABECERA_ALBARAN 
WHERE &NUM_ALBARAN=NUM_ALBARAN ORDER BY NUM_ALBARAN;
TTITLE OFF

SELECT C.NOMBRE, C.DIRECCION FROM CLIENTE C, CABECERA_PEDIDO PED, CABECERA_ALBARAN A 
WHERE &NUM_ALBARAN=A.NUM_ALBARAN AND C.DNI=PED.DNI AND PED.NUM_PEDIDO=A.NUM_PEDIDO;

SELECT NOMBRE_P, CANTIDAD, PRECIO FROM PRODUCTOS PR, LINEA_ALBARAN A 
WHERE &NUM_ALBARAN=A.NUM_ALBARAN AND PR.CODIGO=A.COD_PROD ORDER BY A.NUM_LINEA;

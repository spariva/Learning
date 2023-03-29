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

ACCEPT NUM_PEDIDO PROMPT 'Introduzca el número de pedido a listar (P001): '

TTITLE LEFT 'CIF: 1234560MJ'-
SKIP 1 'TRANS KINGS'-
SKIP 1 'AV REYES MAGOS 1, 2009, MADRID'-
SKIP 2

COLUMN NUM_PEDIDO HEADING 'Numero de pedido' FORMAT A20
COLUMN FECHA HEADING 'Fecha'
COLUMN NOMBRE HEADING 'Cliente' FORMAT A12
COLUMN DIRECCION HEADING 'Direccion' FORMAT A20
COLUMN NOMBRE_P HEADING 'Producto' FORMAT A18
COLUMN CANTIDAD HEADING 'Cantidad'
COLUMN PRECIO HEADING 'Precio unitario' 

SELECT NUM_PEDIDO, FECHA FROM CABECERA_PEDIDO 
WHERE &NUM_PEDIDO=NUM_PEDIDO ORDER BY NUM_PEDIDO;
TTITLE OFF

SELECT C.NOMBRE, C.DIRECCION FROM CLIENTE C, CABECERA_PEDIDO P 
WHERE &NUM_PEDIDO=P.NUM_PEDIDO AND C.DNI=P.DNI;

SELECT PR.NOMBRE_P, PED.CANTIDAD, PR.PRECIO FROM PRODUCTOS PR, LINEA_PEDIDO PED 
WHERE &NUM_PEDIDO=NUM_PEDIDO AND PR.CODIGO=PED.COD_PRODUCTO ORDER BY NUM_LINEA;



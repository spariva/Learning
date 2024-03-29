SET WRAP OFF
SET VERIFY OFF
SET PAGESIZE 266
SET LINESIZE 266
SET FEEDBACK OFF
BTITLE OFF
CLEAR BREAK
CLEAR COLUMN 
CLEAR COMPUTES
CLEAR SCREEN

ACCEPT NUMERO PROMPT 'INTRODUZCA EL NUMERO DE FACTURA A LISTAR (F001):'

TTITLE 'CIF: 1234560MJ'-
SKIP 1 'TRANS KINGS'-
SKIP 1 'AV REYES MAGOS 1, 2009, MADRID'-
SKIP 2

COMPUTE SUM LABEL 'TOTAL GENERAL' OF 'TOTAL' ON REPORT
COMPUTE SUM OF 'TOTAL CON IVA' ON  REPORT
BREAK ON REPORT SKIP 

SET LINESIZE 266
SET PAGESIZE 266
SET NEWPAGE 1

COLUMN NUMERO HEADING 'FACTURA:' FORMAT A20
COLUMN FECHA HEADING 'FECHA:'

COLUM NOMBRE HEADING 'CLIENTE:' FORMAT A30
COLUMN DIRECCION HEADING 'DIRECCION:'

COLUMN NOMBRE_P HEADING 'PRODUCTO'
COLUMN CANTIDAD HEADING 'CANTIDAD'
COLUMN PRECIO HEADING 'PRECIO UNITARIO'

COLUMN (PRODUCTOS.PRECIO*LINEA_ALBARAN.CANTIDAD) HEADING 'TOTAL'
COLUMN ((PRODUCTOS.PRECIO*LINEA_ALBARAN.CANTIDAD)*FACTURA.IVA) HEADING 'TOTAL CON IVA' FORMAT 9,999.99

SELECT NUMERO, FECHA FROM FACTURA WHERE &NUMERO=NUMERO ORDER BY NUMERO;

TTITLE OFF

SELECT DISTINCT C.NOMBRE, C.DIRECCION 
FROM CLIENTE C, CABECERA_PEDIDO PED, CABECERA_ALBARAN A, FACTURA F
WHERE F.NUMERO=&NUMERO
AND C.DNI=PED.DNI 
AND PED.NUM_PEDIDO=A.NUM_PEDIDO 
AND F.NUMERO=A.NUMERO_FACT;

SELECT PR.NOMBRE_P, LA.CANTIDAD, PR.PRECIO, (PR.PRECIO*LA.CANTIDAD) "TOTAL", (((PR.PRECIO*LA.CANTIDAD)*F.IVA)) "TOTAL CON IVA" 
FROM PRODUCTOS PR, LINEA_ALBARAN LA, FACTURA F, CABECERA_ALBARAN A, CABECERA_PEDIDO PED, CLIENTE C 
WHERE F.NUMERO=&NUMERO AND PR.CODIGO=LA.COD_PROD AND F.NUMERO=A.NUMERO_FACT
AND A.NUM_ALBARAN=LA.NUM_ALBARAN AND PED.NUM_PEDIDO=A.NUM_PEDIDO AND C.DNI=PED.DNI;

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

TTITLE LEFT 'Listado de productos'-
SKIP 1 '===================='
COLUMN CODIGO HEADING 'Codigo' FORMAT A12
COLUMN NOMBRE HEADING 'Nombre' FORMAT A18
COLUMN PRECIO HEADING 'Precio' FORMAT 
SELECT CODIGO, NOMBRE_P, PRECIO FROM PRODUCTOS;

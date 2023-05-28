--Primero, vamos a modificar la tabla de PRODUCTOS para incluir una columna adicional llamada STOCK que representa la cantidad disponible en el inventario:

ALTER TABLE PRODUCTOS ADD STOCK NUMBER(10);

--A continuación, vamos a crear una excepción personalizada llamada Sin_stock_Exception que se lanzará cuando no haya suficiente stock para un producto:

--A continuación, crearemos una función llamada VerificarStock que verificará si hay suficiente stock para un producto determinado antes de realizar un pedido. La función aceptará el código de producto y la cantidad solicitada como parámetros y devolverá verdadero (TRUE) si hay suficiente stock, o lanzará la excepción Sin_stock_Exception si no hay suficiente stock:

CREATE OR REPLACE FUNCTION VerificarStock(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
   RETURN BOOLEAN
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;

BEGIN
   SELECT STOCK INTO v_stock_actual
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF v_stock_actual >= p_cantidad THEN
      RETURN TRUE;
   ELSE
      RAISE Sin_stock_Exception;
   END IF;

EXCEPTION
   WHEN NO_DATA_FOUND THEN
      DBMS_OUTPUT.PUT_LINE('No se ha encontrado el producto con el código ' || p_nombre_producto);
   WHEN Sin_stock_Exception THEN
        DBMS_OUTPUT.PUT_LINE('El producto con el código ' || p_nombre_producto || ' no tiene suficiente stock.');
END;
/
--A continuación, vamos a crear un procedimiento llamado AddProductoPedido que utilizará la función VerificarStock para verificar el stock antes de realizar un pedido. El procedimiento aceptará el código de producto y la cantidad solicitada como parámetros, y mostrará un mensaje de aviso si no hay suficiente stock:
CREATE OR REPLACE FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
RETURN NUMBER
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;
   v_precio NUMBER;
BEGIN
   SELECT PRECIO INTO v_precio
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      INSERT INTO CABECERA_PEDIDO 
         VALUES (p_num_pedido, p_dni, SYSDATE);
      INSERT INTO LINEA_PEDIDO
         VALUES (p_num_pedido, 1, p_nombre_producto, p_cantidad);
      
      COMMIT;
      
      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');
      RETURN v_precio * p_cantidad;
   ELSE
      SELECT STOCK INTO v_stock_actual
         FROM PRODUCTOS
         WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
      RETURN 0;
   END IF;

EXCEPTION
   WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido.'|| v_stock_actual);
END;
/

CREATE OR REPLACE FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER, descuento NUMBER)
RETURN NUMBER
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;
   v_precio NUMBER;
   porcentaje NUMBER := 1 - (descuento / 100);
BEGIN
   SELECT PRECIO INTO v_precio
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      INSERT INTO CABECERA_PEDIDO 
         VALUES (p_num_pedido, p_dni, SYSDATE);
      INSERT INTO LINEA_PEDIDO  
         VALUES (p_num_pedido, 1, p_nombre_producto, p_cantidad);
      
      COMMIT;
      
      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');
      
      RETURN v_precio * p_cantidad * porcentaje;
   ELSE
      SELECT STOCK INTO v_stock_actual
         FROM PRODUCTOS
         WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
      RETURN 0;
   END IF;

EXCEPTION
   WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido.'|| v_stock_actual);
END;
/
--Con estos componentes en su lugar, puedes llamar al procedimiento AddProductoPedido para realizar un pedido y verificar automáticamente si hay suficiente stock disponible. Por ejemplo:
BEGIN
   AddProductoPedido(123, 10); -- Llamar al procedimiento con el código de producto y la cantidad deseada.
END;





-- Trigger para controlar modificaciones en la tabla PRODUCTOS 777
DROP TABLE AUDITAR_PRODUCTOS CASCADE CONSTRAINTS;
CREATE TABLE AUDITAR_PRODUCTOS(
    COL1 VARCHAR(200)
);

CREATE OR REPLACE TRIGGER AUDITAR_PROD
   BEFORE INSERT OR UPDATE OR DELETE ON PRODUCTOS
   FOR EACH ROW
BEGIN
   IF INSERTING OR UPDATING THEN
      INSERT INTO AUDITAR_PRODUCTOS VALUES('Stock actualizado ' || :NEW.NOMBRE_P || ': previo: ' || :OLD.STOCK || ' nuevo: ' || :NEW.STOCK);
   ELSIF DELETING THEN
      INSERT INTO AUDITAR_PRODUCTOS VALUES('Producto eliminado ' || :OLD.NOMBRE_P || ': ' || :OLD.STOCK);
   END IF;
END;
/




-- Trigger para controlar modificaciones en la tabla LINEA_PEDIDO 777
CREATE OR REPLACE TRIGGER VerificarStockPedido
BEFORE INSERT OR UPDATE ON LINEA_PEDIDO
FOR EACH ROW
DECLARE
   v_stock_actual NUMBER;
BEGIN
   IF INSERTING OR UPDATING THEN
      -- Verificar si hay suficiente stock para el producto antes de realizar un pedido
      SELECT STOCK INTO v_stock_actual
      FROM PRODUCTOS
      WHERE NOMBRE_P = :NEW.CODIGO;

      IF v_stock_actual < :NEW.CANTIDAD THEN
         RAISE_APPLICATION_ERROR(-20001, 'No hay suficiente stock para realizar el pedido.');
      END IF;
   END IF;
END;
/
--En el primer trigger, llamado ActualizarStock, se actualiza el valor del stock después de una inserción o actualización en la tabla PRODUCTOS, o se restaura el stock antes de una eliminación en la tabla PRODUCTOS.

--En el segundo trigger, llamado VerificarStockPedido, se verifica si hay suficiente stock para el producto antes de realizar un pedido en la tabla LINEA_PEDIDO. Si no hay suficiente stock, se lanza un error de aplicación con un mensaje de aviso.

--Estos triggers se activarán automáticamente cada vez que se realicen modificaciones en las tablas PRODUCTOS y LINEA_PEDIDO, lo que garantizará la integridad del control de stock en tiempo real.




--Creo que voy a hacer una función que sea igual pero sobrecargando la función, para meterla en el mismo paquete. Y que además la otra función sea un parámetro extra, cupón descuento. Y te haga básicamente esto:
CREATE OR REPLACE FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER, descuento NUMBER)
RETURN NUMBER
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;
   v_precio NUMBER;
   porcentaje NUMBER := 1 - (descuento / 100);
BEGIN
   SELECT PRECIO INTO v_precio
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      INSERT INTO CABECERA_PEDIDO
         VALUES (p_num_pedido, p_dni, SYSDATE);
      INSERT INTO LINEA_PEDIDO 
         VALUES (p_num_pedido, 1, p_nombre_producto, p_cantidad);
      
      COMMIT;
      
      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');
      
      RETURN v_precio * p_cantidad * porcentaje;
   ELSE
      SELECT STOCK INTO v_stock_actual
         FROM PRODUCTOS
         WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
      RETURN 0;
   END IF;

EXCEPTION
   WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido.'|| v_stock_actual);
END;
/

CREATE OR REPLACE FUNCTION INCREMENTAR(
    VALOR NUMBER, INCREMENTO NUMBER
)
RETURN NUMBER
IS
    PORCENTAJE NUMBER := 1 + (INCREMENTO / 100);
    
BEGIN
    RETURN VALOR * PORCENTAJE;

END;
/
SELECT TITULO, PRECIO, INCREMENTAR(PRECIO, 20) "PRECIO + 20%" FROM LIBROS;

SELECT TITULO, PRECIO, INCREMENTAR(PRECIO, 100) "PRECIO + 100%" FROM LIBROS;

--borrar productos porque ya no se venden
CREATE OR REPLACE PROCEDURE BORRAR_ASIGNATURAS
IS
BEGIN
    DELETE FROM ASIGNATURAS
        WHERE COD > 5;
    DBMS_OUTPUT.PUT_LINE('Eliminadas ' || SQL%ROWCOUNT || ' filas.');

END;
/
EXECUTE BORRAR_ASIGNATURAS;

--trigger control de conexiones
CREATE TABLE CONTROL_CONEXIONES(
    USUARIO VARCHAR2(20),
    MOMENTO TIMESTAMP,
    EVENTO VARCHAR2(20)
);
CREATE OR REPLACE TRIGGER AUDITAR_CONEXIONES
    AFTER LOGON 
    ON DATABASE

BEGIN
    INSERT INTO CONTROL_CONEXIONES VALUES(ORA_LOGIN_USER,SYSTIMESTAMP, ORA_SYSEVENT);
    
END;
/



CREATE OR REPLACE PACKAGE GestionPedidos AS
  FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
    RETURN NUMBER;
    
  FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER, descuento NUMBER)
    RETURN NUMBER;

  FUNCTION VerificarStock(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
    RETURN BOOLEAN;
END GestionPedidos;
/

CREATE OR REPLACE PACKAGE BODY GestionPedidos AS
  FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
    RETURN NUMBER
  IS
    v_stock_actual NUMBER;
    Sin_stock_Exception EXCEPTION;
    v_precio NUMBER;
  BEGIN
    SELECT PRECIO INTO v_precio
    FROM PRODUCTOS
    WHERE NOMBRE_P = p_nombre_producto;

    IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      INSERT INTO CABECERA_PEDIDO 
      VALUES (p_num_pedido, p_dni, SYSDATE);
      INSERT INTO LINEA_PEDIDO 
      VALUES (p_num_pedido, 1, p_nombre_producto, p_cantidad);

      COMMIT;

      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');
      RETURN v_precio * p_cantidad;
    ELSE
      SELECT STOCK INTO v_stock_actual
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
      RETURN 0;
    END IF;
  EXCEPTION
    WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido. ' || v_stock_actual);
  END AddProductoPedido;

  FUNCTION AddProductoPedido(p_nombre_producto VARCHAR2, p_cantidad NUMBER, descuento NUMBER)
    RETURN NUMBER
  IS
    v_stock_actual NUMBER;
    Sin_stock_Exception EXCEPTION;
    v_precio NUMBER;
    porcentaje NUMBER := 1 - (descuento / 100);
  BEGIN
    SELECT PRECIO INTO v_precio
    FROM PRODUCTOS
    WHERE NOMBRE_P = p_nombre_producto;

    IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      INSERT INTO CABECERA_PEDIDO 
      VALUES (p_num_pedido, p_dni, SYSDATE);
      INSERT INTO LINEA_PEDIDO 
      VALUES (p_num_pedido, 1, p_nombre_producto, p_cantidad);

      COMMIT;

      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');

      RETURN v_precio * p_cantidad * porcentaje;
    ELSE
      SELECT STOCK INTO v_stock_actual
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
      RETURN 0;
    END IF;
  EXCEPTION
    WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido. ' || v_stock_actual);
  END AddProductoPedido;

  FUNCTION VerificarStock(p_nombre_producto VARCHAR2, p_cantidad NUMBER)
    RETURN BOOLEAN
  IS
    v_stock_actual NUMBER;
  BEGIN
    SELECT STOCK INTO v_stock_actual
    FROM PRODUCTOS
    WHERE NOMBRE_P = p_nombre_producto;

    RETURN v_stock_actual >= p_cantidad;
  END VerificarStock;
END GestionPedidos;
/


--pruebITAS
DECLARE
  CURSOR c1 IS
    SELECT CODIGO FROM PRODUCTOS;
  v_codigo_producto PRODUCTOS.CODIGO%TYPE;
BEGIN
   OPEN c1;
   LOOP
      FETCH c1 INTO v_codigo_producto;
      EXIT WHEN c1%NOTFOUND;
      UPDATE PRODUCTOS SET STOCK = 15 WHERE CODIGO = v_codigo_producto;
    COMMIT;
   END LOOP;
   CLOSE c1;
  DBMS_OUTPUT.PUT_LINE('Valores insertados en la columna STOCK.');
END;
/

DECLARE
  CURSOR c1 IS
    SELECT CODIGO FROM PRODUCTOS;
  v_codigo_producto PRODUCTOS.CODIGO%TYPE;
BEGIN
   OPEN c1;
   LOOP
      FETCH c1 INTO v_codigo_producto;
      EXIT WHEN c1%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(v_codigo_producto);
    COMMIT;
   END LOOP;
   CLOSE c1;
  DBMS_OUTPUT.PUT_LINE('Valores insertados en la columna STOCK.');
END;
/



CREATE OR REPLACE PROCEDURE ActualizarStock IS
  CURSOR c_productos IS
    SELECT CODIGO FROM PRODUCTOS;
  v_codigo_producto_binario PRODUCTOS.CODIGO%TYPE;
  v_codigo_producto_decimal NUMBER;
  v_stock_actual PRODUCTOS.STOCK%TYPE;
  codigo_incorrecto EXCEPTION;
BEGIN
  OPEN c_productos;
  FETCH c_productos INTO v_codigo_producto_binario;

  WHILE c_productos%FOUND LOOP
    v_codigo_producto_decimal := BinarioADecimal(v_codigo_producto_binario);
    SELECT STOCK INTO v_stock_actual
    FROM PRODUCTOS
    WHERE CODIGO = v_codigo_producto_decimal;
    
      IF v_codigo_producto_decimal > 255 THEN
         RAISE codigo_incorrecto; --8 bits encendidos son 255
      ELSIF v_codigo_producto_decimal > 8 THEN
         UPDATE PRODUCTOS
         SET STOCK = v_stock_actual + 20
         WHERE CODIGO = v_codigo_producto_decimal;
      ELSE
         UPDATE PRODUCTOS
         SET STOCK = v_stock_actual + 10
         WHERE CODIGO = v_codigo_producto_decimal;
      END IF;
    COMMIT;
    FETCH c_productos INTO v_codigo_producto_binario;
  END LOOP;
  CLOSE c_productos;
  
  DBMS_OUTPUT.PUT_LINE('Stock actualizado exitosamente.');
EXCEPTION
   WHEN codigo_incorrecto THEN
    DBMS_OUTPUT.PUT_LINE('Error al actualizar stock: 8 bits a 1 es 255 max');
   WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error al actualizar el stock: ' || SQLERRM);
END;
/
Execute ActualizarStock();

CREATE OR REPLACE FUNCTION BinarioADecimal(binario IN VARCHAR2) RETURN NUMBER IS
  decimal NUMBER := 0;
BEGIN
  FOR i IN REVERSE 1..LENGTH(binario) LOOP
    DECLARE
      digito NUMBER := TO_NUMBER(SUBSTR(binario, i, 1)); 
      posicion NUMBER := LENGTH(binario) - i; 
    BEGIN
      decimal := decimal + (digito * POWER(2, posicion)); 
    END;
  END LOOP;
  
  RETURN decimal;
END;
/


--Primero, vamos a modificar la tabla de PRODUCTOS:
--Hay esceso de código porque he ido probando, es más la muestra del proceso.
ALTER TABLE PRODUCTOS ADD STOCK NUMBER(10);


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

DECLARE
  v_producto VARCHAR2(100) := 'HEURA';
  v_cantidad NUMBER := 10; 
  v_resultado BOOLEAN;
BEGIN
  v_resultado := VerificarStock(v_producto, v_cantidad);
  
  IF v_resultado THEN
    DBMS_OUTPUT.PUT_LINE('El producto ' || v_producto || ' tiene suficiente stock.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('El producto ' || v_producto || ' no tiene suficiente stock.');
  END IF;
END;
/ 



CREATE OR REPLACE FUNCTION AddProductoPedido(p_num_pedido VARCHAR2, p_nombre_producto VARCHAR2, p_cantidad NUMBER)
RETURN NUMBER
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;
   v_precio NUMBER;
   v_num_linea VARCHAR2(2);
   v_num_linea_number NUMBER;
BEGIN
   SELECT PRECIO INTO v_precio
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      SELECT NVL(MAX(SUBSTR(NUM_LINEA, 2)), 0) + 1 INTO v_num_linea_number
         FROM LINEA_PEDIDO
         WHERE NUM_PEDIDO = p_num_pedido;

      v_num_linea := 'P' || TO_CHAR(v_num_linea_number);
      
      INSERT INTO LINEA_PEDIDO (NUM_LINEA, CANTIDAD, NUM_PEDIDO, COD_PRODUCTO)
         VALUES (v_num_linea, p_cantidad, p_num_pedido, p_nombre_producto);   
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
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido. Stock actual: ' || v_stock_actual);
      RETURN 0;
END;
/




CREATE OR REPLACE FUNCTION AddProductoPedido(p_num_pedido VARCHAR2, p_nombre_producto VARCHAR2, p_cantidad NUMBER)
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



CREATE OR REPLACE PROCEDURE AddProductoPedido(p_num_pedido VARCHAR2, p_nombre_producto VARCHAR2, p_cantidad NUMBER)
IS
   v_stock_actual NUMBER;
   Sin_stock_Exception EXCEPTION;
   v_precio NUMBER;
   v_num_linea NUMBER;
BEGIN
   SELECT PRECIO INTO v_precio
      FROM PRODUCTOS
      WHERE NOMBRE_P = p_nombre_producto;

   IF VerificarStock(p_nombre_producto, p_cantidad) THEN
      SELECT NVL(MAX(NUM_LINEA), 0) + 1 INTO v_num_linea
         FROM LINEA_PEDIDO
         WHERE NUM_PEDIDO = p_num_pedido;

      INSERT INTO LINEA_PEDIDO (NUM_PEDIDO, NUM_LINEA, COD_PRODUCTO, CANTIDAD)
         VALUES (p_num_pedido, v_num_linea, p_nombre_producto, p_cantidad);
      
      UPDATE CABECERA_PEDIDO
      SET FECHA = SYSDATE
      WHERE NUM_PEDIDO = p_num_pedido;
      
      COMMIT;
      
      DBMS_OUTPUT.PUT_LINE('¡Pedido realizado exitosamente!');
      DBMS_OUTPUT.PUT_LINE('Precio total: ' || v_precio * p_cantidad);
   ELSE
      SELECT STOCK INTO v_stock_actual
         FROM PRODUCTOS
         WHERE NOMBRE_P = p_nombre_producto;
      RAISE Sin_stock_Exception;
   END IF;

EXCEPTION
   WHEN Sin_stock_Exception THEN
      DBMS_OUTPUT.PUT_LINE('No hay suficiente stock para realizar el pedido. Stock actual: ' || v_stock_actual);
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




-- Trigger para controlar modificaciones en la tabla LINEA_PEDIDO 999
CREATE OR REPLACE TRIGGER VerificarStockPedido
BEFORE INSERT OR UPDATE ON LINEA_PEDIDO
FOR EACH ROW
DECLARE
   v_stock_actual NUMBER;
BEGIN
   IF INSERTING OR UPDATING THEN
      SELECT STOCK INTO v_stock_actual
      FROM PRODUCTOS
      WHERE NOMBRE_P = :OLD.CODIGO;

      IF v_stock_actual < :NEW.CANTIDAD THEN
         RAISE_APPLICATION_ERROR(-20001, 'No hay suficiente stock para realizar el pedido.');
      END IF;
   END IF;
END;
/





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



-- trigger control de conexiones 777
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
    WHERE CODIGO = v_codigo_producto_binario;
    
      IF v_codigo_producto_decimal > 255 THEN
         RAISE codigo_incorrecto; --8 bits encendidos son 255
      ELSIF v_codigo_producto_decimal > 8 THEN
         UPDATE PRODUCTOS
         SET STOCK = v_stock_actual + 20
         WHERE CODIGO = v_codigo_producto_binario;
      ELSE
         UPDATE PRODUCTOS
         SET STOCK = v_stock_actual + 10
         WHERE CODIGO = v_codigo_producto_binario;
      END IF;
    FETCH c_productos INTO v_codigo_producto_binario;
  END LOOP;
   COMMIT;
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
    FETCH c_productos INTO v_codigo_producto_binario;
  END LOOP;
   COMMIT;
  CLOSE c_productos;
  
  DBMS_OUTPUT.PUT_LINE('Stock actualizado exitosamente.');
EXCEPTION
   WHEN codigo_incorrecto THEN
    DBMS_OUTPUT.PUT_LINE('Error al actualizar stock: 8 bits a 1 es 255 max');
   WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Error al actualizar el stock: ' || SQLERRM);
END;
/


CREATE OR REPLACE FUNCTION producto_estrella
  RETURN VARCHAR2
IS
  v_codprod VARCHAR2(9);
  v_nombprod VARCHAR2(15);
BEGIN
  SELECT COD_PRODUCTO INTO v_codprod
  FROM (
    SELECT COD_PRODUCTO, SUM(CANTIDAD) AS vendido
    FROM LINEA_PEDIDO
    GROUP BY COD_PRODUCTO
    ORDER BY vendido DESC
  ) WHERE ROWNUM = 1;
  
  SELECT NOMBRE_P INTO v_nombprod
  FROM PRODUCTOS
  WHERE CODIGO = v_codprod;
  
  RETURN v_nombprod;
END;
/
select producto_estrella() from dual;


CREATE OR REPLACE FUNCTION Mostrar_Producto_Impopular
  RETURN VARCHAR2
IS
 v_codprod VARCHAR2(9);
  v_nombprod VARCHAR2(15);
BEGIN
SELECT COD_PRODUCTO INTO v_codprod
  FROM (
    SELECT COD_PRODUCTO, SUM(CANTIDAD) AS vendido
    FROM LINEA_PEDIDO
    GROUP BY COD_PRODUCTO
    ORDER BY vendido ASC
  ) WHERE ROWNUM = 1;
  
  SELECT NOMBRE_P INTO v_nombprod
  FROM PRODUCTOS
  WHERE CODIGO = v_codprod;
  
  RETURN v_codprod;
  DBMS_OUTPUT.PUT_LINE('Si quieres puedes eliminar el producto ' || v_nombprod || ' con el código ' || v_codprod || ' con el comando: execute Eliminar_Producto_Impopular();.');
END;
/
  
select Mostrar_Producto_Impopular() from dual;

--borrar productos porque ya no se venden
CREATE OR REPLACE PROCEDURE Eliminar_Producto IS
  v_codprod VARCHAR2(9);
  v_nombprod VARCHAR2(15);
BEGIN --llama a mostrar producto impopular
  DELETE FROM PRODUCTOS
  WHERE CODIGO = mostrar_producto_impopular();
  
  DBMS_OUTPUT.PUT_LINE('Eliminadas ' || SQL%ROWCOUNT || ' filas.');
END;
/
execute Eliminar_Producto();

CREATE OR REPLACE FUNCTION clientes_habituales()
   RETURN VARCHAR2
IS
  CURSOR c1 IS
    SELECT nombre, dni
    FROM cliente
    WHERE dni IN (
      SELECT dni
      FROM cabecera_pedido
      GROUP BY dni
      HAVING COUNT(*) > 2
    );

  v_nombre cliente.nombre%TYPE;
  v_dni cliente.dni%TYPE;
BEGIN
  OPEN c1;

  LOOP
    FETCH c1 INTO v_nombre, v_dni;
    EXIT WHEN c1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE('El cliente ' || v_nombre || ' con dni ' || v_dni || ' es habitual');
  END LOOP;

  CLOSE c1;
  DBMS_OUTPUT.PUT_LINE('Mensaje comprobación, función ejecutada correctamente.');
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('No se ha encontrado ningún cliente habitual');
END;
/
EXECUTE clientes_habituales;


CREATE OR REPLACE FUNCTION clientes_habituales
RETURN VARCHAR2
IS
  v_result VARCHAR2(300);
  v_message VARCHAR2(300);
  no_clientes EXCEPTION;
BEGIN
  SELECT LISTAGG('El cliente ' || nombre || ' con dni ' || dni || ' es habitual', ', ') WITHIN GROUP (ORDER BY dni)
    INTO v_result
    FROM cliente
    WHERE dni IN (
      SELECT dni
      FROM cabecera_pedido
      GROUP BY dni
      HAVING COUNT(*) > 2
    );

  IF v_result IS NULL THEN
    v_message := 'Sin resultados.';
    raise no_clientes;
  ELSE
    v_message := 'Clientes habituales: ' || v_result;
  END IF;

  RETURN v_message;
EXCEPTION
  WHEN no_clientes THEN
    dbms_output.put_line('No se ha encontrado ningún cliente habitual.');
END;
/
select clientes_habituales() from dual;

INSERT INTO CABECERA_PEDIDO VALUES('P007','01/03/2023','51125737J');


CREATE OR REPLACE PACKAGE DescuentoPedidoPackage AS
   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2)
      RETURN NUMBER;

   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2, p_porcentaje_descuento NUMBER)
      RETURN NUMBER;
END DescuentoPedidoPackage;
/

CREATE OR REPLACE PACKAGE BODY DescuentoPedidoPackage AS
   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2)
      RETURN NUMBER IS
      v_coste_total NUMBER;
   BEGIN
      -- Cálculo del coste total del pedido

      -- Aquí va el código para calcular el coste total del pedido con el número de pedido p_num_pedido
      
      RETURN v_coste_total;
   END CalcularDescuento;

   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2, p_porcentaje_descuento NUMBER)
      RETURN NUMBER IS
      v_coste_total NUMBER;
   BEGIN
      -- Cálculo del coste total del pedido con descuento

      -- Aquí va el código para calcular el coste total del pedido con el número de pedido p_num_pedido
      -- aplicando el descuento p_porcentaje_descuento
      
      RETURN v_coste_total;
   END CalcularDescuento;
END DescuentoPedidoPackage;
/


CREATE OR REPLACE PACKAGE DescuentoPedidoPackage AS
   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2)
      RETURN NUMBER;

   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2, p_porcentaje_descuento NUMBER)
      RETURN NUMBER;
END DescuentoPedidoPackage;
/

CREATE OR REPLACE PACKAGE BODY DescuentoPedidoPackage AS
   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2)
      RETURN NUMBER IS
      v_coste_total NUMBER;
   BEGIN
      SELECT SUM(CANTIDAD * PRECIO) INTO v_coste_total
      FROM LINEA_PEDIDO lp
      JOIN PRODUCTOS p ON lp.COD_PRODUCTO = p.CODIGO
      WHERE lp.NUM_PEDIDO = p_num_pedido;

      RETURN v_coste_total;
   END CalcularDescuento;

   FUNCTION CalcularDescuento(p_num_pedido VARCHAR2, p_porcentaje_descuento NUMBER)
      RETURN NUMBER IS
      v_coste_total NUMBER;
   BEGIN
      SELECT SUM(CANTIDAD * PRECIO * (1 - p_porcentaje_descuento/100)) INTO v_coste_total
      FROM LINEA_PEDIDO lp
      JOIN PRODUCTOS p ON lp.COD_PRODUCTO = p.CODIGO
      WHERE lp.NUM_PEDIDO = p_num_pedido;

      RETURN v_coste_total;
   END CalcularDescuento;
END DescuentoPedidoPackage;
/


-- Llamada a la función CalcularDescuento sin descuento aplicado
DECLARE
   v_coste_total_sin_descuento NUMBER;
   v_num_pedido VARCHAR2(4) := 'P001';
BEGIN
   v_coste_total_sin_descuento := DescuentoPedidoPackage.CalcularDescuento(v_num_pedido);
   DBMS_OUTPUT.PUT_LINE('Coste total sin descuento: ' || v_coste_total_sin_descuento);
END;
/

-- Llamada a la función CalcularDescuento con descuento del 10% aplicado
DECLARE
   v_coste_total_con_descuento NUMBER;
   v_num_pedido VARCHAR2(4) := 'P001';
   v_porcentaje_descuento NUMBER := 10;
BEGIN
   v_coste_total_con_descuento := DescuentoPedidoPackage.CalcularDescuento(v_num_pedido, v_porcentaje_descuento);
   DBMS_OUTPUT.PUT_LINE('Coste total con descuento (' || v_porcentaje_descuento || '%): ' || v_coste_total_con_descuento);
END;
/

CREATE OR REPLACE PROCEDURE CalcularDescuentoProcedimiento 
IS
   v_coste_total_con_descuento NUMBER;
   v_num_pedido VARCHAR2(4) := 'P001';
   v_porcentaje_descuento NUMBER := 10;
BEGIN
   v_coste_total_con_descuento := DescuentoPedidoPackage.CalcularDescuento(v_num_pedido, v_porcentaje_descuento);
   DBMS_OUTPUT.PUT_LINE('Coste total con descuento (' || v_porcentaje_descuento || '%): ' || v_coste_total_con_descuento);
END;
/

CREATE OR REPLACE PROCEDURE CalcularDescuentoProcedimiento AS
   v_coste_total_con_descuento NUMBER;
   v_num_pedido VARCHAR2(4) := 'P001';
   v_porcentaje_descuento NUMBER := 10;
   v_multiplicador_descuento NUMBER := 1;
   v_clientes_habituales VARCHAR2(200);
BEGIN
   v_clientes_habituales := clientes_habituales();

   IF INSTR(v_clientes_habituales, 'No se ha encontrado ningún cliente habitual') = 0 THEN
      IF INSTR(v_clientes_habituales, v_num_pedido) > 0 THEN
         v_multiplicador_descuento := 2;
      END IF;
   END IF;

   v_coste_total_con_descuento := DescuentoPedidoPackage.CalcularDescuento(v_num_pedido, v_porcentaje_descuento * v_multiplicador_descuento);
   DBMS_OUTPUT.PUT_LINE('Coste total con descuento (' || v_porcentaje_descuento || '%): ' || v_coste_total_con_descuento);
END;
/

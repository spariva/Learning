/*este es el 2.5 pero Karla no me dejaba */
/*Imprime por pantalla los números del 0 al 30 en una columna. 
En las 2 siguientes columnas imprime el resultado de la división entera entre 2 
y el resultado de calcular el módulo 2 de cada número. Haz lo mismo para la división y módulo para 3, 4, 5 y 7.
Ejemplo de fragmento de salida sin formatear. Utilizar printf()/String.format() 
para que se visualicen las columnas debajo de la cabecera "n n/2...":

n n/2 n%2 n/3 n%3 n/4 n%4 n/5 n%5 n/7 n%7
0 0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 1 0 1 0 1
2 1 0 0 2 0 2 0 2 0 2
3 1 1 1 0 0 3 0 3 0 3
[...]*/
public class Arrays4{
    public static void main(String[] args) {
        int[] matriz = new int[30];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = i;
            printf(matriz[i]);
        }

        
    }
}

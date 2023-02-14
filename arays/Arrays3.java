package arays;

public class Arrays3 {
    public static void main(String[] args) {
        int[][] matriz = new int[4][7];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i/4][i%7] = (int)Math.random()*101;
            if(i<4){
              System.out.print(matriz[i/4][i%7]);
            }else{
              
            }
            
        }
    }
    /*    Crea una matriz de 4 filas y 7 columnas de tipo int. Inicializa cada posición del array con un número aleatorio entre el 0 y el 100 e imprime la matriz por pantalla.
     Tanto para inicializar los valores como para imprimirlos, utiliza un único bucle for, NO 2 bucles anidados, para acceder a las posiciones del array bidimensional, 
     tanto para asignarles valor como para imprimirlas. Piensa en cómo se inicializaban e imprimían las posiciones del array bidimensional matrix en la pregunta 
     tipo test del examen que se ha invalidado (mira el foro de Programación si no sabes a cuál nos referimos)

Actualización 20230214-18:19: Por último, imprime la matriz de 4 filas y 7 columnas recorriéndola por columnas, 
de forma que se imprima como si fuese una matriz de 7 filas por 4 columnas. Sería el equivalente a imprimir la matriz traspuesta.

Ejemplo:

Si la matriz aleatoria original era:

  1   2   3   4   5   6   7
  8   9 10 11 12 13 14
15 16 17 18 19 20 21
22 23 24 25 26 27 28

En la actualización se pide que se imprima, utilizando un único bucle for, de la siguiente forma:

  1   2   3   4
  5   6   7   8
  9 10 11 12
13 14 15 16
17 18 19 20
21 22 23 24
25 26 27 28

Actualización 20230214-1828: Se recomienda revisar la explicación sobre álgebra modular en este enlace 
(https://es.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/what-is-modular-arithmetic), 
que por cierto es una sección de un curso de criptografía. No hace falta prestar atención a la operación módulo con números negativos. */
}

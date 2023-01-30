package arays;

/*Define tres arrays de 20 números enteros cada uno, con nombres número, cuadrado
 y cubo.
 Carga el array numero con valores aleatorios entre 0 y 100. En el array
 cuadrado se deben almacenar los cuadrados de los valores que hay en el array
 número.
 En el array cubo se deben almacenar los cubos de los valores que hay en
 numero. A continuación, muestra el contenido de los tres arrays dispuesto en tres
 columnas.*/

public class Arrays1 {
    public static void main(String[] args) {
        int[] number = new int[20];
        int[] square = new int[20];
        int[] cube = new int[20];

        for (int i = 0; i < cube.length; i++) {
            number[i]=(int)(Math.random()*100+1);
            square[i]=(int) Math.pow(number[i],2);
            cube[i]=(int)Math.pow(number[i],3);
        }

        /* No se podría imprimir en un array unidimensional y cambiar columnas por filas. Porque imprime de izq a derecha la consola. (transposición array y giras el cubo).
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube.length; j++) {
                System.out.print(number[j]+"   ");
            }
            System.out.println();
        }*/

    for (int i = 0; i < cube.length; i++) {
        System.out.printf("1. %7d   2. %7d   3. %7d%n", number[i], square[i], cube[i]);
    }
    }
    
}

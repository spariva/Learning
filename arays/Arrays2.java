package arays;
public class Arrays2{
    public static void main(String[] args) {
                /*Escribe un programa que genere 20 números aleatorios entre 1 y 100. Estos
        números se deben introducir en un array de dos dimensiones, de 4 filas por
        5 columnas. El programa mostrará las sumas parciales de filas y columnas
        igual que si de una hoja de cálculo se tratara. La suma total debe aparecer
        en la esquina inferior derecha. 

        Ejemplo salida:
        1   2  3  4  5 | 15
        6   7  8  9 10 | 40
        11 12 13 14 15 | 65
        16 17 18 19 20 | 90
        ___________________
        34 38 43 46 50 | 210 "pretty comments" - pretty woman (cuando pongas el comentario que suene la banda sonora de la peli)*/

        int [][] array2 = new int [5][6];

        for (int i = 0, a=0; i < array2.length; i++, a++) {
            for (int j = 0, b=0; j < array2[i].length; j++, b++){
                if(i != 4 && j != 5){
                    array2[i][j] = (int)(Math.random()*100+1); //para que no cargue en la casilla de suma total.
                }
                if(a != 4 && b != 5){
                    array2[i][5] += array2[a][b];
                    array2[4][j] += array2[i][j];
                    array2[4][5] += array2[i][j];
                } //no entiendo por qué me suma el doble...
            }
        }

        ev1.Metodos.mostrarArray("", array2, 6);
        



}
}

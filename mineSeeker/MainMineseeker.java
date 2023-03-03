package mineSeeker;

import mineSeeker.src.Board;

public class MainMineseeker {
    public static void main(String[] args) {
        Board b = new Board();
        b.imprimir();    
        b.generateCells();
        b.imprimir(); 

    }
}
/*Implementa el juego buscaminas por línea de comandos.

Crea un array de 6x6. Genera aleatoriamente la posición de 3 minas.

Comienza la partida:

El jugador introducirá la posición de una celda (fila y columna). Si hay una mina, el jugador pierde. Si no hay mina, se descubrirá la casilla indicando el número de bombas que hay en sus 8 celdas adyacentes.

Podéis ver el enunciado del ejercicio análogo, pero con interfaz gráfica, aquí: https://progra-utfsm.readthedocs.io/en/latest/ejercicios/3/buscaminas-grafico.html

Sé que el problema queda muy abierto y hay muchos detalles que tenéis que pensar por vuestra cuenta. Hay muchas formas diferentes de implementarlo. Quiero vero lo que se os va ocurriendo.

En la próxima clase revisaremos lo que se nos ocurre.

Enlace al juego online: https://buscaminas.eu/ */
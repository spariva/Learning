package mineSeeker.src;

public class Board {
    private Cell[][] board;
    private Cell bombPosition1;
    private final int ANCHO = 6;
    private final int ALTO = 6;
    private final int MINES_AMOUNT = 3;

    public Board() {
        board = new Cell[ALTO][ANCHO];

        /*for (int i = 0; i < MINES_AMOUNT; i++) {
            randomBombs();
        }*/
    }
    public void generateCells(){
        for (int i = 0; i < ANCHO; i++) {
            for (int j = 0; j < ALTO; j++) {
            board[i][j] = new Cell();
            }
        }
    }

    public Cell randomBombs() {
        bombPosition1 = new Cell();
        board[(int)(Math.random()*ALTO)][(int)(Math.random()*ANCHO)] = bombPosition1;

        bombPosition1.setBomb(true);

        return bombPosition1;
    }
    public void imprimir(){
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

}

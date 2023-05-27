package mineSeeker.src;

public class Board {
    private Cell[][] board;
    private final int ANCHO = 6;
    private final int ALTO = 6;
    private final int TOTAL_BOMBS = 3;
    private boolean endGame = false;
    private int totalVisibles;

    public Board() {
        Cell[][] board = new Cell[ALTO][ANCHO];
        generateCells();
    }

    public boolean getEndGame() {
        return endGame;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void generateCells(){
        for (int i = 0; i < ANCHO; i++) {
            for (int j = 0; j < ALTO; j++) {
            board[i][j] = new Cell();
            }
        }
        randomizeBombPositions();
    }

    public void imprimir(){
        for (int i = 0; i < ALTO; i++) {
            for (int j = 0; j < ANCHO; j++) {
                if(j == 0){

                    System.out.print("\n" + "  " + board[i][j]);
                }else{
                    System.out.print("  " + board[i][j]);
                }
            }
        }
    }

    public void randomizeBombPositions() {
        for (int i = 0; i < TOTAL_BOMBS; i++){
        board[(int)(Math.random()*ALTO)][(int)(Math.random()*ANCHO)].setBomb(true);
        }
    }

    public void clickPosition(int posY, int posX){
        if(board[posY][posX].getBomb()){
            board[posY][posX].setVisible(true);
            System.out.println("\tBoom! =(");
            setEndGame(true);
        }else if(board[posY][posX].getVisible()){
            System.out.println("This is already visible!");
        }else{
            board[posY][posX].setVisible(true);
            totalVisibles++;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if(i == 0 && j == 0) continue;
                    if(posY + i < 0 || posX + j < 0 || posY + i > ANCHO-1 || posX + j > ALTO-1){
                        continue;
                    }
                    if(board[posY + i][posX + j].getBomb()){
                        Integer num = board[posY][posX].getValue() + 1;
                        board[posY][posX].setValue(num);
                    }
                }
            }
            if(board[posY][posX].getValue() == 0){
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if(i == 0 && j == 0) continue;
                        if(posY + i < 0 || posX + j < 0 || posY + i > ANCHO-1 || posX + j > ALTO-1){
                            continue;
                        }
                        if (board[posY+i][posX+j].getVisible()){
                            continue;
                        }else{
                            clickPosition(posY+i, posX+j);
                        }
                    }
                }
            }
            if(totalVisibles==ANCHO*ALTO-TOTAL_BOMBS){
                System.out.println("Congrats you won!");
                setEndGame(true);
            }

            /*no sé si meter algo que cuente cuántas casillas quedan visibles, meter un static global que aumente por cada casilla visible y un if(contador==ANCHO*ALTO-TOTAL_MINES_AMOUNT). O un método para switchear entre picar celdas o marcar bombas. Pero seguiría entonces teniendo el problema de comprobar la victoria...

            Molaría cambiar el ejercicio a ArrayList y que por cada pantalla resuelta se hiciera 1 fila y columna más grande... Bueno no tendría por qué ser ArrayList, tan solo incrementar ancho y alto.
            */
        }
    }
}

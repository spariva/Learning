package mineSeeker.src;

public class Board {
    private Cell[][] board;
    private final int ANCHO = 3;
    private final int ALTO = 3;
    private final int TOTAL_BOMBS = 2;
    private boolean endGame = false;

    public Board() {
        board = new Cell[ALTO][ANCHO];
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
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if(i == 0 && j == 0) continue;
                    if(posY + i < 0 || posY + j < 0 || posY + i > ANCHO-1 || posX + j > ALTO-1){
                        continue;
                    }
                    if(board[posY + i][posX + j].getBomb()){
                        Integer num = board[posY][posX].getValue() + 1;
                        board[posY][posX].setValue(num);
                    }
                }
            }
        }

        
        
    }
}

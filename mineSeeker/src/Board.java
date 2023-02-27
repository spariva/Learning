package mineSeeker.src;

public class Board {
    private Cell[][] board;
    private Cell bombPosition1;
    private int minesAmount = 3;

    public Board() {
        board = new Cell[6][6];
        randomBombs(this.board);
        
    }

    public Board randomBombs(Board board) {
        for (int i = 0; i < this.minesAmount; i++) {
            bombPosition1 = new Cell();
            board[(int)(Math.random()*7)][(int)(Math.random()*7)] = bombPosition1;
            bombPosition1.setBomb(true);
        }
        return board;
    }
    /*    private Cell[][] board;
    private Cell bombPosition1;
    private int minesAmount = 3;

    public Board() {
        board = new Cell[6][6];
        for (int i = 0; i < minesAmount; i++) {
            randomBombs();
        }
    }

    public Cell randomBombs() {
        bombPosition1 = new Cell();
        board[(int)(Math.random()*7)][(int)(Math.random()*7)] = bombPosition1;

        bombPosition1.setBomb(true);

        return bombPosition1;
    } */





    
    


    
    
    
    


}

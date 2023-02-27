package mineSeeker.src;

public class Board {
    private int[][] board;
    private int bombPosition1;
    private int minesAmount = 3;

    public Board() {
        board = new int[6][6];
        for (int i = 0; i < minesAmount; i++) {
            randomBombs();
        }
    }
    public int randomBombs() {
        bombPosition1 = (int)(Math.random()*101);
        board[(int)(Math.random()*7)][(int)(Math.random()*7)] = bombPosition1;
        return bombPosition1;
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
    }  */
}

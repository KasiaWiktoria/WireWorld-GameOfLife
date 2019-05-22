package models;

import view.Board;

public abstract class Game {

    public Board gameBoard;
    Cell[] cells;
    Cell.State[] cellState = new Cell.State[gameBoard.getColumns()*gameBoard.getRows()];

    public Game(Board gameBoard, Cell[] cells) {
        this.gameBoard = gameBoard;
        this.cells = cells;
    }

    public void initCells(Board board, Cell.State[] state){
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), state[i*r+j]);
            }
        }
    }


}

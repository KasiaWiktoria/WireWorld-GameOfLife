package models;

import view.Board;

import static models.Cell.State.DEAD;

public class GameOfLife extends Game {

    public GameOfLife(Board gameBoard, Cell[] cells) {
        super(gameBoard, cells);
    }

    public void initCells(Board board){
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), DEAD);
            }
        }
    }
}

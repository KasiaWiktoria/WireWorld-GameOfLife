package models;

import view.Board;
import static models.Cell.State.*;

public class WireWorld extends  Game {

    public WireWorld(Board gameBoard) {
        super(gameBoard);
        int c = gameBoard.getColumns();
        int r = gameBoard.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*gameBoard.getCellSize(), i*gameBoard.getCellSize(), gameBoard.getCellSize(), EMPTY);
            }
        }
    }

   /* public void initCells(Board board, Cell.State[] states){
        states = new Cell.State[gameBoard.getColumns()*gameBoard.getRows()];
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), states[i*r+j]);
            }
        }
    }*/

    @Override
    public void readStates(int[] intStates){
        this.cellsStates = new Cell.State[this.gameBoard.getColumns()*this.gameBoard.getRows()];
        for(int i = 0; i < this.gameBoard.getColumns()*this.gameBoard.getRows(); i++){
            if(intStates[i] == 0)
                this.cellsStates[i] = EMPTY;
            else if(intStates[i] == 1)
                this.cellsStates[i] = HEAD;
            else if(intStates[i] == 2)
                this.cellsStates[i] = TAIL;
             else if(intStates[i] == 3)
                this.cellsStates[i] = CONDUCTOR;
        }
    }

}

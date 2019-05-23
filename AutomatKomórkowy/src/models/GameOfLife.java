package models;

import javafx.scene.canvas.Canvas;
import view.Board;

import java.util.Random;

import static models.Cell.State.*;

public class GameOfLife extends Game {

    protected golCell[] cells;

    public GameOfLife(Board board) {

        super(board);
        this.cells = new golCell[board.getColumns()*board.getRows()];
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), DEAD);
            }
        }
    }

    public void setCells(Board board, Cell.State[] states){
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), states[i*r+j]);
            }
        }
    }

    @Override
    public void readStates(int[] intStates){
        this.cellsStates = new Cell.State[this.gameBoard.getColumns()*this.gameBoard.getRows()];
        for(int i = 0; i < this.gameBoard.getColumns()*this.gameBoard.getRows(); i++){
            if(intStates[i] == 0)
                this.cellsStates[i] = DEAD;
            else if(intStates[i] == 1)
                this.cellsStates[i] = ALIVE;
        }
    }

    public void countAliveNextCells(){

        int c = this.gameBoard.getColumns();

        for(int i=0; i < this.numberOfCells; i++){
            int[] numbersNextCells = new int[]{i - c - 1, i - c, i - c + 1, i - 1, i + 1, i + c - 1, i + c, i + c + 1};
            for(int j=0; j<8; j++) {
                if(numbersNextCells[j] > 0 && numbersNextCells[j] < this.numberOfCells )
                    if (this.cells[numbersNextCells[j]].getState() == ALIVE)
                        this.cells[i].aliveNextCells++;
            }
        }
    }

    @Override
    public void play(){
        this.countAliveNextCells();

        for(int i=0; i <this.numberOfCells; i++){
            if(this.cells[i].getState() == DEAD){
                if(this.cells[i].aliveNextCells == 3)
                    this.cells[i].setState(ALIVE);
            }
            else if(this.cells[i].getState() == ALIVE){
                if(this.cells[i].aliveNextCells != 2 && this.cells[i].aliveNextCells != 3)
                    this.cells[i].setState(DEAD);
            }
        }
        this.gameBoard.draw(this.getCellsStates());
    }
}

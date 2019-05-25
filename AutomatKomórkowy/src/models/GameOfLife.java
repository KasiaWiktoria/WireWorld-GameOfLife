package models;

import javafx.scene.canvas.Canvas;
import view.Board;

import java.util.Random;

import static models.Cell.State.*;

public class GameOfLife extends Game {

    protected golCell[] cells;

    public GameOfLife(Board board) {

        super(board);
        this.cells = new golCell[numberOfCells];
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*c+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), DEAD);
            }
        }

    }
    @Override
    public void setCells(Cell.State[] states){
        int c = this.gameBoard.getColumns();
        int r = this.gameBoard.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*c+j] = new golCell(j*this.gameBoard.getCellSize(), i*this.gameBoard.getCellSize(), this.gameBoard.getCellSize(), states[i*c+j]);
            }
        }
    }

    @Override
    public void readStates(int[] intStates){
        this.cells = new golCell[this.numberOfCells];
        this.cellsStates = new Cell.State[this.numberOfCells];
        for(int i = 0; i < this.numberOfCells; i++){
            if(intStates[i] == 0) {
                this.cellsStates[i] = DEAD;
            }
            else if(intStates[i] == 1) {
                this.cellsStates[i] = ALIVE;
            }
        }
        this.setCells(this.cellsStates);
    }

    @Override
    public void readStatesFromCells(){

        this.cellsStates = new Cell.State[this.numberOfCells];
        for(int i = 0; i < this.numberOfCells; i++){
            if(this.cells[i].getState() == DEAD) {
                this.cellsStates[i] = DEAD;
            }
            else if(this.cells[i].getState() == ALIVE) {
                this.cellsStates[i] = ALIVE;
            }
        }
    }

    public void countAliveNextCells(){

        int c = this.gameBoard.getColumns();

        for(int i=0; i < this.numberOfCells; i++){
            this.cells[i].aliveNextCells = 0;
            int[] numbersNextCells = new int[]{i-c-1, i-c, i-c+1, i- 1, i+1, i+c-1, i+c, i+c+1};
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

                if(this.cells[i].aliveNextCells == 3) {
                    this.cells[i].setState(ALIVE);
                    this.cellsStates[i] = ALIVE;
                }
            }
            else if(this.cells[i].getState() == ALIVE){
                if(this.cells[i].aliveNextCells != 2 && this.cells[i].aliveNextCells != 3) {
                    this.cells[i].setState(DEAD);
                    this.cellsStates[i] = DEAD;
                }
            }
        }
        this.readStatesFromCells();
        this.gameBoard.draw(this.getCellsStates());
    }
}
//dodać do funkcji randomFill zczytywanie stanów z komórek do tablicy stanów

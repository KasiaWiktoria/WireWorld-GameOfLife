package models;

import view.Board;

import static models.Cell.State.*;

public class GameOfLife extends Game {

    protected golCells cells;

    public GameOfLife(golCells cells) {
        super(cells);
        this.cells = cells;
        this.cells.cellsBoard = new golCell[cells.numberOfCells];
        int c = cells.columns;
        int r = cells.rows;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells.cellsBoard[i*c+j] = new golCell(j*cells.cellSize, i*cells.cellSize, cells.cellSize, DEAD);
            }
        }

    }
    @Override
    public void setCellsBoard(Cell.State[] states){
        int c = this.cells.columns;
        int r = this.cells.rows;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells.cellsBoard[i*c+j] = new golCell(j*this.cells.cellSize, i*cells.cellSize, this.cells.cellSize, states[i*c+j]);
            }
        }
    }

    @Override
    public void readStates(int[] intStates){
        this.cells.cellsBoard = new golCell[this.cells.numberOfCells];
        this.cells.cellsStates = new Cell.State[this.cells.numberOfCells];
        for(int i = 0; i < this.cells.numberOfCells; i++){
            if(intStates[i] == 0) {
                this.cells.cellsStates[i] = DEAD;
            }
            else if(intStates[i] == 1) {
                this.cells.cellsStates[i] = ALIVE;
            }
        }
        this.setCellsBoard(this.cells.cellsStates);
    }

    @Override
    public void readStatesFromCells(){

        this.cells.cellsStates = new Cell.State[this.cells.numberOfCells];
        for(int i = 0; i < this.cells.numberOfCells; i++){
            if(this.cells.cellsBoard[i].getState() == DEAD) {
                this.cells.cellsStates[i] = DEAD;
            }
            else if(this.cells.cellsBoard[i].getState() == ALIVE) {
                this.cells.cellsStates[i] = ALIVE;
            }
        }
    }

    public void countAliveNextCells(){

        int c = this.cells.columns;

        for(int i=0; i < this.cells.numberOfCells; i++){
            this.cells.cellsBoard[i].aliveNextCells = 0;
            int[] numbersNextCells = new int[]{i-c-1, i-c, i-c+1, i- 1, i+1, i+c-1, i+c, i+c+1};
            for(int j=0; j<8; j++) {
                if(numbersNextCells[j] > 0 && numbersNextCells[j] < this.cells.numberOfCells )
                    if (this.cells.cellsBoard[numbersNextCells[j]].getState() == ALIVE)
                        this.cells.cellsBoard[i].aliveNextCells++;
            }
        }
    }

    @Override
    public void play(){
        this.countAliveNextCells();

        for(int i=0; i <this.cells.numberOfCells; i++){
            if(this.cells.cellsBoard[i].getState() == DEAD){

                if(this.cells.cellsBoard[i].aliveNextCells == 3) {
                    this.cells.cellsBoard[i].setState(ALIVE);
                    this.cells.cellsStates[i] = ALIVE;
                }
            }
            else if(this.cells.cellsBoard[i].getState() == ALIVE){
                if(this.cells.cellsBoard[i].aliveNextCells != 2 && this.cells.cellsBoard[i].aliveNextCells != 3) {
                    this.cells.cellsBoard[i].setState(DEAD);
                    this.cells.cellsStates[i] = DEAD;
                }
            }
        }
        this.readStatesFromCells();
        this.notifyObservators();
    }
}

package models;

import static models.Cell.State.*;

public class WireWorld extends  Game {

    protected wwCells cells;

    public WireWorld(wwCells cells) {
        super(cells);
        this.cells = cells;
        System.out.println(this.cells.cellsBoard.length);
        this.cells.cellsBoard = new wwCell[this.cells.numberOfCells];
        int c = cells.columns;
        int r = cells.rows;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells.cellsBoard[i*c+j] = new wwCell(j*this.cells.cellSize, i*this.cells.cellSize, this.cells.cellSize, EMPTY);
            }
        }
    }


    public void setCellsBoard(Cell.State[] states){
        int c = cells.columns;
        int r = cells.rows;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells.cellsBoard[i*c+j] = new wwCell(j*cells.cellSize, i*cells.cellSize, cells.cellSize, states[i*c+j]);
            }
        }
    }

    public void checkHeadNext(){

        int c = cells.columns;

        for(int i=0; i < this.cells.numberOfCells; i++){
            this.cells.cellsBoard[i].headsNext = 0;
            int[] numbersNextCells = new int[]{i-c-1, i-c, i-c+1, i- 1, i+1, i+c-1, i+c, i+c+1};
            for(int j=0; j<8; j++) {
                if(numbersNextCells[j] > 0 && numbersNextCells[j] < this.cells.numberOfCells )
                    if (this.cells.cellsBoard[numbersNextCells[j]].getState() == HEAD)
                        this.cells.cellsBoard[i].headsNext++;
            }
        }
    }

    @Override
    public void play() {
        this.checkHeadNext();

        for(int i=0; i <this.cells.numberOfCells; i++){
            if(this.cells.cellsBoard[i].getState() == HEAD){
                this.cells.cellsBoard[i].setState(TAIL);
                this.cells.cellsStates[i] = TAIL;
            }
            else if(this.cells.cellsBoard[i].getState() == TAIL){
                this.cells.cellsBoard[i].setState(CONDUCTOR);
                this.cells.cellsStates[i] = CONDUCTOR;
            }
            else if(this.cells.cellsBoard[i].getState() == CONDUCTOR){
                if(this.cells.cellsBoard[i].headsNext == 1 || this.cells.cellsBoard[i].headsNext == 2) {
                    this.cells.cellsBoard[i].setState(HEAD);
                    this.cells.cellsStates[i] = HEAD;
                }
            }
        }
        this.readStatesFromCells();
        this.notifyObservators();
    }

    @Override
    public void readStatesFromCells(){

        this.cells.cellsStates = new Cell.State[this.cells.numberOfCells];
        for(int i = 0; i < this.cells.numberOfCells; i++){
            if(this.cells.cellsBoard[i].getState() == HEAD)
                this.cells.cellsStates[i] = HEAD;
            else if(this.cells.cellsBoard[i].getState() == TAIL)
                this.cells.cellsStates[i] = TAIL;
            else if(this.cells.cellsBoard[i].getState() == CONDUCTOR)
                    this.cells.cellsStates[i] = CONDUCTOR;
            else if(this.cells.cellsBoard[i].getState() == EMPTY)
                        this.cells.cellsStates[i] = EMPTY;
        }
    }

    @Override
    public void readStates(int[] intStates){
        this.cells.cellsBoard = new wwCell[this.cells.numberOfCells];
        this.cells.cellsStates = new Cell.State[this.cells.numberOfCells];

        for(int i = 0; i < this.cells.numberOfCells; i++){
            if(intStates[i] == 0)
                this.cells.cellsStates[i] = EMPTY;
            else if(intStates[i] == 1)
                this.cells.cellsStates[i] = HEAD;
            else if(intStates[i] == 2)
                this.cells.cellsStates[i] = TAIL;
             else if(intStates[i] == 3)
                this.cells.cellsStates[i] = CONDUCTOR;
        }
        this.setCellsBoard(this.cells.cellsStates);
    }
}
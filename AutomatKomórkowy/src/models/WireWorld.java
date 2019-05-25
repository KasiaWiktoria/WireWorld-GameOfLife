package models;

import view.Board;
import static models.Cell.State.*;

public class WireWorld extends  Game {

    protected wwCell[] cells;

    public WireWorld(Board board) {
        super(board);
        this.cells = new wwCell[board.getColumns()*board.getRows()];
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*c+j] = new wwCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), EMPTY);
            }
        }
    }

    public void setCells(Cell.State[] states){
        int c = this.gameBoard.getColumns();
        int r = this.gameBoard.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*c+j] = new wwCell(j*this.gameBoard.getCellSize(), i*this.gameBoard.getCellSize(), this.gameBoard.getCellSize(), states[i*c+j]);
            }
        }
    }

    public void checkHeadNext(){

        int c = this.gameBoard.getColumns();

        for(int i=0; i < this.numberOfCells; i++){
            this.cells[i].headsNext = 0;
            int[] numbersNextCells = new int[]{i-c-1, i-c, i-c+1, i- 1, i+1, i+c-1, i+c, i+c+1};
            for(int j=0; j<8; j++) {
                if(numbersNextCells[j] > 0 && numbersNextCells[j] < this.numberOfCells )
                    if (this.cells[numbersNextCells[j]].getState() == HEAD)
                        this.cells[i].headsNext++;
            }
        }
    }

    @Override
    public void play() {
        this.checkHeadNext();

        for(int i=0; i <this.numberOfCells; i++){
            if(this.cells[i].getState() == HEAD){
                this.cells[i].setState(TAIL);
                this.cellsStates[i] = TAIL;
            }
            else if(this.cells[i].getState() == TAIL){
                this.cells[i].setState(CONDUCTOR);
                this.cellsStates[i] = CONDUCTOR;
            }
            else if(this.cells[i].getState() == CONDUCTOR){
                if(this.cells[i].headsNext == 1 || this.cells[i].headsNext == 2) {
                    this.cells[i].setState(HEAD);
                    this.cellsStates[i] = HEAD;
                }
            }
        }
        this.readStatesFromCells();
        this.gameBoard.draw(this.getCellsStates());
    }

    @Override
    public void readStatesFromCells(){

        this.cellsStates = new Cell.State[this.numberOfCells];
        for(int i = 0; i < this.numberOfCells; i++){
            if(this.cells[i].getState() == HEAD)
                this.cellsStates[i] = HEAD;
            else if(this.cells[i].getState() == TAIL)
                this.cellsStates[i] = TAIL;
            else if(this.cells[i].getState() == CONDUCTOR)
                    this.cellsStates[i] = CONDUCTOR;
            else if(this.cells[i].getState() == EMPTY)
                        this.cellsStates[i] = EMPTY;
        }
    }

    @Override
    public void readStates(int[] intStates){
        this.cells = new wwCell[this.numberOfCells];
        this.cellsStates = new Cell.State[this.numberOfCells];
        for(int i = 0; i < this.numberOfCells; i++){
            if(intStates[i] == 0)
                this.cellsStates[i] = EMPTY;
            else if(intStates[i] == 1)
                this.cellsStates[i] = HEAD;
            else if(intStates[i] == 2)
                this.cellsStates[i] = TAIL;
             else if(intStates[i] == 3)
                this.cellsStates[i] = CONDUCTOR;
        }
        this.setCells(this.cellsStates);
    }
}
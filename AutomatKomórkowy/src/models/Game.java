package models;

import view.Board;

public abstract class Game {

    public Board gameBoard;
    //public Cell[] cells;
    protected Cell.State[] cellsStates;// = new Cell.State[gameBoard.getColumns()*gameBoard.getRows()];
    protected int numberOfCells;

    public Game(Board board) {
        this.gameBoard = board;
        //this.cells = new Cell[board.getColumns()*board.getRows()];
        this.cellsStates = new Cell.State[board.getColumns()*board.getRows()];
        this.numberOfCells = board.getColumns()*board.getRows();
    }

    public abstract void play();
/*
    public void setCells(Cell.State[] states){
        int c = this.gameBoard.getColumns();
        int r = this.gameBoard.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*this.gameBoard.getCellSize(), i*this.gameBoard.getCellSize(), this.gameBoard.getCellSize(), states[i*r+j]);
            }
        }
    }

    public void setCells(Board board, Cell.State[] states){
        states = new Cell.State[board.getColumns()*board.getRows()];
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), states[i*r+j]);
            }
        }
    }
    */

    //abstract methods
    public abstract void readStates(int[] intStates);
    public abstract void readStatesFromCells(Cell[] cellsStates);

    //public Cell[] getCells() { return cells; }
    //public void setCells(Cell[] cells) { this.cells = cells; }
    public Cell.State[] getCellsStates() { return cellsStates; }
    public void setCellsStates(Cell.State[] cellState) { this.cellsStates = cellState; }
}

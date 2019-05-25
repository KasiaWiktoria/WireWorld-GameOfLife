package models;

import view.Board;

public abstract class Game {

    public Board gameBoard;
    protected Cell.State[] cellsStates;
    protected int numberOfCells;

    public Game(Board board) {
        this.gameBoard = board;
        this.cellsStates = new Cell.State[board.getColumns()*board.getRows()];
        this.numberOfCells = board.getColumns()*board.getRows();
    }

    //abstract methods
    public abstract void play();
    public abstract void readStates(int[] intStates);
    public abstract void readStatesFromCells();
    public abstract void setCells(Cell.State[] states);

    //getters and setters methods
    public Cell.State[] getCellsStates() { return cellsStates; }
    public void setCellsStates(Cell.State[] cellState) { this.cellsStates = cellState; }
    public int getNumberOfCells() { return numberOfCells; }
    public void setNumberOfCells(int numberOfCells) { this.numberOfCells = numberOfCells; }
}

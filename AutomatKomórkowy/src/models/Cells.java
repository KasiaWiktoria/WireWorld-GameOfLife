package models;

public abstract class Cells {
    protected int rows, columns;
    protected double cellSize;
    protected Cell.State[] cellsStates;
    protected int numberOfCells;
    protected Cell[] cellsBoard;

    public Cells(int columns, int rows) {
        this.rows = rows;
        this.columns = columns;
        if (800 / this.columns < 600 / this.rows)
            this.cellSize = 800. / (double) this.columns;
        else
            this.cellSize = 600. / (double) this.rows;
        this.numberOfCells = columns * rows;
        this.cellsStates = new Cell.State[numberOfCells];
        this.cellsBoard = new Cell[numberOfCells];
    }


    //Getter and Setter methods
    public int getRows() { return rows; }
    public void setRows(int rows) { this.rows = rows; }
    public int getColumns() { return columns; }
    public void setColumns(int columns) { this.columns = columns; }
    public double getCellSize() { return cellSize; }
    public void setCellSize(double cellSize) { this.cellSize = cellSize; }
    public Cell.State[] getCellsStates() { return cellsStates; }
    public void setCellsStates(Cell.State[] cellsStates) { this.cellsStates = cellsStates; }
    public int getNumberOfCells() { return numberOfCells; }
    public void setNumberOfCells(int numberOfCells) { this.numberOfCells = numberOfCells; }
    public Cell[] getCellsBoard() { return cellsBoard; }
    public Cell getCellsBoard(int i) { return cellsBoard[i]; }
    public void setCellsBoard(Cell[] cellsBoard) { this.cellsBoard = cellsBoard; }
    public Cell checkIndex(int a,int b) {  return cellsBoard[(a+1)*(b+1)]; }
}

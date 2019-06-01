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

    public int checkIndex(int x, int y){
        System.out.println("Współrzędne testowanego punktu: x: " + x + " y: " + y);
        //System.out.println("Współrzędne punktu 0, 0 : x: " + cellsBoard[0].getX() + " y: " + cellsBoard[0].getY());
        for(int i = 0; i<this.getNumberOfCells(); i++){
            if(cellsBoard[i].getX()/cellsBoard[i].getSize() == x && cellsBoard[i].getY()/cellsBoard[i].getSize() == y)
                System.out.println("Znaleziono punkt; index = " + i);
                return i;
        }
        System.out.println("Brak punktu o danych współrzędnych");
        return -1;
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
}

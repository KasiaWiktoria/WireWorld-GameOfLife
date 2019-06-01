package models;

public class golCells extends  Cells {

    protected golCell[] cellsBoard;

    public golCells(int columns, int rows) {
        super(columns,rows);
        this.cellsBoard = new golCell[this.numberOfCells];
    }
}

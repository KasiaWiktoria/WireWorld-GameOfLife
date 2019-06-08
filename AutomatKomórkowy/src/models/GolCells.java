package models;

public class GolCells extends  Cells {

    protected GolCell[] cellsBoard;

    public GolCells(int columns, int rows) {
        super(columns,rows);
        this.cellsBoard = new GolCell[this.numberOfCells];
    }
}

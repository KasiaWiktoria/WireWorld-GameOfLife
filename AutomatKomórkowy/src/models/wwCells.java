package models;

public class wwCells extends Cells {

    protected wwCell[] cellsBoard;

    public wwCells(int columns, int rows) {
        super(columns,rows);
        this.cellsBoard = new wwCell[this.numberOfCells];
    }


}

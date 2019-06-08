package models;

public class WwCells extends Cells {

    protected WwCell[] cellsBoard;

    public WwCells(int columns, int rows) {
        super(columns,rows);
        this.cellsBoard = new WwCell[this.numberOfCells];
    }


}

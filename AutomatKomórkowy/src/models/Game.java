package models;

import static models.Cell.State.DEAD;

public abstract class Game extends Observable {

    protected Cells cells;
    public void initCellsBoard(){
        int c = this.cells.columns;
        int r = this.cells.rows;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells.cellsBoard[i*c+j] = new Cell(j*this.cells.cellSize, i*cells.cellSize, this.cells.cellSize, DEAD);
            }
        }
    }

    public Game(Cells cells) {
        this.cells = cells;
    }

    //abstract methods
    public abstract void play();
    public abstract void readStates(int[] intStates);
    public abstract void readStatesFromCells();
    public abstract void setCellsBoard(Cell.State[] states);

    //getters and setters methods
    public Cells getCells() { return cells; }
    public void setCells(Cells cells) { this.cells = cells; }
}

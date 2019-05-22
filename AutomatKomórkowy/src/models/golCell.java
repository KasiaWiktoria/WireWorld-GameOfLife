package models;


import static models.Cell.State.ALIVE;
import static models.Cell.State.DEAD;

public class golCell extends Cell {

    private int aliveNextCells;

    public golCell(double x, double y, double size, Cell.State state) {
        super(x, y, size, state);
    }

    public void countAliveNextCells(){

    }

    public void checkState(){
        if(this.getState() == DEAD){
            if(aliveNextCells == 3)
                this.setState(ALIVE);
        }
        else if(this.getState() == ALIVE){
            if(aliveNextCells != 2 && aliveNextCells != 3)
                this.setState(DEAD);
        }
    }
}

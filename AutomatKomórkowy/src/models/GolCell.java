package models;


import static models.Cell.State.ALIVE;
import static models.Cell.State.DEAD;

public class GolCell extends Cell {

    protected int aliveNextCells;

    public GolCell(double x, double y, double size, Cell.State state) {

        super(x, y, size, state);
        this.aliveNextCells =0;
    }

    public State checkState(){
        if(this.getState() == DEAD){
            if(this.aliveNextCells == 3)
                this.setState(ALIVE);
        }
        else if(this.getState() == ALIVE){
            if(this.aliveNextCells != 2 && this.aliveNextCells != 3)
                this.setState(DEAD);
        }
        return this.getState();
    }
}

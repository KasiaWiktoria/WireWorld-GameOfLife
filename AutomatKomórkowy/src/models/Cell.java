package models;

public class Cell {

    private double x;
    private double y;
    private double size;
    private int state;
    private int aliveNextCells;



    public Cell(double x, double y, double size, int state) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = state;
    }

    public void checkState(){
        if(this.state == 0){
            if(aliveNextCells == 3)
                this.state = 1;
        }
        else if(this.state == 1){
            if(aliveNextCells != 2 && aliveNextCells != 3)
                this.state = 0;
        }
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }
}

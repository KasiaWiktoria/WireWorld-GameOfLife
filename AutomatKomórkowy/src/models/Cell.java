package models;

public class Cell {

    public enum State {
        EMPTY,
        HEAD,
        TAIL,
        CONDUCTOR,

        ALIVE,
        DEAD
    }
    private double x;
    private double y;
    private double size;
    private State state;

    public Cell(double x, double y, double size, State state) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.state = state;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getSize() { return size; }
    public void setSize(double size) { this.size = size; }
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

}

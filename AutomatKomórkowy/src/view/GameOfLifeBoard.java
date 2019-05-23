package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.Cell;
import models.Game;
import view.Board;

import java.util.Random;

import static models.Cell.State.ALIVE;
import static models.Cell.State.DEAD;

public class GameOfLifeBoard extends Board {

    public GameOfLifeBoard(int columns, int rows, Canvas canvas) { super(columns, rows, canvas); }

    @Override
    public void draw(Cell.State[] cellState){
        try{
            GraphicsContext canvasGC = this.getCanvas().getGraphicsContext2D();
            canvasGC.setFill(Color.BLACK);
            int r = this.getRows();
            int c = this.getColumns();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (cellState[i*r+j] == ALIVE)
                        canvasGC.setFill(Color.WHITE);
                    else if (cellState[i*r+j] == DEAD)
                        canvasGC.setFill(Color.BLACK);
                    canvasGC.fillRect(j * this.getCellSize(), this.getCellSize() * i, this.getCellSize(), this.getCellSize());
                }
            }
        }catch(NullPointerException e){
            System.out.println("Canvas jest pusty");
        }
    }

    @Override
    public void randomFill(Game game) {
        int numberOfCells = this.getColumns()*this.getRows();
        int [] randomIntStates = new int[numberOfCells];
        Random generator = new Random();
        for(int k = 0; k < numberOfCells; k++){
            randomIntStates[k] = Math.abs(generator.nextInt()%2);
        }
        game.readStates(randomIntStates);
        this.draw(game.getCellsStates());
    }

/*
    public void randomFill2(Canvas canvas) {
        Random generator = new Random();
        GraphicsContext canvasGC = canvas.getGraphicsContext2D();
        canvasGC.setFill(Color.BLACK);
        try {
	        for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    if (generator.nextBoolean() == true)
                        canvasGC.setFill(Color.WHITE);
                    else
                        canvasGC.setFill(Color.BLACK);
                    canvasGC.fillRect(j * this.getCellSize(), this.getCellSize() * i, this.getCellSize(), this.getCellSize());
                }
	        }
        }catch(Exception e) {
        }
    }
*/


}

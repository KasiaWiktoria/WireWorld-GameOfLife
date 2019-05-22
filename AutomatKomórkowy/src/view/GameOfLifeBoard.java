package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.Board;

import java.util.Random;

public class GameOfLifeBoard extends Board {


    public GameOfLifeBoard(int columns, int rows, Canvas canvas) {
        super(columns, rows, canvas);
    }

    public enum GameOfLifeStates {
        DEAD,
        ALiVE
    }

    @Override
    public void randomFill(Canvas canvas) {
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
}

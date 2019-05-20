package models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameOfLife extends Board {

    Board gameBoard;

    public GameOfLife(int columns, int rows, Canvas canvas) {
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
        for (int i = 0; i < this.gameBoard.getRows(); i++) {
            for (int j = 0; j < this.gameBoard.getColumns(); j++) {
                if (generator.nextBoolean() == true)
                    canvasGC.setFill(Color.WHITE);
                else
                    canvasGC.setFill(Color.BLACK);
                canvasGC.fillRect(j * this.gameBoard.getCellSize(), this.gameBoard.getCellSize() * i, this.gameBoard.getCellSize(), this.gameBoard.getCellSize());
            }
        }
    }

}

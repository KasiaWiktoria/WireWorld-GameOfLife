package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.Cell;
import models.Game;

import java.util.Random;

import static models.Cell.State.*;

public class WireWorldBoard extends Board {

    private Board gameBoard;

    public WireWorldBoard(int columns, int rows, Canvas canvas) {
        super(columns, rows, canvas);
    }

    public void drawSingeCell(Canvas canvas, int x, int y, Cell.State state) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Color color;
        switch (state) {
            default:
            case EMPTY:
                color = Color.BLACK;
                break;
            case CONDUCTOR:
                color = Color.YELLOW;
                break;
            case HEAD:
                color = Color.BLUE;
                break;
            case TAIL:
                color = Color.RED;
                break;
        }

        graphicsContext.setFill(color);
        graphicsContext.fillRect(x*gameBoard.getCellSize(), y*getCellSize(), getCellSize(), getCellSize());
    }

    @Override
    public void draw(Cell.State[] cellState, Canvas canvas){
        GraphicsContext canvasGC = canvas.getGraphicsContext2D();
        canvasGC.setFill(Color.BLACK);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (cellState[i] == TAIL)
                    canvasGC.setFill(Color.RED);
                else if (cellState[i] == HEAD)
                    canvasGC.setFill(Color.BLUE);
                else if (cellState[i] == CONDUCTOR)
                    canvasGC.setFill(Color.YELLOW);
                else if (cellState[i] == EMPTY)
                    canvasGC.setFill(Color.BLACK);
                canvasGC.fillRect(j * this.getCellSize(), this.getCellSize() * i, this.getCellSize(), this.getCellSize());
            }
        }
    }

    @Override
    public void randomFill(Game game) {
        GraphicsContext wwCanvasGC = game.gameBoard.getCanvas().getGraphicsContext2D();
        Random wwGenerator = new Random();
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                if (wwGenerator.nextInt() % 4 == 0)
                    wwCanvasGC.setFill(Color.RED);
                else if (wwGenerator.nextInt() % 4 == 1)
                    wwCanvasGC.setFill(Color.YELLOW);
                else if (wwGenerator.nextInt() % 4 == 2)
                    wwCanvasGC.setFill(Color.BLUE);
                else
                    wwCanvasGC.setFill(Color.BLACK);
                wwCanvasGC.fillRect(j * this.getCellSize(), this.getCellSize() * i, this.getCellSize(), this.getCellSize());
            }
        }
    }
}

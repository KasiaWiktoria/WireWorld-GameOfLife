package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.Cell;
import java.util.Random;

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
    public void randomFill(Canvas wwCanvas) {
        GraphicsContext wwCanvasGC = wwCanvas.getGraphicsContext2D();
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

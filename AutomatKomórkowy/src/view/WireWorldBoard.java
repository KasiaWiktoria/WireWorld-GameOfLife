package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.Cell;
import models.Game;

import java.util.Random;

import static models.Cell.State.*;

public class WireWorldBoard extends Board {

    public WireWorldBoard(Game game, Canvas canvas) {
        super(game, canvas);
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
        graphicsContext.fillRect(x*game.getCells().getCellSize(), y*game.getCells().getCellSize(), game.getCells().getCellSize(), game.getCells().getCellSize());
    }

    @Override
    public void draw(Cell.State[] cellState){
        GraphicsContext canvasGC = this.getCanvas().getGraphicsContext2D();
        canvasGC.setFill(Color.BLACK);
        int r = game.getCells().getRows();
        int c = game.getCells().getColumns();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (cellState[i*c+j] == TAIL)
                    canvasGC.setFill(Color.RED);
                else if (cellState[i*c+j] == HEAD)
                    canvasGC.setFill(Color.BLUE);
                else if (cellState[i*c+j] == CONDUCTOR)
                    canvasGC.setFill(Color.YELLOW);
                else if (cellState[i*c+j] == EMPTY)
                    canvasGC.setFill(Color.BLACK);
                canvasGC.fillRect(j * game.getCells().getCellSize(), game.getCells().getCellSize() * i, game.getCells().getCellSize(), game.getCells().getCellSize());
            }
        }
    }
    @Override
    public void randomFill(Game game) {
        int [] randomIntStates = new int[game.getCells().getNumberOfCells()];
        Random generator = new Random();
        for(int k = 0; k < game.getCells().getNumberOfCells(); k++){
            randomIntStates[k] = Math.abs(generator.nextInt()%4);
        }
        game.readStates(randomIntStates);
        game.readStatesFromCells();
        this.draw(game.getCells().getCellsStates());
    }

    @Override
    public Cell.State pickState(){

        Cell.State cellState = EMPTY;

        if(selectedColor == Color.RED)
            cellState = TAIL;
        else if(selectedColor == Color.BLUE)
            cellState = HEAD;
        else if(selectedColor == Color.YELLOW)
            cellState = CONDUCTOR;
        else if(selectedColor == Color.BLACK)
            cellState = EMPTY;

        return cellState;
    }
}

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

    public GameOfLifeBoard(Game game, Canvas canvas) { super(game, canvas); }

    @Override
    public void draw(Cell.State[] cellState){
        try{
            GraphicsContext canvasGC = this.getCanvas().getGraphicsContext2D();
            canvasGC.setFill(Color.BLACK);
            int r = game.getCells().getRows();
            int c = game.getCells().getColumns();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (cellState[i*c+j] == ALIVE)
                        canvasGC.setFill(Color.WHITE);
                    else if (cellState[i*c+j] == DEAD)
                        canvasGC.setFill(Color.BLACK);
                    canvasGC.fillRect(j * game.getCells().getCellSize(), game.getCells().getCellSize() * i, game.getCells().getCellSize(), game.getCells().getCellSize());
                }
            }
        }catch(NullPointerException e){
            System.out.println("Canvas jest pusty");
        }
    }

    @Override
    public void randomFill(Game game) {
        int [] randomIntStates = new int[game.getCells().getNumberOfCells()];
        Random generator = new Random();
        for(int k = 0; k < game.getCells().getNumberOfCells(); k++){
            randomIntStates[k] = Math.abs(generator.nextInt()%2);
        }
        game.readStates(randomIntStates);
        game.readStatesFromCells();
        this.draw(game.getCells().getCellsStates());
    }

    @Override
    public Cell.State pickState(){
        Cell.State cellState = ALIVE;

        if (selectedColor == Color.WHITE) {
        	System.out.println("a");
            cellState = ALIVE;
            }
        else if (selectedColor == Color.BLACK) {
        	 System.out.println("b");
            cellState = DEAD;
          
        }
        return cellState;
    }


}

package models;

import javafx.scene.canvas.Canvas;
import view.Board;

import java.util.Random;

import static models.Cell.State.*;

public class GameOfLife extends Game {

    public GameOfLife(Board gameBoard) {

        super(gameBoard);
        int c = gameBoard.getColumns();
        int r = gameBoard.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*gameBoard.getCellSize(), i*gameBoard.getCellSize(), gameBoard.getCellSize(), DEAD);
            }
        }
    }

    public void setCells(Board board, Cell.State[] states){
        int c = board.getColumns();
        int r = board.getRows();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                this.cells[i*r+j] = new golCell(j*board.getCellSize(), i*board.getCellSize(), board.getCellSize(), states[i*r+j]);
            }
        }
    }

    @Override
    public void readStates(int[] intStates){

        for(int i = 0; i < this.gameBoard.getColumns()*this.gameBoard.getRows(); i++){
            if(intStates[i] == 0)
                this.cellsStates[i] = DEAD;
            else if(intStates[i] == 1)
                this.cellsStates[i] = ALIVE;
        }
    }

    public int [] randomStates(int numberOfCells){
        int [] randomStates = new int[numberOfCells];
        for(int i = 0; i < numberOfCells; i++){
            Random generator = new Random();
            if (generator.nextBoolean() == true)
                randomStates[i] = 1;
            else
                randomStates[i] = 0;
        }
        return randomStates;
    }
}

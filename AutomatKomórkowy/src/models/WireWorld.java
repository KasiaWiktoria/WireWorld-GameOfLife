package models;

import view.Board;
import static models.Cell.State.*;

public class WireWorld extends  Game {

    public WireWorld(Board gameBoard, Cell[] cells) {
        super(gameBoard, cells);
    }

    public void readStates(int[] intStates, Game game){

        for(int i = 0; i < game.gameBoard.getColumns()*game.gameBoard.getRows(); i++){
            if(intStates[i] == 0)
                cellState[i] = EMPTY;
            else if(intStates[i] == 1)
                cellState[i] = HEAD;
            else if(intStates[i] == 2)
                cellState[i] = TAIL;
             else if(intStates[i] == 3)
                cellState[i] = CONDUCTOR;
        }
    }

}

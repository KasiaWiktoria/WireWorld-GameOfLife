package controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.ColorPicker;
import models.GameOfLife;


public class GameOfLifeController {

    @FXML
    Button start;

    @FXML
    Canvas golCanvas;
    @FXML
    TextField golColumns;
    @FXML
    TextField golRows;
    @FXML
    Button golDimension;
    @FXML
    Button golBoardReset;
    @FXML
    Button golRandomFill;

    GameOfLife golBoard = new GameOfLife(32,24, golCanvas);

    public void initialize() {



    }

}

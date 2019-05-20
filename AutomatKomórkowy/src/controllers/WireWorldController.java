package controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Board;
import models.ColorPicker;

public class WireWorldController extends MainController {





    public void initialize() {

        //Settings for WireWorld
//        wwBoard.colorToolFill(ColorPicker, colorToolSize);
        WireWorldController WireWorldController = new WireWorldController();

        wwBoard.blackFill(wwCanvas);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);
        wwDimension.setOnAction(e -> wwBoard.setDimension(wwColumns, wwRows));
        wwBoardReset.setOnAction(e -> wwBoard.blackFill(wwCanvas));

    }
}

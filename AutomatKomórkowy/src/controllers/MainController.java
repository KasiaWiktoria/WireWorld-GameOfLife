package controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import models.GameOfLife;
import models.WireWorld;
import view.GameOfLifeBoard;
import view.WireWorldBoard;

public class MainController {

    //WireWorldBoard
    @FXML
    Button wwStart;
    @FXML
    Canvas wwCanvas;
    @FXML
    TextField wwColumns;
    @FXML
    TextField wwRows;
    @FXML
    Button wwDimension;
    @FXML
    Button wwBoardReset;
    @FXML
    Rectangle tail;
    @FXML
    Rectangle head;
    @FXML
    Rectangle conductor;
    @FXML
    Rectangle empty;

    WireWorldBoard wwBoard  = new WireWorldBoard(64,48, wwCanvas);
    WireWorld WireWorld = new WireWorld(wwBoard);

    //GameOfLifeBoard
    @FXML
    Button golStart;
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
    @FXML
    Rectangle black;
    @FXML
    Rectangle white;

    GameOfLifeBoard golBoard = new GameOfLifeBoard(32,24, golCanvas);
    GameOfLife GameOfLife = new GameOfLife(golBoard);

    private int clickedX;
    private int clickedY;
    private boolean selectionActive = false;

    public void boardClicked(MouseEvent mouseEvent){

        int newClickedX = (int) (mouseEvent.getX()/ wwBoard.getCellSize());
        int newClickedY = (int) (mouseEvent.getX()/ wwBoard.getCellSize());


        if(selectionActive && newClickedX == clickedX &&  newClickedY == clickedY){
            selectionActive = false;
        }else {
            clickedX = newClickedX;
            clickedY = newClickedY;
            selectionActive = true;
            //podświetlenie
        }
    }

    public void initialize(){

        //___________________________WireWorld_____________________________________
        wwBoard.blackFill(wwCanvas);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);
        wwDimension.setOnAction(e -> wwBoard.setDimension(wwColumns, wwRows, WireWorld));
        wwBoardReset.setOnAction(e -> wwBoard.blackFill(wwCanvas));


        //___________________________GameOfLife_____________________________________

        golBoard.randomFill(GameOfLife);
        golBoard.setPromptForDimensions(golColumns, golRows);
        golDimension.setOnAction(e -> golBoard.setDimension(golColumns, golRows, GameOfLife));
        golBoardReset.setOnAction(e -> golBoard.blackFill(golCanvas));
        golRandomFill.setOnAction(e -> golBoard.randomFill(GameOfLife));

    }
}

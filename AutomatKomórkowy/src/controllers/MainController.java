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
    Button wwRandomFill;
    @FXML
    Rectangle tail;
    @FXML
    Rectangle head;
    @FXML
    Rectangle conductor;
    @FXML
    Rectangle empty;
    @FXML
    Button wwNextGeneration;

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
    @FXML
    Button golNextGeneration;

    public void initialize(){

        //___________________________WireWorld_______________________________________
        WireWorldBoard wwBoard  = new WireWorldBoard(64,48, wwCanvas);
        WireWorld WireWorld = new WireWorld(wwBoard);


        wwBoard.blackFill(wwCanvas);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);
        wwDimension.setOnAction(e -> {
            try{
                wwBoard.setDimension(wwColumns, wwRows, WireWorld);
            }catch(NumberFormatException wrongDim){
                System.out.println("Próbujesz ustawić nieprawidłowe wymiary\n");
            }
        });
        wwBoardReset.setOnAction(e -> wwBoard.blackFill(wwCanvas));
        wwRandomFill.setOnAction(e -> wwBoard.randomFill(WireWorld));


        //___________________________GameOfLife_______________________________________
        GameOfLifeBoard golBoard = new GameOfLifeBoard(32,24, golCanvas);
        GameOfLife GameOfLife = new GameOfLife(golBoard);

        golBoard.randomFill(GameOfLife);
        golBoard.setPromptForDimensions(golColumns, golRows);
        golDimension.setOnAction(e -> {
            try{
                golBoard.setDimension(golColumns, golRows, GameOfLife);
            }catch(NumberFormatException wrongDim){
                System.out.println("Próbujesz ustawić nieprawidłowe wymiary\n");
            }
        });
        golBoardReset.setOnAction(e -> golBoard.blackFill(golCanvas));
        golRandomFill.setOnAction(e -> golBoard.randomFill(GameOfLife));
        golNextGeneration.setOnAction(e -> GameOfLife.play());

    }
}

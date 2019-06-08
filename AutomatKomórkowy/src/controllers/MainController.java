package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import models.*;
import view.GameOfLifeBoard;
import view.WireWorldBoard;
import view.Board;

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
        WwCells wwCells = new WwCells(64,48);
        WireWorld WireWorld = new WireWorld(wwCells);
        WireWorldBoard wwBoard  = new WireWorldBoard(WireWorld, wwCanvas);
        WireWorld.subscribe(wwBoard);

        wwBoard.blackFill(wwCanvas);
        wwBoard.setPromptForDimensions(wwColumns, wwRows);
        wwDimension.setOnAction(e -> {
            try{
                wwBoard.setDimension(wwColumns, wwRows);
            }catch(NumberFormatException wrongDim){
                System.out.println("Próbujesz ustawić nieprawidłowe wymiary\n");
            }
        });
        wwBoardReset.setOnAction(e -> wwBoard.blackFill(wwCanvas));
        wwRandomFill.setOnAction(e -> wwBoard.randomFill(WireWorld));
        wwNextGeneration.setOnAction(e -> WireWorld.play());

      //  wwBoard.getCanvas().setOnMouseClicked(wwBoard::boardClicked);

        
        
        //___________________________GameOfLife_______________________________________
        GolCells golCells = new GolCells(32,24);
        GameOfLife GameOfLife = new GameOfLife(golCells);
        GameOfLifeBoard golBoard = new GameOfLifeBoard(GameOfLife, golCanvas);
        GameOfLife.subscribe(golBoard);

        golBoard.randomFill(GameOfLife);
        golBoard.setPromptForDimensions(golColumns, golRows);
        golDimension.setOnAction(e -> {
            try{
                golBoard.setDimension(golColumns, golRows);
            }catch(NumberFormatException wrongDim){
                System.out.println("Próbujesz ustawić nieprawidłowe wymiary\n");
            }
        });
        golBoardReset.setOnAction(e -> golBoard.blackFill(golCanvas));
        golRandomFill.setOnAction(e -> golBoard.randomFill(GameOfLife));
        golNextGeneration.setOnAction(e -> GameOfLife.play());

        
        
        //color select
        Rectangle[] colorPickers = new Rectangle []{white, black};
        
        for (Rectangle colorRect : colorPickers)
	        colorRect.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            
	        	@Override
	            public void handle(MouseEvent t) {
	        		golBoard.setSelectedColor((Color)colorRect.getFill());
	                wwBoard.setSelectedColor((Color)colorRect.getFill());
	
	                
	                if(golBoard.getSelectedColor() == Color.WHITE) {
	                    System.out.println("Wybrano kolor biały");
	                    golBoard.setSelectedColor(Color.WHITE);}
	                
	                else if(golBoard.getSelectedColor() == Color.BLACK) {
	                    System.out.println("Wybrano kolor czarny");
	                    golBoard.setSelectedColor(Color.BLACK);
	                   }
	        	}
	        }    );
        	
        
        
        Rectangle[] colorPickers2 = new Rectangle []{empty, head, tail, conductor};
       
	        for (Rectangle colorRect : colorPickers2)
	        colorRect.setOnMouseClicked(new EventHandler<MouseEvent>() {
	            
	        	@Override
	            public void handle(MouseEvent t) {
	                wwBoard.setSelectedColor((Color)colorRect.getFill());
	
	                
	                if(wwBoard.getSelectedColor() == Color.BLUE) {
	                    System.out.println("Wybrano kolor niebieski");
	                    wwBoard.setSelectedColor(Color.BLUE);
	                   }
	                else if(wwBoard.getSelectedColor() == Color.RED) {
	                    System.out.println("Wybrano kolor czerwony");
	                    wwBoard.setSelectedColor(Color.RED);
	                   }
	                else if(wwBoard.getSelectedColor() == Color.YELLOW) {
	                    System.out.println("Wybrano kolor zolty");
	                    wwBoard.setSelectedColor(Color.YELLOW);
	                   }
	                else if(wwBoard.getSelectedColor() == Color.BLACK) {
	                    System.out.println("Wybrano kolor czarny");
	                    wwBoard.setSelectedColor(Color.BLACK);
	                   }
	            }
	        });
        
        wwBoard.getCanvas().setOnMouseClicked(wwBoard::boardClicked);
        golBoard.getCanvas().setOnMouseClicked(golBoard::boardClicked);
    }
}

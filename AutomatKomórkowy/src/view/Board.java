package view;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import models.Cell;
import models.Game;
import models.Observator;

import java.awt.*;

import static models.Cell.State.*;

public abstract class Board implements Observator {
	protected Game game;
	protected Canvas canvas;

	public Board(Game game, Canvas canvas) {
		this.game = game;
		this.canvas = canvas;
		if (800 / game.getCells().getColumns() < 600 / game.getCells().getRows())
			game.getCells().setCellSize(800. / (double) game.getCells().getColumns());
		else
			game.getCells().setCellSize(600. / (double) game.getCells().getRows());
		//game.initCellsBoard();
	}

	public void setDimension(TextField columns, TextField rows) {

		try {
			this.game.getCells().setColumns(Integer.parseInt(columns.getText()));
			this.game.getCells().setRows(Integer.parseInt(rows.getText()));
			this.game.getCells().setNumberOfCells(game.getCells().getColumns()*game.getCells().getRows());
		}catch(NumberFormatException e){

		}
		if (800 / Double.parseDouble(columns.getText()) < 600 / Double.parseDouble(rows.getText()))
			this.game.getCells().setCellSize(800. / Double.parseDouble(columns.getText()));
		else
			this.game.getCells().setCellSize(600. / Double.parseDouble(rows.getText()));
		this.cleanCanvas(getCanvas());
		this.randomFill(this.game);
	}

	public void cleanCanvas(Canvas canvas) {
		GraphicsContext canvasGC = canvas.getGraphicsContext2D();
		for (int i = 0; i < this.game.getCells().getRows(); i++) {
			for (int j = 0; j < this.game.getCells().getColumns(); j++) {
				canvasGC.setFill(Color.web("#EEEEEE"));
				canvasGC.fillRect(0, 0, 800, 600);
			}
		}
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
		graphicsContext.fillRect(x * game.getCells().getCellSize(), y * game.getCells().getCellSize(), game.getCells().getCellSize(), game.getCells().getCellSize());
	}

	public void blackFill(Canvas canvas) {
		GraphicsContext canvasGC = canvas.getGraphicsContext2D();
		for (int i = 0; i < this.game.getCells().getRows(); i++) {
			for (int j = 0; j < this.game.getCells().getColumns(); j++) {
				canvasGC.setFill(Color.BLACK);
				canvasGC.fillRect(j * game.getCells().getCellSize(), game.getCells().getCellSize() * i, game.getCells().getCellSize(), game.getCells().getCellSize());
			}
		}
	}

	public void setPromptForDimensions(TextField columns, TextField rows) {
		columns.setPromptText("columns");
		rows.setPromptText("rows");
	}

	public void setCell(Cell.State newState, int clickedX, int clickedY, boolean selectionActive) {
		if (!selectionActive)
			return;
		drawSingeCell(canvas, clickedX, clickedY, newState);
	}

	private int clickedX;
	private int clickedY;
	private boolean selectionActive = false;
	protected Color selectedColor;



	public void boardClicked(MouseEvent mouseEvent){

		int newClickedX = (int) (mouseEvent.getX()/ this.game.getCells().getCellSize());
		int newClickedY = (int) (mouseEvent.getY()/ this.game.getCells().getCellSize());
		GraphicsContext canvasGC = canvas.getGraphicsContext2D();

		if(selectionActive && newClickedX == clickedX &&  newClickedY == clickedY){
			selectionActive = false;
			/*
			System.out.println("Selection active = false");
			Cell.State cellState = game.getCells().getCellsBoard(game.getCells().checkIndex(clickedX, clickedY)).getState();
			if(cellState == DEAD)
				System.out.println("jkhgfdg");
			drawSingeCell(canvas, (int)(clickedX*game.getCells().getCellSize()), (int)(clickedY*game.getCells().getCellSize()), cellState);
			*/
		}else {
			clickedX = newClickedX;
			clickedY = newClickedY;
			selectionActive = true;
			//podświetlenie
			canvasGC.setStroke(Color.GREEN);
			canvasGC.setFill(Color.TRANSPARENT);
			canvasGC.setLineWidth(2);
			//double strokeX = game.getCells().getCellsBoard(game.getCells().checkIndex(mouseEvent.getX(), mouseEvent.getY())).getX();
			//double strokeY = game.getCells().getCellsBoard(game.getCells().checkIndex(mouseEvent.getX(), mouseEvent.getY())).getY();
			canvasGC.strokeRect(clickedX*game.getCells().getCellSize()+1, clickedY*game.getCells().getCellSize()+1 , game.getCells().getCellSize()-2, game.getCells().getCellSize()-2);

			//kolorowanie
			Cell.State cellState;

			if(selectedColor == Color.WHITE)
				cellState = ALIVE;
			else if(selectedColor == Color.BLACK)
				cellState = DEAD;
			else if(selectedColor == Color.RED)
				cellState = TAIL;
			else if(selectedColor == Color.BLUE)
				cellState = HEAD;
			else if(selectedColor == Color.YELLOW)
				cellState = CONDUCTOR;
			else if(selectedColor == Color.BLACK)
				cellState = EMPTY;

			//drawSingeCell(canvas, (int)(clickedX*game.getCells().getCellSize()), (int)(clickedY*game.getCells().getCellSize()), cellState);
			System.out.println("Wybrano komórkę o współrzędnych x: "+ clickedX + " y: "+clickedY);
		}

	}

	@Override
	public void onUpdate() {
		Cell.State[] cellState = game.getCells().getCellsStates();
		draw(cellState);
	}

	//abstract methods
	public abstract void draw(Cell.State[] cellState);
	public abstract void randomFill(Game game);

	// Getters and Setters methods
	public void setCanvas(Canvas canvas) { this.canvas = canvas; }
	public Canvas getCanvas() { return canvas; }
	public Color getSelectedColor() { return selectedColor; }
	public void setSelectedColor(Color selectedColor) { this.selectedColor = selectedColor; }

}

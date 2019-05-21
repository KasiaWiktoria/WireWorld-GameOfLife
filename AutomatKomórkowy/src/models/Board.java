package models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public abstract class Board {

	private int columns;
	private int rows;
	Canvas canvas;
	private double cellSize;
	Cell[] cells;

	public Board(int columns, int rows, Canvas canvas) {
		this.columns = columns;
		this.rows = rows;
		this.canvas = canvas;
		if (800 / this.columns < 600 / this.rows)
			this.cellSize = 800. / (double) this.columns;
		else
			this.cellSize = 600. / (double) this.rows;
	}

	public void blackFill(Canvas canvas) {
		GraphicsContext canvasGC = canvas.getGraphicsContext2D();
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getColumns(); j++) {
				canvasGC.setFill(Color.BLACK);
				canvasGC.fillRect(j * this.cellSize, this.cellSize * i, this.cellSize, this.cellSize);
			}
		}
	}

	public void randomFill(Canvas canvas) {}

	public void setDimension(TextField columns, TextField rows, Canvas gameCanvas) {

		try {
			this.setColumns(Integer.parseInt(columns.getText()));
			this.setRows(Integer.parseInt(rows.getText()));
		} catch (NumberFormatException e) {
			System.out.println("cos nie tak z wymiarami, zly format\n");
		}
		if (800 / Double.parseDouble(columns.getText()) < 600 / Double.parseDouble(rows.getText()))
			this.setCellSize(800. / Double.parseDouble(columns.getText()));
		else
			this.setCellSize(600. / Double.parseDouble(rows.getText()));
		this.cleanCanvas(gameCanvas);
		this.randomFill(gameCanvas);
	}

	public void cleanCanvas(Canvas canvas) {
		GraphicsContext canvasGC = canvas.getGraphicsContext2D();
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getColumns(); j++) {
				canvasGC.setFill(Color.web("#EEEEEE"));
				canvasGC.fillRect(0, 0, 800, 600);
			}
		}
	}

	public void drawSingeCell(Canvas canvas, int x, int y, WireWorld.WiereworldStates state) {
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
		graphicsContext.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
	}

	public void setPromptForDimensions(TextField columns, TextField rows) {
		columns.setPromptText("columns");
		rows.setPromptText("rows");
	}

	public void setCell(WireWorld.WiereworldStates newState, Board board, int clickedX, int clickedY,
						boolean selectionActive) {
		if (!selectionActive)
			return;

		board.drawSingeCell(board.canvas, clickedX, clickedY, newState);
	}

	// Getters and Setters methods
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public double getCellSize() {
		return cellSize;
	}

	public void setCellSize(double cellSize) {
		this.cellSize = cellSize;
	}
}

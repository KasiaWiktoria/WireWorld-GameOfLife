package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ColorPicker extends Board {
    //private final MainController mainController;
    private final double buttonSize;

    public ColorPicker(Canvas canvas/*, MainController MainController*/) {
        super(2 ,2,canvas);
        //this.mainController = MainController;

        canvas.setOnMouseClicked(this::canvasClicked);
        buttonSize = canvas.getWidth()/2;
    }

    public void setSize(){
        this.setColumns((int)(this.canvas.getWidth()/this.buttonSize));
        this.setRows((int)(this.canvas.getHeight()/this.buttonSize));
    }

    public void colorFill() {
        this.setSize();
        GraphicsContext colorToolGC = canvas.getGraphicsContext2D();
        colorToolGC.setFill(Color.RED);
        colorToolGC.fillRect(0,0, buttonSize, buttonSize);
        colorToolGC.setFill(Color.YELLOW);
        colorToolGC.fillRect(0, buttonSize, buttonSize, buttonSize);
        colorToolGC.setFill(Color.BLUE);
        colorToolGC.fillRect(buttonSize,0, buttonSize, buttonSize);
        colorToolGC.setFill(Color.BLACK);
        colorToolGC.fillRect(buttonSize, buttonSize, buttonSize, buttonSize);
    }

    public void bwFill() {
        this.setSize();
        GraphicsContext bwToolGC = canvas.getGraphicsContext2D();
        bwToolGC.setFill(Color.BLACK);
        bwToolGC.fillRect(0, 0, buttonSize, buttonSize);
        bwToolGC.setFill(Color.WHITE);
        bwToolGC.fillRect(buttonSize, 0, buttonSize, buttonSize);
    }

    private WireWorldBoard.WiereworldStates getClickedColorState(int x, int y) {

        if (x == 0 && y == 0)
            return WireWorldBoard.WiereworldStates.TAIL;
        if (x == 1 && y == 0)
            return WireWorldBoard.WiereworldStates.HEAD;
        if (x == 0 && y == 1)
            return WireWorldBoard.WiereworldStates.CONDUCTOR;
        else
            return WireWorldBoard.WiereworldStates.EMPTY;
    }


    private void canvasClicked(MouseEvent mouseEvent) {
        int clickedX = (int) (mouseEvent.getX()/ buttonSize); //new
        int clickedY = (int) (mouseEvent.getX()/ buttonSize);

        setCell(getClickedColorState(clickedX, clickedY), this, clickedX, clickedY, true);
    }
}



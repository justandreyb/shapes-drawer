package by.bsuir.drawer.ui.component.board;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import by.bsuir.drawer.ui.state.History;

public class ResizableCanvas extends Canvas {

    private History history;

    public ResizableCanvas() {
        history = new History();

        // Redraw canvas when size history.
        widthProperty().addListener(evt -> draw());
        heightProperty().addListener(evt -> draw());
    }

    private void draw() {
        double width = getWidth();
        double height = getHeight();

        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, width, height);
    }

    public History getHistory() {
        return history;
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }
}

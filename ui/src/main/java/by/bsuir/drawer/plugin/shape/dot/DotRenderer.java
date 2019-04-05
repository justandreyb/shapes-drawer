package by.bsuir.drawer.plugin.shape.dot;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class DotRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((point, context) -> {
            Dot dot = new Dot(new Point(mouseEvent.getX(), mouseEvent.getY()));
            history.addShape(dot);

            context.beginPath();
            context.lineTo(mouseEvent.getX(), mouseEvent.getY());
            context.stroke();

            return dot;
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((point, context) -> {
            Dot dot = new Dot(new Point(mouseEvent.getX(), mouseEvent.getY()));
            history.addShape(dot);

            context.lineTo(mouseEvent.getX(), mouseEvent.getY());
            context.stroke();

            return dot;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((point, context) -> {
            Dot dot = new Dot(new Point(mouseEvent.getX(), mouseEvent.getY()));
            history.addShape(dot);

            context.lineTo(mouseEvent.getX(), mouseEvent.getY());
            context.stroke();
            context.closePath();

            return dot;
        });
    }
}

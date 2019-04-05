package by.bsuir.drawer.plugin.shape.square;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class SquareRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((n, context) -> {
            context.beginPath();

            return new Square(new Point(mouseEvent.getX(), mouseEvent.getY()), null);
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.<Square>addToDrawing((square, context) -> {
            if (square.getWidth() != null) {
                history.removeLast();
            }
            square.setWidth((Math.abs(mouseEvent.getX() - square.getStartPoint().getX()) +
                Math.abs(mouseEvent.getY() - square.getStartPoint().getY())) / 2);

            context.fillRect(square.getStartPoint().getX(), square.getStartPoint().getY(),
                square.getWidth(), square.getWidth());
            context.strokeRect(square.getStartPoint().getX(), square.getStartPoint().getY(),
                square.getWidth(), square.getWidth());

            return square;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.<Square>addToDrawing((square, context) -> {
            square.setWidth((Math.abs(mouseEvent.getX() - square.getStartPoint().getX()) +
                Math.abs(mouseEvent.getY() - square.getStartPoint().getY())) / 2);
            history.addShape(square);

            context.fillRect(square.getStartPoint().getX(), square.getStartPoint().getY(),
                square.getWidth(), square.getWidth());
            context.strokeRect(square.getStartPoint().getX(), square.getStartPoint().getY(),
                square.getWidth(), square.getWidth());
            context.closePath();

            return square;
        });
    }
}

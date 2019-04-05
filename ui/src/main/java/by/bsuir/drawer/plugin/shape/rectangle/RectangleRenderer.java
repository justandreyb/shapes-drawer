package by.bsuir.drawer.plugin.shape.rectangle;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class RectangleRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((n, context) -> {
            context.beginPath();

            return new Rectangle(new Point(mouseEvent.getX(), mouseEvent.getY()), null, null);
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.<Rectangle>addToDrawing((rectangle, context) -> {
            if (rectangle.getHeight() != null) {
                history.removeLast();
            }
            rectangle.setWidth(Math.abs((mouseEvent.getX() - rectangle.getStartPoint().getX())));
            rectangle.setHeight(Math.abs((mouseEvent.getY() - rectangle.getStartPoint().getY())));

            context.fillRect(rectangle.getStartPoint().getX(), rectangle.getStartPoint().getY(),
                rectangle.getWidth(), rectangle.getHeight());
            context.strokeRect(rectangle.getStartPoint().getX(), rectangle.getStartPoint().getY(),
                rectangle.getWidth(), rectangle.getHeight());

            return rectangle;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.<Rectangle>addToDrawing((rectangle, context) -> {
            rectangle.setWidth(Math.abs((mouseEvent.getX() - rectangle.getStartPoint().getX())));
            rectangle.setHeight(Math.abs((mouseEvent.getY() - rectangle.getStartPoint().getY())));
            history.addShape(rectangle);

            context.fillRect(rectangle.getStartPoint().getX(), rectangle.getStartPoint().getY(),
                rectangle.getWidth(), rectangle.getHeight());
            context.strokeRect(rectangle.getStartPoint().getX(), rectangle.getStartPoint().getY(),
                rectangle.getWidth(), rectangle.getHeight());
            context.closePath();

            return rectangle;
        });
    }
}

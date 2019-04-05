package by.bsuir.drawer.plugin.shape.circle;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class CircleRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((n, context) -> {
            context.beginPath();

            return new Circle(new Point(mouseEvent.getX(), mouseEvent.getY()), null);
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.<Circle>addToDrawing((circle, context) -> {
            if (circle.getRadius() != null) {
                history.removeLast();
            }
            circle.setRadius((Math.abs(mouseEvent.getX() - circle.getCenterPoint().getX()) +
                Math.abs(mouseEvent.getY() - circle.getCenterPoint().getY())) / 2);

            context.fillOval(circle.getCenterPoint().getX(), circle.getCenterPoint().getY(), circle.getRadius(),
                circle.getRadius());
            context.strokeOval(circle.getCenterPoint().getX(), circle.getCenterPoint().getY(), circle.getRadius(),
                circle.getRadius());

            return circle;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.<Circle>addToDrawing((circle, context) -> {
            circle.setRadius((Math.abs(mouseEvent.getX() - circle.getCenterPoint().getX()) +
                Math.abs(mouseEvent.getY() - circle.getCenterPoint().getY())) / 2);
            history.addShape(circle);

            context.fillOval(circle.getCenterPoint().getX(), circle.getCenterPoint().getY(), circle.getRadius(),
                circle.getRadius());
            context.strokeOval(circle.getCenterPoint().getX(), circle.getCenterPoint().getY(), circle.getRadius(),
                circle.getRadius());
            context.stroke();
            context.closePath();

            return circle;
        });
    }
}

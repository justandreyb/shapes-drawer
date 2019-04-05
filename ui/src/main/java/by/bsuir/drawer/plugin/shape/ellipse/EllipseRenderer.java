package by.bsuir.drawer.plugin.shape.ellipse;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.plugin.shape.circle.Circle;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class EllipseRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((n, context) -> {
            context.beginPath();

            return new Ellipse(new Point(mouseEvent.getX(), mouseEvent.getY()), null, null);
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.<Ellipse>addToDrawing((ellipse, context) -> {
            if (ellipse.getRadiusX() != null) {
                history.removeLast();
            }
            ellipse.setRadiusX(Math.abs(mouseEvent.getX() - ellipse.getCenterPoint().getX()));
            ellipse.setRadiusY(Math.abs(mouseEvent.getY() - ellipse.getCenterPoint().getY()));

            context.fillOval(ellipse.getCenterPoint().getX(), ellipse.getCenterPoint().getY(), ellipse.getRadiusX(),
                ellipse.getRadiusY());
            context.strokeOval(ellipse.getCenterPoint().getX(), ellipse.getCenterPoint().getY(), ellipse.getRadiusX(),
                ellipse.getRadiusY());

            return ellipse;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.<Ellipse>addToDrawing((ellipse, context) -> {
            ellipse.setRadiusX(Math.abs(mouseEvent.getX() - ellipse.getCenterPoint().getX()));
            ellipse.setRadiusY(Math.abs(mouseEvent.getY() - ellipse.getCenterPoint().getY()));

            context.fillOval(ellipse.getCenterPoint().getX(), ellipse.getCenterPoint().getY(), ellipse.getRadiusX(),
                ellipse.getRadiusY());
            context.strokeOval(ellipse.getCenterPoint().getX(), ellipse.getCenterPoint().getY(), ellipse.getRadiusX(),
                ellipse.getRadiusY());

            return ellipse;
        });
    }
}

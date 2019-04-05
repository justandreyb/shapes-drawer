package by.bsuir.drawer.plugin.shape.line;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.state.History;

public class LineRenderer implements Renderer {

    @Override
    public void startDrawing(MouseEvent mouseEvent, History history) {
        history.addToDrawing((n, context) -> {
            context.beginPath();
            context.stroke();

            return new Line(new Point(mouseEvent.getX(), mouseEvent.getY()), null);
        });
    }

    @Override
    public void processDrawing(MouseEvent mouseEvent, History history) {
        history.<Line>addToDrawing((line, context) -> {
            if (line.getEndPoint() != null) {
                history.removeLast();
            }
            line.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));

            context.strokeLine(line.getStartPoint().getX(), line.getStartPoint().getY(),
                mouseEvent.getX(), mouseEvent.getY());
            context.stroke();

            return line;
        });
    }

    @Override
    public void endDrawing(MouseEvent mouseEvent, History history) {
        history.<Line>addToDrawing((line, context) -> {
            line.setEndPoint(new Point(mouseEvent.getX(), mouseEvent.getY()));
            history.addShape(line);

            context.strokeLine(line.getStartPoint().getX(), line.getStartPoint().getY(),
                mouseEvent.getX(), mouseEvent.getY());
            context.closePath();

            return line;
        });
    }
}

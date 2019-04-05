package by.bsuir.drawer.ui.component.board;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;

import by.bsuir.drawer.model.shape.Shape;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.settings.Settings;
import by.bsuir.drawer.ui.settings.SettingsChangeListenable;
import by.bsuir.drawer.ui.settings.SettingsEditable;
import by.bsuir.drawer.ui.settings.UIContext;
import by.bsuir.drawer.ui.state.History;

public class DrawingBoard extends AnchorPane implements SettingsChangeListenable, SettingsEditable {

    private GraphicsContext context;
    private ResizableCanvas canvas;
    private Renderer renderer;
    private History history;

    public DrawingBoard() {
        super();
        setMinHeight(600);
        setMinWidth(800);

        canvas = new ResizableCanvas();
        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());
        context = canvas.getGraphicsContext2D();
        context.setLineWidth(getSettings().getLineWidth());
        history = new History();

        // Clear context
        history.addToDrawing((n, context) -> {
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            return null;
        });

        handleMouseClick(canvas, history);
        handleMouseDrag(canvas, history);
        handleMouseReleased(canvas, history);

        getChildren().addAll(canvas);
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {
        context.setFont(newSettings.getFont());
        context.setLineWidth(newSettings.getLineWidth());
        context.setStroke(newSettings.getColor());
        context.setFill(newSettings.getFillColor());

        renderer = UIContext.get().getRenderer(newSettings.getSelectedShapeClass());
    }

    private void handleMouseClick(Canvas canvas, History history) {
        canvas.setOnMousePressed(e -> {
            if (renderer == null) {
                return;
            }
            renderer.startDrawing(e, history);
            Holder shapeHolder = new Holder();
            history.getDrawingCommands().forEach(command ->
                shapeHolder.setShape(command.apply(shapeHolder.getShape(), context)));
//            if (drowbtn.isSelected()) {
//                context.lineTo(e.getX(), e.getY());
            /*} else if (rubberbtn.isSelected()) {
                double lineWidth = context.getLineWidth();
                context.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            } else if (linebtn.isSelected()) {
                line.setStartX(e.getX());
                line.setStartY(e.getY());
            } else if (rectbtn.isSelected()) {
                rect.setX(e.getX());
                rect.setY(e.getY());
            } else if (circlebtn.isSelected()) {
                circ.setCenterX(e.getX());
                circ.setCenterY(e.getY());
            } else if (elpslebtn.isSelected()) {
                elps.setCenterX(e.getX());
                elps.setCenterY(e.getY());
            } else if (textbtn.isSelected()) {
                context.fillText(text.getText(), e.getX(), e.getY());
                context.strokeText(text.getText(), e.getX(), e.getY());
            }*/
        });
    }

    private void handleMouseDrag(Canvas canvas, History history) {
        canvas.setOnMouseDragged(e -> {
            if (renderer == null) {
                return;
            }
            renderer.processDrawing(e, history);
            Holder shapeHolder = new Holder();
            history.getDrawingCommands().forEach(command ->
                shapeHolder.setShape(command.apply(shapeHolder.getShape(), context)));
//            if (drowbtn.isSelected())
//            context.lineTo(e.getX(), e.getY());
//            context.stroke();
            /*} else if (rubberbtn.isSelected()) {
                double lineWidth = context.getLineWidth();
                context.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }*/
        });
    }

    private void handleMouseReleased(Canvas canvas, History history) {
        canvas.setOnMouseReleased(e -> {
            if (renderer == null) {
                return;
            }
            renderer.endDrawing(e, history);
            Holder shapeHolder = new Holder();
            history.getDrawingCommands().forEach(command ->
                shapeHolder.setShape(command.apply(shapeHolder.getShape(), context)));
//            if (drowbtn.isSelected()) {
//                context.lineTo(e.getX(), e.getY());
//                context.stroke();
//                context.closePath();
            /*} else if (rubberbtn.isSelected()) {
                double lineWidth = context.getLineWidth();
                context.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            } else if (linebtn.isSelected()) {
                line.setEndX(e.getX());
                line.setEndY(e.getY());
                context.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());

            } else if (rectbtn.isSelected()) {
                rect.setWidth(Math.abs((e.getX() - rect.getX())));
                rect.setHeight(Math.abs((e.getY() - rect.getY())));
                //rect.setX((rect.getX() > e.getX()) ? e.getX(): rect.getX());
                if (rect.getX() > e.getX()) {
                    rect.setX(e.getX());
                }
                //rect.setY((rect.getY() > e.getY()) ? e.getY(): rect.getY());
                if (rect.getY() > e.getY()) {
                    rect.setY(e.getY());
                }

                context.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
                context.strokeRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());


            } else if (circlebtn.isSelected()) {
                circ.setRadius((Math.abs(e.getX() - circ.getCenterX()) + Math.abs(e.getY() - circ.getCenterY())) / 2);

                if (circ.getCenterX() > e.getX()) {
                    circ.setCenterX(e.getX());
                }
                if (circ.getCenterY() > e.getY()) {
                    circ.setCenterY(e.getY());
                }

                context.fillOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());
                context.strokeOval(circ.getCenterX(), circ.getCenterY(), circ.getRadius(), circ.getRadius());

            } else if (elpslebtn.isSelected()) {
                elps.setRadiusX(Math.abs(e.getX() - elps.getCenterX()));
                elps.setRadiusY(Math.abs(e.getY() - elps.getCenterY()));

                if (elps.getCenterX() > e.getX()) {
                    elps.setCenterX(e.getX());
                }
                if (elps.getCenterY() > e.getY()) {
                    elps.setCenterY(e.getY());
                }

                context.strokeOval(elps.getCenterX(), elps.getCenterY(), elps.getRadiusX(), elps.getRadiusY());
                context.fillOval(elps.getCenterX(), elps.getCenterY(), elps.getRadiusX(), elps.getRadiusY());

            }*/
        });
    }

    private class Holder {
        Shape shape;

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }
    }

}

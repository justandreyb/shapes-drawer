package by.bsuir.drawer.ui.component.board;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

import by.bsuir.drawer.ui.settings.Settings;
import by.bsuir.drawer.ui.settings.SettingsChangeListenable;
import by.bsuir.drawer.ui.settings.SettingsEditable;

public class DrawingBoard extends AnchorPane implements SettingsChangeListenable, SettingsEditable {

    private GraphicsContext context;

    public DrawingBoard() {
        super();
        setMinHeight(600);
        setMinWidth(800);

        var canvas = new ResizableCanvas();
        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());
        context = canvas.getGraphicsContext2D();
        context.setLineWidth(getSettings().getLineWidth());

        handleMouseClick(canvas);
        handleMouseDrag(canvas);
        handleMouseReleased(canvas);

        getChildren().addAll(canvas);
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {
        context.setFont(newSettings.getFont());
        context.setLineWidth(newSettings.getLineWidth());
        context.setStroke(newSettings.getColor());
        context.setFill(newSettings.getFillColor());
        System.out.println(newSettings.getSelectedButton());
    }

    private void handleMouseClick(Canvas canvas) {
        canvas.setOnMousePressed(e -> {
//            if (drowbtn.isSelected()) {
                context.beginPath();
                context.lineTo(e.getX(), e.getY());
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

    private void handleMouseDrag(Canvas canvas) {
        canvas.setOnMouseDragged(e -> {
//            if (drowbtn.isSelected()) {
                context.lineTo(e.getX(), e.getY());
                context.stroke();
            /*} else if (rubberbtn.isSelected()) {
                double lineWidth = context.getLineWidth();
                context.clearRect(e.getX() - lineWidth / 2, e.getY() - lineWidth / 2, lineWidth, lineWidth);
            }*/
        });
    }

    private void handleMouseReleased(Canvas canvas) {
        canvas.setOnMouseReleased(e -> {
//            if (drowbtn.isSelected()) {
                context.lineTo(e.getX(), e.getY());
                context.stroke();
                context.closePath();
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

    private class ResizableCanvas extends Canvas {
        public ResizableCanvas() {
            // Redraw canvas when size changes.
            widthProperty().addListener(evt -> draw());
            heightProperty().addListener(evt -> draw());
        }

        private void draw() {
            double width = getWidth();
            double height = getHeight();

            GraphicsContext gc = getGraphicsContext2D();
            gc.clearRect(0, 0, width, height);
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

}

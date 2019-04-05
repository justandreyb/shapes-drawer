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
        history = UIContext.get().getHistory();

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

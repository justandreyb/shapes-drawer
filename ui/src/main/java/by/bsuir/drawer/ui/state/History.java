package by.bsuir.drawer.ui.state;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

import by.bsuir.drawer.model.function.SerializableBiFunction;
import by.bsuir.drawer.model.shape.Shape;

public class History {

    private List<SerializableBiFunction<Shape, GraphicsContext>> drawingStack;
    private List<Shape> drawedShapes;

    public History() {
        drawingStack = new LinkedList<>();
        drawedShapes = new ArrayList<>();
    }

    public <S extends Shape> void addToDrawing(SerializableBiFunction<S, GraphicsContext> drawingFunction) {
        drawingStack.add((SerializableBiFunction<Shape, GraphicsContext>) drawingFunction);
    }

    public <S extends Shape> void addShape(S shape) {
        drawedShapes.add(shape);
    }

    public SerializableBiFunction<Shape, GraphicsContext> getLastDrawingFunction() {
        return drawingStack.get(drawingStack.size() - 1);
    }

    public List<SerializableBiFunction<Shape, GraphicsContext>> getDrawingCommands() {
        return drawingStack;
    }

    public void removeLast() {
        drawingStack.remove(drawingStack.size() - 1);
    }

}

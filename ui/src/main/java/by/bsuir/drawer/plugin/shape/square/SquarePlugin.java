package by.bsuir.drawer.plugin.shape.square;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class SquarePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.square.Square";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.square.SquareRenderer";
    }
}

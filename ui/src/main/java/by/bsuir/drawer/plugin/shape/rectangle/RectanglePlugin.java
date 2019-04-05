package by.bsuir.drawer.plugin.shape.rectangle;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class RectanglePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.rectangle.Rectangle";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.rectangle.RectangleRenderer";
    }
}

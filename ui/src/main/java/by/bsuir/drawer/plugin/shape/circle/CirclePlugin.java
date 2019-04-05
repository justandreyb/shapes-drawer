package by.bsuir.drawer.plugin.shape.circle;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class CirclePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.circle.Circle";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.circle.CircleRenderer";
    }
}

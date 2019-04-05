package by.bsuir.drawer.plugin.shape.triangle;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class TrianglePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.triangle.Triangle";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.triangle.TriangleRenderer";
    }
}

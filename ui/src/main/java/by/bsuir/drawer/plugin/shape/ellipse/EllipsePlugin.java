package by.bsuir.drawer.plugin.shape.ellipse;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class EllipsePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.ellipse.Ellipse";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.ellipse.EllipseRenderer";
    }
}

package by.bsuir.drawer.plugin.shape.dot;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class DotPlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.dot.Dot";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.dot.DotRenderer";
    }
}

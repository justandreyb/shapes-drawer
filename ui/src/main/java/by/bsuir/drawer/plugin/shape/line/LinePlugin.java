package by.bsuir.drawer.plugin.shape.line;

import by.bsuir.drawer.plugin.shape.ShapePlugin;

public class LinePlugin extends ShapePlugin {

    @Override
    public String getShapeClass() {
        return "by.bsuir.drawer.plugin.shape.line.Line";
    }

    @Override
    public String getRendererClass() {
        return "by.bsuir.drawer.plugin.shape.line.LineRenderer";
    }
}

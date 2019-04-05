package by.bsuir.drawer.plugin.shape;

import by.bsuir.drawer.model.shape.Shape;
import by.bsuir.drawer.ui.render.Renderer;

public abstract class ShapePlugin {

    public ShapePlugin() {
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public abstract String getShapeClass();

    public abstract String getRendererClass();

    public Class<? extends Shape> loadShapeClass() {
        try {
            return (Class<? extends Shape>) Class.forName(getShapeClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Class<? extends Renderer> loadRendererClass() {
        try {
            return (Class<? extends Renderer>) Class.forName(getRendererClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

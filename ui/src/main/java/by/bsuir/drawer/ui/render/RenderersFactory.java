package by.bsuir.drawer.ui.render;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.drawer.model.shape.Shape;

public enum RenderersFactory {

    INSTANCE;

    public static RenderersFactory get() {
        return INSTANCE;
    }

    private Map<Class<? extends Shape>, Renderer> renderersByShapes;

    RenderersFactory() {
        renderersByShapes = new HashMap<>();
    }

    public void registerNewRenderer(Class<? extends Shape> shapeClass, Renderer renderer) {
        renderersByShapes.put(shapeClass, renderer);
    }

    public <S extends Shape> Renderer getRenderer(Class<S> shapeClass) {
        return renderersByShapes.get(shapeClass);
    }

}

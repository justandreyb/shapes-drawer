package by.bsuir.drawer.ui.settings;

import java.util.HashSet;
import java.util.Set;

import javafx.stage.Stage;

import by.bsuir.drawer.plugin.shape.dot.Dot;
import by.bsuir.drawer.plugin.shape.line.Line;
import by.bsuir.drawer.model.shape.Shape;
import by.bsuir.drawer.ui.render.Renderer;
import by.bsuir.drawer.ui.render.RenderersFactory;
import by.bsuir.drawer.plugin.shape.dot.DotRenderer;
import by.bsuir.drawer.plugin.shape.line.LineRenderer;
import by.bsuir.drawer.ui.state.History;

public enum UIContext {

    INSTANCE;

    private RenderersFactory renderersFactory;
    private Set<Class<? extends Shape>> availableShapes;
    private History history;
    private Stage primaryStage;


    public static UIContext get() {
        return INSTANCE;
    }

    UIContext() {
        renderersFactory = RenderersFactory.get();
        availableShapes = new HashSet<>();
        history = new History();

        registerShape(Dot.class, new DotRenderer());
        registerShape(Line.class, new LineRenderer());
    }

    public History getHistory() {
        return history;
    }

    public Set<Class<? extends Shape>> getAvailableShapes() {
        return availableShapes;
    }

    public void setAvailableShapes(Set<Class<? extends Shape>> availableShapes) {
        this.availableShapes = availableShapes;
    }

    public RenderersFactory getRenderersFactory() {
        return renderersFactory;
    }

    public Renderer getRenderer(Class<? extends Shape> shapeClass) {
        return renderersFactory.getRenderer(shapeClass);
    }

    public void setRenderersFactory(RenderersFactory renderersFactory) {
        this.renderersFactory = renderersFactory;
    }

    public void registerShape(Class<? extends Shape> shape, Renderer renderer) {
        this.availableShapes.add(shape);
        this.renderersFactory.registerNewRenderer(shape, renderer);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}

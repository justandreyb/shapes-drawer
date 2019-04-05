package by.bsuir.drawer.plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import by.bsuir.drawer.model.shape.Shape;
import by.bsuir.drawer.plugin.shape.ShapePlugin;
import by.bsuir.drawer.ui.render.Renderer;

public class Plugins {

    public static Map<Class<? extends Shape>, Renderer> getShapesPlugins() {
        Map<Class<? extends Shape>, Renderer> shapesPlugins = new HashMap<>();
        getShapePluginsFromDescriptor().forEach(shapePlugin ->
            shapesPlugins.put(shapePlugin.loadShapeClass(), instantiateClass(shapePlugin.loadRendererClass())));
        return shapesPlugins;
    }

    private static Set<ShapePlugin> getShapePluginsFromDescriptor() {
        InputStream inputStream = Plugins.class.getResourceAsStream("/plugins.descriptor");
        String pluginsString = readFromInputStream(inputStream);

        System.out.println("\nLoaded plugins:");
        return Arrays.stream(pluginsString.split(";"))
            .filter(value -> !value.isBlank())
            .peek(System.out::println)
            .map(Plugins::loadPlugin)
            .collect(Collectors.toSet());
    }

    private static String readFromInputStream(InputStream inputStream){
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

    private static ShapePlugin loadPlugin(String name) {
        try {
            return (ShapePlugin) instantiateClass(Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> T instantiateClass(Class<T> clazz) {
        try {
            Constructor constructor = clazz.getConstructor();
            return (T) constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

}

package by.bsuir.drawer.model.function;

import java.io.Serializable;
import java.util.function.BiFunction;

public interface SerializableBiFunction<Shape, T> extends BiFunction<Shape, T, Shape>, Serializable {
}

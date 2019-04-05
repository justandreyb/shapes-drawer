package by.bsuir.drawer.plugin.shape.dot;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

/**
 * Simple dot which contains only point.
 *
 * @author justandreyb
 */
public class Dot extends Shape {

    /**
     * Point.
     */
    private Point point;

    public Dot(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

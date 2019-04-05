package by.bsuir.drawer.plugin.shape.line;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

/**
 * Simple line which contains start point and end point.
 *
 * @author justandreyb
 */
public class Line extends Shape {

    /**
     * Start point.
     */
    private Point startPoint;

    /**
     * End point.
     */
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}

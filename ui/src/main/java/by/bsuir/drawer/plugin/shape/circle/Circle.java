package by.bsuir.drawer.plugin.shape.circle;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

public class Circle extends Shape {

    /**
     * Center point.
     */
    private Point centerPoint;

    private Double radius;

    public Circle(Point centerPoint, Double radius) {
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
            "centerPoint=" + centerPoint +
            ", radius=" + radius +
            "} " + super.toString();
    }
}

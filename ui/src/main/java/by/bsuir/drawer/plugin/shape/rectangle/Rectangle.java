package by.bsuir.drawer.plugin.shape.rectangle;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

public class Rectangle extends Shape {

    private Point startPoint;

    private Double width;

    private Double height;

    public Rectangle(Point startPoint, Double width, Double height) {
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "startPoint=" + startPoint +
            ", width=" + width +
            ", height=" + height +
            "} " + super.toString();
    }
}

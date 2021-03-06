package by.bsuir.drawer.plugin.shape.square;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

public class Square extends Shape {

    private Point startPoint;

    private Double width;

    public Square(Point startPoint, Double width) {
        this.startPoint = startPoint;
        this.width = width;
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

    @Override
    public String toString() {
        return "Square{" +
            "startPoint=" + startPoint +
            ", width=" + width +
            "} " + super.toString();
    }
}

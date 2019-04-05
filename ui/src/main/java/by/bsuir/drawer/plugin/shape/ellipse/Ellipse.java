package by.bsuir.drawer.plugin.shape.ellipse;

import by.bsuir.drawer.model.point.Point;
import by.bsuir.drawer.model.shape.Shape;

public class Ellipse extends Shape {

    /**
     * Center point.
     */
    private Point centerPoint;

    private Double radiusX;
    private Double radiusY;

    public Ellipse(Point centerPoint, Double radiusX, Double radiusY) {
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public Double getRadiusX() {
        return radiusX;
    }

    public void setRadiusX(Double radiusX) {
        this.radiusX = radiusX;
    }

    public Double getRadiusY() {
        return radiusY;
    }

    public void setRadiusY(Double radiusY) {
        this.radiusY = radiusY;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
            "centerPoint=" + centerPoint +
            ", radiusX=" + radiusX +
            ", radiusY=" + radiusY +
            "} " + super.toString();
    }
}

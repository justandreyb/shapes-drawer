package by.bsuir.drawer.model.point;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representation of point on the drawing board.
 *
 * @author justandreyb
 */
public class Point implements Serializable {

    /**
     * X-axis value.
     */
    private Double x;

    /**
     * Y-axis value.
     */
    private Double y;

    /**
     * Creates point in 2D.
     *
     * @param x X-axis value
     * @param y Y-axis value
     */
    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
            Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

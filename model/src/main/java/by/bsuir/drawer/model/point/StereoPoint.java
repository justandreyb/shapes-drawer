package by.bsuir.drawer.model.point;

import java.util.Objects;

/**
 * Representation of stereo point on the drawing board.
 *
 * @author justandreyb
 */
public class StereoPoint extends Point {

    /**
     * Z-axis value.
     */
    private Double z;

    public StereoPoint(Double x, Double y, Double z) {
        super(x, y);

        this.z = z;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StereoPoint that = (StereoPoint) o;
        return Objects.equals(z, that.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}

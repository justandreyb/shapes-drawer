package by.bsuir.drawer.ui.settings;

import java.io.Serializable;
import java.util.Objects;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import by.bsuir.drawer.model.shape.Shape;


/**
 * Settings for the drawing board.
 *
 * @author justandreyb
 */
public class Settings implements Serializable {

    public static final Settings DEFAULT;
    static {
        DEFAULT = new Settings();
        DEFAULT.setFont(Font.getDefault());
        DEFAULT.setColor(Color.BLACK);
        DEFAULT.setFillColor(Color.TRANSPARENT);
        DEFAULT.setLineWidth(4.5);
    }

    /**
     * Color of the point.
     */
    private Color color;

    /**
     * Color of the point.
     */
    private Color fillColor;

    /**
     * Size of lines in shape.
     */
    private double lineWidth;

    /**
     * Font.
     */
    private Font font;

    private Class<? extends Shape> selectedShapeClass;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Class<? extends Shape> getSelectedShapeClass() {
        return selectedShapeClass;
    }

    public void setSelectedShapeClass(Class<? extends Shape> selectedShapeClass) {
        this.selectedShapeClass = selectedShapeClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settings settings = (Settings) o;
        return Double.compare(settings.lineWidth, lineWidth) == 0 &&
            Objects.equals(color, settings.color) &&
            Objects.equals(fillColor, settings.fillColor) &&
            Objects.equals(selectedShapeClass, settings.selectedShapeClass) &&
            Objects.equals(font, settings.font);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, fillColor, lineWidth, selectedShapeClass, font);
    }

    @Override
    protected Settings clone() {
        var copy = new Settings();
        copy.lineWidth = this.lineWidth;
        copy.color = this.color;
        copy.fillColor = this.fillColor;
        copy.font = this.font;
        copy.selectedShapeClass = this.selectedShapeClass;
        return copy;
    }
}

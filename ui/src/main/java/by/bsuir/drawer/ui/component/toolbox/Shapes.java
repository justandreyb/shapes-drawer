package by.bsuir.drawer.ui.component.toolbox;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javafx.scene.Cursor;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import by.bsuir.drawer.model.shape.Shape;
import by.bsuir.drawer.ui.settings.UIContext;
import by.bsuir.drawer.ui.settings.Settings;

public class Shapes extends ToolboxElement {

    @Override
    protected Collection<? extends Control> createControls() {
        List<ShapeButton> toolsArr = UIContext.get().getAvailableShapes().stream()
            .map(shapeClass -> new ShapeButton(shapeClass, shapeClass.getSimpleName()))
            .collect(Collectors.toList());
//        ShapeButton rubberbtn = new ShapeButton("Rubber");
//        ShapeButton linebtn = new ShapeButton(Line.class, "Line");
//        ShapeButton rectbtn = new ShapeButton("Rectangle");
//        ShapeButton circlebtn = new ShapeButton("Circle");
//        ShapeButton elpslebtn = new ShapeButton("Ellipse");
//        ShapeButton textbtn = new ShapeButton("Text");

//        List<ShapeButton> toolsArr = Arrays.asList(drowbtn, rubberbtn, linebtn, rectbtn, circlebtn, elpslebtn, textbtn);

        ToggleGroup tools = new ToggleGroup();

        for (ShapeButton tool : toolsArr) {
            tool.setMinWidth(90);
            tool.setToggleGroup(tools);
            tool.setCursor(Cursor.HAND);
            tool.setOnMouseClicked(event -> updateSettings(settings ->
                settings.setSelectedShapeClass(tool.isSelected() ? tool.getShapeClass() : null)));
        }

        return toolsArr;
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }

    private class ShapeButton extends ToggleButton {

        private Class<? extends Shape> shapeClass;

        private ShapeButton(Class<? extends Shape> shapeClass, String text) {
            super(text);

            this.shapeClass = shapeClass;
        }

        public Class<? extends Shape> getShapeClass() {
            return shapeClass;
        }
    }
}

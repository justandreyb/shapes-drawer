package by.bsuir.drawer.ui.component.toolbox;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javafx.scene.Cursor;
import javafx.scene.control.Control;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import by.bsuir.drawer.ui.settings.Settings;

public class Shapes extends ToolboxElement {

    @Override
    protected Collection<? extends Control> createControls() {
        ToggleButton drowbtn = new ToggleButton("Draw");
        ToggleButton rubberbtn = new ToggleButton("Rubber");
        ToggleButton linebtn = new ToggleButton("Line");
        ToggleButton rectbtn = new ToggleButton("Rectangle");
        ToggleButton circlebtn = new ToggleButton("Circle");
        ToggleButton elpslebtn = new ToggleButton("Ellipse");
        ToggleButton textbtn = new ToggleButton("Text");

        List<ToggleButton> toolsArr = Arrays.asList(drowbtn, rubberbtn, linebtn, rectbtn, circlebtn, elpslebtn, textbtn);

        ToggleGroup tools = new ToggleGroup();

        for (ToggleButton tool : toolsArr) {
            tool.setMinWidth(90);
            tool.setToggleGroup(tools);
            tool.setCursor(Cursor.HAND);
            tool.setOnMouseClicked(event -> updateSettings(settings ->
                settings.setSelectedButton(tool.isSelected() ? tool : null)));
        }

        return toolsArr;
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }
}

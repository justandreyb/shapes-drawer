package by.bsuir.drawer.ui.component.toolbox;

import java.util.Arrays;
import java.util.Collection;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

import by.bsuir.drawer.ui.settings.Settings;

public class LineSettings extends ToolboxElement {

    @Override
    protected Collection<? extends Control> createControls() {
        ColorPicker cpLine = new ColorPicker(Color.BLACK);
        ColorPicker cpFill = new ColorPicker(Color.TRANSPARENT);

        TextArea text = new TextArea();
        text.setPrefRowCount(1);

        Slider slider = new Slider(1, 50, 3);
        slider.setValue(getSettings().getLineWidth());
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        Label line_color = new Label("Line Color");
        Label fill_color = new Label("Fill Color");
        Label line_width = new Label(String.format("%.1f", getSettings().getLineWidth()));

        // color picker
        cpLine.setOnAction(e -> updateSettings(settings -> settings.setColor(cpLine.getValue())));
        cpFill.setOnAction(e -> updateSettings(settings -> settings.setFillColor(cpFill.getValue())));

        // slider
        slider.valueProperty().addListener(e -> {
            double width = slider.getValue();
            line_width.setText(String.format("%.1f", width));
            updateSettings(settings -> settings.setLineWidth(width));
        });

        return Arrays.asList(text, line_color, cpLine, fill_color, cpFill, line_width, slider);
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }

}

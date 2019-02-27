package by.bsuir.drawer.ui.component.toolbox;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;

import by.bsuir.drawer.ui.settings.Settings;

public class Files extends ToolboxElement {

    @Override
    protected Collection<? extends Control> createControls() {
        Button undo = new Button("Undo");
        Button redo = new Button("Redo");
        Button save = new Button("Save");
        Button open = new Button("Open");

        List<Button> basicArr = Arrays.asList(undo, redo, save, open);

        for (Button btn : basicArr) {
            btn.setMinWidth(90);
            btn.setCursor(Cursor.HAND);
            btn.setTextFill(Color.WHITE);
            btn.setStyle("-fx-background-color: #666;");
        }
        save.setStyle("-fx-background-color: #80334d;");
        open.setStyle("-fx-background-color: #80334d;");
        return basicArr;
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }

}

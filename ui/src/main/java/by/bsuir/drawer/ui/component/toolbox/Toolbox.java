package by.bsuir.drawer.ui.component.toolbox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import by.bsuir.drawer.ui.settings.Settings;
import by.bsuir.drawer.ui.settings.SettingsChangeListenable;
import by.bsuir.drawer.ui.settings.SettingsEditable;

public class Toolbox extends AnchorPane implements SettingsChangeListenable, SettingsEditable {

    public Toolbox() {
        setMinWidth(100);
        setMinHeight(600);

        VBox elementsBox = new VBox();
        elementsBox.setStyle("-fx-background-color: #999");
        elementsBox.setPadding(new Insets(8));
        elementsBox.setAlignment(Pos.TOP_CENTER);

        elementsBox.getChildren().add(new Shapes());
        elementsBox.getChildren().add(new LineSettings());
        elementsBox.getChildren().add(new Files());
        getChildren().add(elementsBox);
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }
}

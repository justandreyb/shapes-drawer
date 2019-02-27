package by.bsuir.drawer.ui.component.toolbox;

import java.util.Collection;
import java.util.stream.Collectors;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import by.bsuir.drawer.ui.settings.SettingsChangeListenable;
import by.bsuir.drawer.ui.settings.SettingsEditable;

public abstract class ToolboxElement extends AnchorPane implements SettingsChangeListenable, SettingsEditable {

    public ToolboxElement() {
        super();

        VBox controlsBox = new VBox(10);
        controlsBox.setAlignment(Pos.CENTER);
        controlsBox.setMaxWidth(100);
        controlsBox.setPadding(new Insets(5));
        controlsBox.getChildren().addAll(createControls().stream()
            .peek(control -> control.setMaxWidth(Double.MAX_VALUE))
            .collect(Collectors.toList()));
        getChildren().add(controlsBox);
    }

    protected abstract Collection<? extends Control> createControls();

}

package by.bsuir.drawer.ui.component;

import java.util.List;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import by.bsuir.drawer.ui.component.board.DrawingBoard;
import by.bsuir.drawer.ui.component.toolbox.Toolbox;
import by.bsuir.drawer.ui.settings.Settings;
import by.bsuir.drawer.ui.settings.SettingsChangeListenable;

/**
 * Representing workspace with navigation bar, toolbox and drawing board.
 *
 * @author justandreyb
 */
public class Workspace extends BorderPane {

    private final static Property<Settings> SETTINGS_PROPERTY = new SimpleObjectProperty<>(Settings.DEFAULT);

    public Workspace() {
        super();

        setLeft(new Toolbox());
        setCenter(new DrawingBoard());

        addSettingsListenerToChildren(getChildren());
    }

    public static Property<Settings> getSettingsProperty() {
        return SETTINGS_PROPERTY;
    }

    /**
     * Recursive adding settings to all children.
     *
     * @param children current component children
     */
    private void addSettingsListenerToChildren(List<Node> children) {
        children.stream()
            .filter(component -> component instanceof SettingsChangeListenable)
            .map(component -> (SettingsChangeListenable) component)
            .forEach(component -> {
                component.addListener(SETTINGS_PROPERTY);
                if (component instanceof Pane) {
                    addSettingsListenerToChildren(((Pane) component).getChildren());
                }
            });
    }
}

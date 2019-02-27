package by.bsuir.drawer.ui.settings;

import java.util.function.Consumer;

import by.bsuir.drawer.ui.component.Workspace;

/**
 * Ability to make settings changes.
 *
 * @author justandreyb
 */
public interface SettingsEditable {

    /**
     * Get current settings.
     */
    default Settings getSettings() {
        return Workspace.getSettingsProperty().getValue();
    }

    /**
     * Save new settings.
     */
    default void saveSettings(Settings newSettings) {
        Workspace.getSettingsProperty().setValue(newSettings);
    }

    /**
     * Update settings.
     */
    default void updateSettings(Consumer<Settings> updateFunction) {
        if (updateFunction != null) {
            var settings = getSettings().clone();
            updateFunction.accept(settings);
            saveSettings(settings);
        }
    }

}

package by.bsuir.drawer.ui.settings;

import javafx.beans.property.Property;

/**
 * Ability to listen settings changes.
 *
 * @author justandreyb
 */
public interface SettingsChangeListenable {

    /**
     * Adds settings for settings property.
     *
     * @param settingsProperty property with settings
     */
    default void addListener(Property<Settings> settingsProperty) {
        settingsProperty.addListener(new SettingsChangeListener(this::applySettingsChanges));
    }

    /**
     * Function which executes when settings change.
     *
     * @param oldSettings old settings
     * @param newSettings new settings
     */
    void applySettingsChanges(Settings oldSettings, Settings newSettings);

}

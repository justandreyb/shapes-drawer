package by.bsuir.drawer.ui.settings;

import java.util.function.BiConsumer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Listener for changes in drawing board which executes function when object changes.
 *
 * @author justandreyb
 */
public class SettingsChangeListener implements ChangeListener<Settings> {

    private BiConsumer<Settings, Settings> changingFunction;

    public SettingsChangeListener(BiConsumer<Settings, Settings> changingFunction) {
        this.changingFunction = changingFunction;
    }

    @Override
    public void changed(ObservableValue<? extends Settings> observable, Settings oldValue,
                        Settings newValue) {
        if (changingFunction != null) {
            changingFunction.accept(oldValue, newValue);
        }
    }
}

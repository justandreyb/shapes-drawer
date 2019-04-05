package by.bsuir.drawer.ui.component.toolbox;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import by.bsuir.drawer.logic.Serializer;
import by.bsuir.drawer.ui.settings.Settings;
import by.bsuir.drawer.ui.settings.UIContext;

public class Files extends ToolboxElement {

    @Override
    protected Collection<? extends Control> createControls() {
        Button serialize = new Button("Serialize");
        Button deserialize = new Button("Deserialize");

        List<Button> basicArr = Arrays.asList(serialize, deserialize);

        for (Button btn : basicArr) {
            btn.setMinWidth(90);
            btn.setMinHeight(40);
            btn.setCursor(Cursor.HAND);
            btn.setTextFill(Color.WHITE);
            btn.setStyle("-fx-background-color: #666;");
        }

        serialize.setStyle("-fx-background-color: #80334d;");
        serialize.setOnMouseClicked(mouseEvent -> {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            File file = fileChooser.showSaveDialog(UIContext.get().getPrimaryStage());

            if (file != null) {
                Serializer.serialize(UIContext.get().getHistory().getDrawnShapes(), file);
            }
        });

        deserialize.setStyle("-fx-background-color: #80334d;");
        deserialize.setOnMouseClicked(mouseEvent -> {
            FileChooser fileChooser = new FileChooser();

            //Set extension filter for text files
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            //Show save file dialog
            File file = fileChooser.showOpenDialog(UIContext.get().getPrimaryStage());

            if (file != null) {
                try {
                    System.out.println(Serializer.deserialize(java.nio.file.Files.readAllBytes(file.toPath())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return basicArr;
    }

    @Override
    public void applySettingsChanges(Settings oldSettings, Settings newSettings) {

    }

}

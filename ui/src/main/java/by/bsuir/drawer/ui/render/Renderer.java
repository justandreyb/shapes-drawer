package by.bsuir.drawer.ui.render;

import javafx.scene.input.MouseEvent;

import by.bsuir.drawer.ui.state.History;

/**
 *
 *
 * @author justandreyb
 */
public interface Renderer {

    void startDrawing(MouseEvent mouseEvent, History history);

    void processDrawing(MouseEvent mouseEvent, History history);

    void endDrawing(MouseEvent mouseEvent, History history);

}

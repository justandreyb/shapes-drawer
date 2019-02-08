module drawer.ui {
    requires drawer.logic;

    requires javafx.controls;
    requires javafx.fxml;

    opens by.bsuir.drawer.ui to javafx.fxml;

    exports by.bsuir.drawer.ui;
}

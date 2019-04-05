module drawer.ui {
    requires drawer.logic;
    requires drawer.model;

    requires javafx.controls;
    requires javafx.fxml;

    exports by.bsuir.drawer.ui;

    opens by.bsuir.drawer.plugin.shape.ellipse to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.square to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.rectangle to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.dot to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.line to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.circle to com.fasterxml.jackson.databind;
    opens by.bsuir.drawer.plugin.shape.triangle to com.fasterxml.jackson.databind;
}

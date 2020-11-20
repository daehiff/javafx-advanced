module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx to javafx.fxml;
    opens org.openjfx.viewController to javafx.fxml;
    exports org.openjfx;
    exports org.openjfx.viewController;
}
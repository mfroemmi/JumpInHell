module com.example.jumpinhell {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires javafx.media;


    opens com.example.jumpinhell to javafx.fxml;
    exports com.example.jumpinhell;
    exports com.example.jumpinhell.actions;
    opens com.example.jumpinhell.actions to javafx.fxml;
}
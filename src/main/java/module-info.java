module com.example.tetr1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tetr1 to javafx.fxml;
    exports com.example.tetr1;
    exports com.example.tetr1.templates;
    opens com.example.tetr1.templates to javafx.fxml;
}
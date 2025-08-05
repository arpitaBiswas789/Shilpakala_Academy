module com.example.shilpokalaac {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shilpokalaac to javafx.fxml;
    exports com.example.shilpokalaac;
}
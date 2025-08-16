module com.example.shilpokalaac {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shilpokalaac to javafx.fxml;
    opens com.example.shilpokalaac.Art_Instructor to javafx.fxml, javafx.base ;
    opens  com.example.shilpokalaac.Marketing_Manager to javafx.fxml, javafx.base ;

    exports com.example.shilpokalaac;
}
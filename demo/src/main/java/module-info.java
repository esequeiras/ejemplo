module com.cenfo.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.cenfo.demo.vista;
    opens com.cenfo.demo.vista to javafx.fxml;
    exports com.cenfo.demo.controlador;
    opens com.cenfo.demo.controlador to javafx.fxml;
    exports com.cenfo.demo;
    opens com.cenfo.demo to javafx.fxml;
}
module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.calculatorfinal to javafx.fxml;
    exports org.example.calculatorfinal;

    opens org.example.minetmaxfinal to javafx.fxml;
    exports org.example.minetmaxfinal;

    opens org.example.stringmanipulationfinal to javafx.fxml;
    exports org.example.stringmanipulationfinal;
}

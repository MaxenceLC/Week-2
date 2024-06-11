// module-info.java
module org.example.week2ui {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.week2ui to javafx.fxml;
    exports org.example.week2ui;
}

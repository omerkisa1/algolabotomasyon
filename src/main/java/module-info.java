module com.example.otomasyon {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.otomasyon to javafx.fxml;
    exports com.example.otomasyon;
}
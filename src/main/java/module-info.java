module ch.teko.oop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ch.teko.oop to javafx.fxml;
    exports ch.teko.oop;
}
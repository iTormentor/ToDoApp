module no.ntnu.idata1002 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.logging;

    opens no.ntnu.idata1002 to javafx.fxml;
    exports no.ntnu.idata1002;
}
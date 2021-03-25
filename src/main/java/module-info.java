module no.ntnu.idata1002 {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.idata1002 to javafx.fxml;
    exports no.ntnu.idata1002;
}
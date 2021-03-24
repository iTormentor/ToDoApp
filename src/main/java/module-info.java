module idata1002.todolist {
    requires javafx.graphics;
    requires javafx.controls;
    opens idata1002.todolist.fxml to javafx.fxml;
    exports idata1002.todolist;
}
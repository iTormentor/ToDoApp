<<<<<<< HEAD
module no.ntnu.idata1002 {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.idata1002 to javafx.fxml;
    exports no.ntnu.idata1002;
=======
module idata1002.todolist {
    requires javafx.graphics;
    requires javafx.controls;
    opens idata1002.todolist.fxml to javafx.fxml;
    exports idata1002.todolist;
>>>>>>> 84a92a926fca834b4df9e20fcc42f948c42d649e
}
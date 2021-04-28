package no.ntnu.idata1002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class SecondaryController implements Initializable{

    private IssueBoard issueBoard;
    private ObservableList<Task> todoTasksObs;
    private ObservableList<Task> doingTasksObs;
    private ObservableList<Task> doneTasksObs;

    @FXML
    private ListView<Task> todoListView;

    @FXML
    private ListView<Task> doingListView;

    @FXML
    private ListView<Task> doneListView;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.todoTasksObs = FXCollections.observableArrayList(this.issueBoard.getTodoTasks());
        this.doingTasksObs = FXCollections.observableArrayList(this.issueBoard.getOngoingTasks());
        this.doneTasksObs = FXCollections.observableArrayList(this.issueBoard.getFinishedTasks());

        this.doingListView.setItems(this.doingTasksObs);
        this.todoListView.setItems(this.todoTasksObs);
        this.doneListView.setItems(this.doneTasksObs);



    }

    @FXML
    public void doAddTask(ActionEvent actionEvent) {
        TaskDialog taskDialog = new TaskDialog();
        Optional<Task> result = taskDialog.showAndWait();

        if (result.isPresent()) {
            Task task = result.get();
            this.issueBoard.addTask(task);
            this.updateLists();
        }
    }

    private void updateLists() {
        this.todoTasksObs.setAll(this.issueBoard.getTodoTasks());
        this.doingTasksObs.setAll(this.issueBoard.getOngoingTasks());
        this.doneTasksObs.setAll(this.issueBoard.getFinishedTasks());
    }
}

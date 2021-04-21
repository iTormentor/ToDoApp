package no.ntnu.idata1002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private IssueBoard issueBoard;
    private ObservableList<Task> todoTasksObsList;
    private ObservableList<Task> doingTasksObsList;
    private ObservableList<Task> doneTasksObsList;

    @FXML
    private ListView<Task> todoListView;

    @FXML
    private ListView<Task> doingListView;

    @FXML
    private ListView<Task> doneListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.todoTasksObsList = FXCollections.observableArrayList(this.issueBoard.getTodoTasks());
        this.doingTasksObsList = FXCollections.observableArrayList(this.issueBoard.getOngoingTasks());
        this.doneTasksObsList = FXCollections.observableArrayList(this.issueBoard.getFinishedTasks());

        this.doingListView.setItems(this.doingTasksObsList);
        this.todoListView.setItems(this.todoTasksObsList);
        this.doneListView.setItems(this.doneTasksObsList);

        // Attach action listener
        // Add listener for double click on row
//        this.todoListView.setOnMousePressed(mouseEvent -> {
//            if (mouseEvent.isPrimaryButtonDown() && (mouseEvent.getClickCount() == 2)) {
//                this.(null);
//            }
//        });

    }

    public void doViewDetails(ActionEvent actionEvent) {
        Task highlightedTask =
                this.todoListView.getSelectionModel().getSelectedItem();
        if (highlightedTask == null) {
            System.out.println("Please select an item");
        } else {

            if (highlightedTask instanceof Task) {
 //               Task highlightedTask = (Task) highlightedTask;
                TaskDialog taskDialog = new TaskDialog(highlightedTask, false);
                taskDialog.showAndWait();
            }
        }
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
        this.todoTasksObsList.setAll(this.issueBoard.getTodoTasks());
        this.doingTasksObsList.setAll(this.issueBoard.getOngoingTasks());
        this.doneTasksObsList.setAll(this.issueBoard.getFinishedTasks());
    }
}


package no.ntnu.idata1002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private IssueBoard issueBoard;
    private ObservableList todoTasksObsList=FXCollections.observableArrayList();
    private ObservableList doingTasksObsList=FXCollections.observableArrayList();
    private ObservableList doneTasksObsList =FXCollections.observableArrayList();



    @FXML
    private ListView<Task> todoListView = new ListView<>();

    @FXML
    private ListView<Task> doingListView = new ListView<>();

    @FXML
    private ListView<Task> doneListView = new ListView<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         //Create the business logic by creating an instance of
         //LiteratureRegister and filling it with dummy data.
        this.issueBoard = new IssueBoard("My TODO-APP");
        this.todoTasksObsList.addAll(issueBoard.getTodoTasks());
        this.doingTasksObsList.addAll(issueBoard.getOngoingTasks());
        this.doneTasksObsList.addAll(issueBoard.getFinishedTasks());
        issueBoard.addTask(new Task("Room", "", "Medium", 1));

        this.todoTasksObsList = FXCollections.observableArrayList(this.issueBoard.getTodoTasks());
        this.doingTasksObsList = FXCollections.observableArrayList(this.issueBoard.getOngoingTasks());
        this.doneTasksObsList = FXCollections.observableArrayList(this.issueBoard.getFinishedTasks());

        updateLists();
    }

    public void doViewDetails(ActionEvent actionEvent) {
        Task highlightedTask =
                this.todoListView.getSelectionModel().getSelectedItem();
        if (highlightedTask == null) {
            showPleaseSelectItemDialog();
        } else {
                TaskDialog taskDialog = new TaskDialog(highlightedTask, false);
                taskDialog.showAndWait();
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


    //TODO Check if If-sentence is correct. Add remove method where appropriate.
    @FXML
    public void doRemoveTask(ActionEvent actionEvent) {
        Task highlightedTask = this.todoListView.getSelectionModel().getSelectedItem();
        if (highlightedTask == null) {
            highlightedTask = this.doingListView.getSelectionModel().getSelectedItem();
            if (highlightedTask == null) {
                highlightedTask = this.doneListView.getSelectionModel().getSelectedItem();
                if (highlightedTask == null) {
                    showPleaseSelectItemDialog();
                }
            }
        }
        if(!(highlightedTask==null)) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete task");
            alert.setHeaderText("This will completely remove the chosen task");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                issueBoard.removeTask(highlightedTask);
                updateLists();
            }


        }

    }



    private void updateLists() {
        this.todoTasksObsList.setAll(this.issueBoard.getTodoTasks());
        this.doingTasksObsList.setAll(this.issueBoard.getOngoingTasks());
        this.doneTasksObsList.setAll(this.issueBoard.getFinishedTasks());
        this.todoListView.getItems().clear();
        this.doingListView.getItems().clear();
        this.doneListView.getItems().clear();
        this.todoListView.getItems().addAll(this.todoTasksObsList);
        this.doingListView.getItems().addAll(this.doingTasksObsList);
        this.doneListView.getItems().addAll(this.doneTasksObsList);
    }


    /**
     * Displays a warning informing the user that an item must be selected from
     * the table.
     */
    private void showPleaseSelectItemDialog() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setHeaderText("No items selected");
        alert.setContentText("No item is selected from the table.\n"
                + "Please select an item from the table.");

        alert.showAndWait();
    }

}


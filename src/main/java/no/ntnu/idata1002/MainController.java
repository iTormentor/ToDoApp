package no.ntnu.idata1002;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

        this.issueBoard = new IssueBoard("My TODO-APP");
        this.issueBoard.addTask(new Task("asd","asda","asda",1));

        todoTasksObsList.addAll(this.issueBoard.getTodoTasks());
        doingTasksObsList.addAll(this.issueBoard.getOngoingTasks());
        doneTasksObsList.addAll(this.issueBoard.getFinishedTasks());

        todoListView.getItems().addAll(todoTasksObsList);
        doingListView.getItems().addAll(doingTasksObsList);
        doneListView.getItems().addAll(doneTasksObsList);
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
        Task highlightedToDoTask = this.todoListView.getSelectionModel().getSelectedItem();
        if (highlightedToDoTask == null) {
            Task highlightedTask1 = this.doingListView.getSelectionModel().getSelectedItem();
            if (highlightedTask1 == null) {
                Task highlightedFinishedTask = this.doneListView.getSelectionModel().getSelectedItem();
                if (highlightedFinishedTask == null) {
                    showPleaseSelectItemDialog();
                }
            }
        }

    }

    /**
     * Edit the selected task.
     *
     * @param actionEvent the event triggering the action
     *                    TODO: Lag edit task methode. Under er eksempelkode som Arne har laget. Den vil være lik den, men forskjellen er at vi har 3 lister.
     *
     */

    public void doEditTask(ActionEvent actionEvent) {

    }
//    public void editLiterature(ActionEvent actionEvent) {
//        Literature selectedLiterature =
//                this.literatureTableView.getSelectionModel().getSelectedItem();
//
//        if (selectedLiterature == null) {
//            showPleaseSelectItemDialog();
//        } else {
//            if (selectedLiterature instanceof Newspaper) {
//                Newspaper selectedNewspaper = (Newspaper) selectedLiterature;
//                NewspaperDetailsDialog npDialog = new NewspaperDetailsDialog(selectedNewspaper, true);
//                npDialog.showAndWait();
//
//                this.updateObservableLitReg();
//            }
//        }
//    }

    private void updateLists() {
        this.todoTasksObsList.setAll(this.issueBoard.getTodoTasks());
        this.doingTasksObsList.setAll(this.issueBoard.getOngoingTasks());
        this.doneTasksObsList.setAll(this.issueBoard.getFinishedTasks());
        this.todoListView.refresh();
        this.doingListView.refresh();
        this.doneListView.refresh();
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


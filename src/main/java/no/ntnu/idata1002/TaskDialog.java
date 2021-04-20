package no.ntnu.idata1002;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idata1002.Task;
import no.ntnu.idata1002.Project;

import java.io.IOException;

public class TaskDialog extends Dialog<Task> {

    public enum Mode {
        NEW,EDIT,VIEW
    }


    //Field for mode that can be put into new, edit or info.
    private final Mode mode;

    //creates and existing task object that can be viewed or edited.
    private  Task existingTask = null;


    public TaskDialog() {
        super();
        this.mode = Mode.NEW;
        createStuff();

    }

    public TaskDialog(Task task,boolean edit) {
        super();
        if (edit == true) {
            this.mode = Mode.EDIT;
        } else {
            this.mode = Mode.VIEW;
        }

        this.existingTask = task;
        createStuff();
    }

    private void createStuff() {
        setTitle("Task");
        Task task = new Task("blabla","hei","sup",1,"liten");


        //Add exit button if in view only and exit and OK if in edit or add.
        if (mode == Mode.VIEW) {
            getDialogPane().getButtonTypes().add(ButtonType.OK);
        } else {
            getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE, ButtonType.OK);
        }

        //Create the grid base.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField timeLeftField = new TextField();
        timeLeftField.setPromptText("Time left");
        timeLeftField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                // The user have entered a non-integer character, hence just keep the
                // oldValue and ignore the newValue.
                timeLeftField.setText(oldValue);
            }
        });

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Description");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        TextField priorityField = new TextField();
        priorityField.setPromptText("Priority");

        //If edit button or view is clicked, set fields to current task values.
        if ((mode == Mode.EDIT) || mode == Mode.VIEW) {
            nameField.setText(existingTask.getTaskName());
            descriptionField.setText(existingTask.getDescription());
            categoryField.setText(existingTask.getCategory());
            priorityField.setText(existingTask.getPriority());
            timeLeftField.setText(Integer.toString(existingTask.getTimeLeft()));



            //Make fields uneditable if in view only mode.
            if (mode == Mode.VIEW) {
                nameField.setEditable(false);
                descriptionField.setEditable(false);
                categoryField.setEditable(false);
                priorityField.setEditable(false);
                timeLeftField.setEditable(false);
            }

        }

        //Put the values into grid.
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(descriptionField, 1, 1);
        grid.add(new Label("Priority:"), 0, 2);
        grid.add(priorityField, 1, 2);
        grid.add(new Label("Category"), 0, 3);
        grid.add(categoryField, 1, 3);
        grid.add(new Label("Time left:"),0,4);
        grid.add(timeLeftField,1,4);

        //Add the grid to the dialog.
        getDialogPane().setContent(grid);

    setResultConverter((ButtonType button) -> {
    Task result = null;
    if (button == ButtonType.OK) {
        int timeLeft = Integer.parseInt(timeLeftField.getText());

        if (mode == Mode.NEW) {
            result = new Task(categoryField.getText(),nameField.getText(),descriptionField.getText(),timeLeft,priorityField.getText());

        } else if (mode == Mode.EDIT){
            existingTask.setCategory(categoryField.getText());
            existingTask.setDescription(descriptionField.getText());
            existingTask.setName(nameField.getText());
            existingTask.setTimeLeft(timeLeft);
            existingTask.setPriority(priorityField.getText());
            result = existingTask;


        }
    }
    return result;
    }
    );
    }

//    //TODO:Catch exception
//    private void createStuff() throws IOException {
//        //Add cancel and OK button
//        getDialogPanes();
//        getDialogPane().getButtonTypes().addAll(ButtonType.OK,ButtonType.CLOSE);
//
//
//
//        //Add data if editable
//        if ((mode == Mode.EDIT) || (mode == Mode.VIEW)) {
//
//
//        }
//    }
//
//    private void getDialogPanes() throws IOException {
//
//        final FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskDialog.fxml"));
// //           getDialogPane(root);
//        Parent root = loader.load();
//        Scene scene = new Scene(root,250,150);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.showAndWait();
//
////            primaryStage.setTitle("Poker Game");
////            primaryStage.setScene(new Scene(root, 600, 300));
////            primaryStage.show();
//
//
//        }
//    }
}




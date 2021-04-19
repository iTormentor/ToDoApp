package no.ntnu.idata1002;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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

        return result;
    }

    private void makeContent() {
        setTitle("Task");

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

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Description");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        TextField priorityField = new TextField();
        priorityField.setPromptText("Priority");

        if ((mode == Mode.EDIT) || mode == Mode.VIEW) {
            nameField.setText(existingTask.getTaskName());
            descriptionField.setText(existingTask.getDescription());
            categoryField.setText(existingTask.getCategory());
            priorityField.setText(existingTask.get);
        }

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




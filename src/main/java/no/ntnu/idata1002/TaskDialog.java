package no.ntnu.idata1002;

import javafx.event.ActionEvent;
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
import java.util.Date;


/**
 * Responsible for the Task Dialog window that occurs
 * when you press, New task, Edit Task or View Task
 */
public class TaskDialog extends Dialog<Task> {

    /**
     * Used to distinguish which button press that was made
     */
    public enum Mode {
        NEW, EDIT, VIEW
    }


    //Mode that can be new, edit or view.
    private final Mode mode;

    //Creates a task that can be added or edited or viewed.
    private Task existingTask = null;

    //Constructor for dialog when in new mode.
    public TaskDialog() {
        super();
        this.mode = Mode.NEW;
        createStuff();

    }

    //Constructor for dialog when in edit or view mode.
    public TaskDialog(Task task, boolean edit) {
        super();
        if (edit) {
            this.mode = Mode.EDIT;
        } else {
            this.mode = Mode.VIEW;
        }

        this.existingTask = task;
        createStuff();
    }

    //Creates the content for the dialog and adds, edits or views a task.
    private void createStuff() {
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
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Description");

        TextField yearField = new TextField();
        yearField.setPromptText("Year");
        yearField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                //Ignores new value if not an integer
                yearField.setText(oldValue);
            }
        });

        TextField monthField = new TextField();
        monthField.setPromptText("Month");
        monthField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                //Ignores new value if not an integer
                monthField.setText(oldValue);
            }
        });

        TextField dayField = new TextField();
        dayField.setPromptText("Day");
        dayField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if (newValue.length() > 0) {
                    Integer.parseInt(newValue);
                }
            } catch (NumberFormatException e) {
                //Ignores new value if not an integer
                dayField.setText(oldValue);
            }
        });

        TextField timeLeftField = new TextField();
        timeLeftField.setEditable(false);
        timeLeftField.setPromptText("Time left until deadline:");

        TextField deadLine = new TextField();
        deadLine.setPromptText("Deadline: ");


        TextField priorityField = new TextField();
        priorityField.setPromptText("Priority");

        //If edit button or view is clicked, set fields to current task values.
        if ((mode == Mode.EDIT) || mode == Mode.VIEW) {
            nameField.setText(existingTask.getTaskName());
            descriptionField.setText(existingTask.getDescription());
            priorityField.setText(existingTask.getPriority());
            existingTask.updateTimeLeft();
            timeLeftField.setText(Long.toString(existingTask.getTimeLeft()));
            yearField.setText(Integer.toString(existingTask.getYear()));
            monthField.setText(Integer.toString(existingTask.getMonth()));
            dayField.setText(Integer.toString(existingTask.getDay()));


            //Make fields uneditable if in view only mode.
            if (mode == Mode.VIEW) {
                nameField.setEditable(false);
                descriptionField.setEditable(false);
                priorityField.setEditable(false);
                yearField.setEditable(false);
                monthField.setEditable(false);
                dayField.setEditable(false);
            }

        }

        //Put the values into grid.
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(descriptionField, 1, 1);
        grid.add(new Label("Priority:"), 0, 2);
        grid.add(priorityField, 1, 2);
        grid.add(new Label("Time left:"), 0, 3);
        grid.add(new Label("days left to deadline"),2,3);
        grid.add(timeLeftField, 1, 3);
        grid.add(new Label("Deadline:"), 0, 4);
        grid.addRow(5, dayField, monthField, yearField);


        //Add the grid to the dialog.
        getDialogPane().setContent(grid);


        //Converts the task to new task if in new, and updates the fields if in edit.
        setResultConverter((ButtonType button) -> {
                    Task result = null;
                    if (button == ButtonType.OK) {
                        if ((yearField.getText() == "") || (monthField.getText() == "") || (dayField.getText() == ""))
                         {
                            yearField.setText("0");
                            monthField.setText("0");
                            dayField.setText("0");
                        }
                        if (mode == Mode.NEW) {

                            int year;
                            int month;
                            int day;

                            try {
                                year = Integer.parseInt(yearField.getText());
                                month = Integer.parseInt(monthField.getText());
                                day = Integer.parseInt(dayField.getText());
                            }
                            catch (NumberFormatException e) {
                                year = 0;
                                month = 0;
                                day = 0;
                            }


                                result = new Task(nameField.getText(), descriptionField.getText(), priorityField.getText(),
                                        year, month, day);



                        } else if (mode == Mode.EDIT) {
                            existingTask.setDescription(descriptionField.getText());
                            existingTask.setTaskName(nameField.getText());
                            existingTask.setPriority(priorityField.getText());
                            existingTask.setDeadLine(Integer.parseInt(yearField.getText()), Integer.parseInt(monthField.getText()),
                                    Integer.parseInt(dayField.getText()));
                            existingTask.updateTimeLeft();
                            result = existingTask;


                        }
                    }
                    return result;
                }
        );


    }
}



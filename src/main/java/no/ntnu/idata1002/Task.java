package no.ntnu.idata1002;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * Represent a task to be executed. The task has a name, timeleft
 * a description and a status indicating if done or not.
 */

public class Task {

    private String taskName; // The name of task
    private String description; //Description of task
    private String priority;
    private LocalDate deadLine; // How much time left to do task
    private long timeLeft = 0;

    private boolean done;


    /**
     * Creates an instance of TodoTask.
     * Note how mutator-methods are used to set the fields instead
     * of setting the fields directly.
     * @param taskName   the name of the task
     * @param description a more detailed description of the task
    //     * @param year year of the deadline
    //     * @param month month of the deadline
    //     * @param day day of the month, of the deadline
     */
    public Task(String taskName, String description, String priority, int year,int month, int day) {
        setTaskName(taskName);
        setDescription(description);
        setPriority(priority);
        this.done = false;
        setDeadLine(year, month, day);

    }

    /**
     * Default constructor. Creates an instance of Task.
     * Sets the fields to empty strings to avoid NullPointerException.
     */
    public Task() {
        //this.setCategory(""); -- Category moved to Project
        this.setTaskName("Unnamed task");
        this.setDescription("");
        this.deadLine = LocalDate.now();
        this.done = false;
        updateTimeLeft();

    }

    /**
     * Returns the name of task.
     *
     * @return the name of task
     */
    public String getTaskName() {
        return taskName;
    }
    /**
     * Returns the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * Returns days left until deadline
     *
     * @return The amount of days left to finish the task
     */
    public long getTimeLeft() {
        return deadLine.until(LocalDate.now(), ChronoUnit.DAYS);
    }
    public String getTimeLeftUntilDeadline() {
        return deadLine.toString();
    }

    /**
     * Sets new deadline for a task
     *
     * @param year year of the deadline
     * @param month month of the deadline
     * @param day day of the month, of the deadline
     */
    public void setDeadLine(int year, int month, int day) {
        try {
            deadLine = LocalDate.of(year, month, day);
        } catch (Exception e){
            deadLine = LocalDate.now();
        }
    }

    /**
     * Updates time left
     *
     */

    public void updateTimeLeft() {
        timeLeft = getTimeLeft();
    }

    /**
     * Sets the task name
     *
     * @param taskName the name of task
     */
    public void setTaskName(String taskName) {
        try {
            if(taskName.equals("")) {
                this.taskName = "Unnamed task";
            } else {
                this.taskName = taskName;
            }
        } catch(Exception e) {
            this.taskName = "Unnamed task";
        }
    }

    /**
     * Sets the description.
     *
     * @param description the description of the task
     */
    public void setDescription(String description) {
        try {
            this.description = description;
        } catch (Exception e) {
            this.description = "";
        }
    }

    /**
     * Sets the priority.
     *
     * @param priority the description of the task
     */
    public void setPriority(String priority) {
        try {
            this.priority = priority;
        } catch(Exception e) {
            this.priority = "";
        }
    }

    /**
     * Returns <code>true</code> if the task has been done.
     *
     * @return <code>true</code> if the task has been done.
     */
    public boolean isDone() {
        return this.done;
    }

    @Override
    public String toString(){
        return this.taskName;
    }

    public int getYear() {
        return deadLine.getYear();
    }


    public int getMonth() {
        return deadLine.getMonthValue();
    }

    public int getDay() {
        return deadLine.getDayOfMonth();
    }

    public String getPriority() {
        return this.priority;
    }
}

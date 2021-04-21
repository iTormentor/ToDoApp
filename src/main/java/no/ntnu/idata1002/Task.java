package no.ntnu.idata1002;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represent a task to be executed. The task has a name, timeLeft
 * a description and a status indicating if done or not.
 */

public class Task {

    //private String category; //Category of the task  ---Category moved to Project
    private String taskName; // The name of task
    private String description; //Description of task
    private String priority;
    //private LocalDate deadLine; // How much time left to do task
    private int timeLeft;

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
    public Task(String taskName, String description,String priority, int timeLeft) {
        //this.category = category; ---Category moved to Project
        this.taskName = taskName;
        this.description = description;
        this.priority = priority;
        this.timeLeft = timeLeft;
        //this.deadLine = LocalDate.of(year, month, day);
        this.done = false;
    }

    /**
     * Default constructor. Creates an instance of Task.
     * Sets the fields to empty strings to avoid NullPointerException.
     */
    public Task() {
        //this.setCategory(""); -- Category moved to Project
        this.setTaskName("");
        this.setDescription("");
        this.setTimeLeft(0);
        //this.deadLine = LocalDate.now();
        this.done = false;

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

    public int getTimeLeft() { return timeLeft;}

/**
 * Returns the category of class.
 *
 * @return the category
 */
    /*public String getCategory() {
        return category;
    }*/ // -- Category moved to Project

//    /**
//     * Returns days left until deadline
//     *
//     * @return The amount of days left to finish the task
//     */
//    public long getTimeLeft() {
//        return deadLine.until(LocalDate.now(), ChronoUnit.DAYS);
//    }

//    /**
//     * Sets new deadline for a task
//     *
//     * @param year year of the deadline
//     * @param month month of the deadline
//     * @param day day of the month, of the deadline
//     */
//    public void setDeadLine(int year, int month, int day) {
//        if(year == 0 || month == 0 || day == 0){
//            throw new IllegalArgumentException("Parameter of deadLine cannot be null");
//        }
//        this.deadLine = LocalDate.of(year, month, day);
//    }

    /**
     * Set time left
     *
     * @param timeLeft
     */

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /**
     * Sets the task name
     *
     * @param taskName the name of task
     */
    public void setTaskName(String taskName) {
        if (null == taskName) {
            throw new IllegalArgumentException("Parameter of task name cannot be null");
        }
        this.taskName = taskName;
    }

    /**
     * Sets the description.
     *
     * @param description the description of the task
     */
    public void setDescription(String description) {
        if (null == description) {
            throw new IllegalArgumentException("Parameter description cannot be null");
        }
        this.description = description;
    }

    /**
     * Sets the priority.
     *
     * @param priority the description of the task
     */
    public void setPriority(String priority) {
        if (null == priority) {
            throw new IllegalArgumentException("Parameter description cannot be null");
        }
        this.priority = priority;
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
    public String toString() {
        return this.taskName;
    }

    public String getPriority() {
        return this.priority;
    }
}

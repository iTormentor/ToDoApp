package no.ntnu.idata1002;

import java.time.LocalDate;

/**
 * Represent a task to be executed. The task has a name, timeleft
 * a description and a status indicating if done or not.
 */

public class Task {

    private String category; //Category of the task
    private String taskName; // The name of task
    private String description; //Description of task
    private String priority;
    private int timeLeft; // How much time left to do task
    private boolean done;


    /**
     * Creates an instance of TodoTask.
     * Note how mutator-methods are used to set the fields instead
     * of setting the fields directly.
     * @param category task category
     * @param taskName   the name of the task
     * @param description a more detailed description of the task
     * @param timeLeft how much time left to do task
     */
    public Task(String category,String taskName, String description, int timeLeft,String priority) {
        this.category = category;
        this.taskName = taskName;
        this.description = description;
        this.timeLeft = timeLeft;
        this.priority = priority;
        this.done = false;
    }

    /**
     * Default constructor. Creates an instance of Task.
     * Sets the fields to empty strings to avoid NullPointerException.
     */
    public Task() {
        this.setCategory("");
        this.setTaskName("");
        this.setDescription("");
        this.setTimeLeft("");

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
     * Returns the category of class.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the priority of class.
     *
     * @return the category
     */

    public String getPriority() { return priority;}

    /**
     * Returns timeleft to finish the task
     *
     * @return timeleft to finish the task
     */
    public int getTimeLeft() {
        return timeLeft;
    }

    /**
     * Sets timeleft
     *
     *  @param s timeleft
     */
    private void setTimeLeft(String s) {
        if(timeLeft == 0){
            throw new IllegalArgumentException("Parameter of timeleft cannot be null");
        }
        this.timeLeft = timeLeft;
    }

    /**
     * Sets the task name
     *
     * @param taskName the name of task
     */
    private void setTaskName(String taskName) {
        if (null == taskName) {
            throw new IllegalArgumentException("Parameter of task name cannot be null");
        }
        this.taskName = taskName;
    }

    private void setPriority(String priority) {
        if (null == priority) {
            throw new IllegalArgumentException("Parameter of task name cannot be null");
        }
        this.priority = priority;
    }

    /**
     * Sets the category.
     *
     * @param category the summary to be set
     */
    public void setCategory(String category) {
        if (null == category) {
            throw new IllegalArgumentException("Parameter category cannot be null");
        }
        this.category = category;
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
     * Returns <code>true</code> if the task has been done.
     *
     * @return <code>true</code> if the task has been done.
     */
    public boolean isDone() {
        return this.done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "category=" + category +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", timeLeft=" + timeLeft +
                ", done=" + done +
                '}';
    }
}

package no.ntnu.idata1002;

/**
 * A class which represents a SubTask of Task
 */
public class SubTask extends Task{


    /**
     * Contructor for Sub Task
     *
     * @param category the category of task
     * @param taskName the name of task
     * @param description the description of task
     * @param timeLeft timeleft to be finished
     */
    public SubTask(String category, String taskName, String description, int timeLeft, String priority) {
        super(category, taskName, description, timeLeft, priority);
    }
}

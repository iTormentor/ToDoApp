package no.ntnu.idata1002;

/**
 * A class which represents a SubTask of Task
 */
public class SubTask extends Task{

    public SubTask(String taskName, String description, String priority,int year, int month, int day) {
        super(taskName, description, priority, year,month,day);
    }

    /**
     * Contructor for Sub Task
     *
     * @param category the category of task
     * @param taskName the name of task
     * @param description the description of task
     * @param year year of the deadline
     * @param month month of the deadline
     * @param day day of the month, of the deadline
     */
//    public SubTask(String category, String taskName, String description, int year, int month, int day) {
//        super(category, taskName, description, year, month, day);
//    }
}

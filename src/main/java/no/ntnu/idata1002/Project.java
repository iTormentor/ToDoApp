package no.ntnu.idata1002;

import java.util.ArrayList;
import java.util.List;


/**
 * All existing projects should exist in the ToDoMain List over existing projects
 */
public class Project {

    private String projectName;
    private final List<Task> taskList;
    private boolean started = false;
    private boolean finished = false;


    /**
     * Constructor for Project.
     * Creates an empty list, that can be filled with Tasks
     *
     * @param name Name of the project as String
     */
    public Project(String name){
        this.projectName = name;
        taskList = new ArrayList<>();

    }

    /**
     * Changes the status of the started variable
     */
    public void setFinished(boolean status){
        this.finished = status;
    }

    /**
     * Changes the status of the finished variable
     */
    public void setStarted(boolean status){
        this.started = status;
    }


    /**
     * Changes the name of the project
     *
     * @param projectName Name of the project as String
     */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    /**
     * Returns the name of the project
     *
     * @return Name of the project as String
     */
    public String getProjectName(){
        return this.projectName;
    }

    /**
     * Returns the value of the variable finished
     *
     * @return boolean value of 'finished'
     */
    public boolean getFinished(){
        return this.finished;
    }

    /**
     * Returns the value of the variable started
     *
     * @return boolean value of started
     */
    public boolean getStarted(){
        return this.started;
    }

    /**
     * Returns the taskList
     *
     * @return The list contained in the 'tasks' variable
     */
    public List<Task> getTaskListTask(){
        return this.taskList;
    }

    /**
     * Adds a task to ArrayList taskList
     *
     * @param task The Task object to be added
     */
    public void addTask(Task task){
        taskList.add(task);
    }

    /**
     * Removes a task from the ArrayList taskList
     *
     * @param task The Task object to be removed
     */
    public void removeTask(Task task){
        taskList.remove(task);
    }
}

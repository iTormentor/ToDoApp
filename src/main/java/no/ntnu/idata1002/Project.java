package no.ntnu.idata1002;

import java.util.List;

public abstract class Project {

    private String projectName;
    private boolean started = false;
    private boolean finished = false;

    public Project(String projectName){
        this.projectName = projectName;

    }


    public abstract void addTask(Task task);

    public abstract void removeTask(Task task, List<Task> list);

    public abstract void removeTask(Task task);


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

    public abstract void moveTask(Task task, List<Task> oldList, List<Task> newList);
}


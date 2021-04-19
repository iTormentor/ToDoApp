package no.ntnu.idata1002;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleProject extends Project{

    private final List<Task> unfinishedTasks = new ArrayList<>();
    private final List<Task> finishedTasks = new ArrayList<>();

    public SimpleProject(String projectName) {
        super(projectName);
    }


    /**
     * Adds a task to ArrayList todoTasks
     *
     * @param task The Task object to be added
     */
    @Override
    public void addTask(Task task) {
        unfinishedTasks.add(task);
    }


    /**
     * Removes a task from the project.
     * Checks if the task exists in either of the lists
     * and removes it if found
     *
     * Throws NoSuchElementFoundException if no task is found
     *
     * @param task The Task object to be removed
     */
    @Override
    public void removeTask(Task task) {
        if (unfinishedTasks.contains(task)){
            unfinishedTasks.remove(task);
        } else if (finishedTasks.contains(task)) {
            finishedTasks.remove(task);
        } else {
            throw new NoSuchElementException("The task was not found in any of the lists");
        }
    }

    /**
     * Same as other method removeTask, but easier solution if you know the list
     *
     * @param task The task object to be removed
     * @param list The list that contains the task
     */
    @Override
    public void removeTask(Task task, List<Task> list) {
        list.remove(task);
    }

    /**
     * Returns the finishedTasks
     *
     * @return The list contained in the 'finishedTasks' variable
     */
    public List<Task> getFinishedTasks(){ return finishedTasks;}

    /**
     * Returns the unfinishedTasks
     *
     * @return The list contained in the 'unfinishedTasks' variable
     */
    public List<Task> getUnfinishedTasks(){ return unfinishedTasks;}

    /**
     * Moved a task, from one list, to another
     * @param task the task to be moved
     * @param oldList the old list of the task
     * @param newList the new list of the task
     * @throws IllegalArgumentException thrown if task == null
     */
    public void moveTask(Task task, List<Task> oldList, List<Task> newList) {
        if(!(null==task)) {
            oldList.remove(task);
            newList.add(task);
        } else throw new IllegalArgumentException("Task cannot be null");
    }
}



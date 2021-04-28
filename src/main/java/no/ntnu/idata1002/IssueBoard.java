package no.ntnu.idata1002;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;


/**
 * All existing projects should exist in the ToDoMain List over existing projects
 */
public class IssueBoard extends Project{


    private final List<Task> todoTasks = new ArrayList<>();
    private final List<Task> ongoingTasks = new ArrayList<>();
    private final List<Task> finishedTasks = new ArrayList<>();



    /**
     * Constructor for Project.
     * Creates three empty lists, that can be filled with Tasks
     *
     * @param projectName Name of the project as String
     */
    public IssueBoard(String projectName){
        super(projectName);
    }



    /**
     * Returns the todoTasks list
     *
     * @return The list contained in the 'todoTasks' variable
     */
    public List<Task> getTodoTasks(){
        return this.todoTasks;
    }


    /**
     * Returns the ongoingTasks
     *
     * @return The list contained in the 'ongoingTasks' variable
     */
    public List<Task> getOngoingTasks(){
        return this.ongoingTasks;
    }

    /**
     * Returns the finishedTasks
     *
     * @return The list contained in the 'finishedTasks' variable
     */
    public List<Task> getFinishedTasks(){
        return this.finishedTasks;
    }


    /**
     * Adds a task to ArrayList todoTasks
     *
     * @param task The Task object to be added
     */
    @Override
    public void addTask(Task task){
        todoTasks.add(task);
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
        if (todoTasks.contains(task)){
            todoTasks.remove(task);
        } else if (ongoingTasks.contains(task)){
            ongoingTasks.remove(task);
        } else if (finishedTasks.contains(task)){
            finishedTasks.remove(task);
        } else {
            throw new NoSuchElementException("The task was not found in any of the lists");
        }
    }

    /**
     * Same as other removeTask, but easier if you know the list
     *
     * @param task The task object to be removed
     * @param list The list that contains the task
     */
    @Override
    public void removeTask(Task task, List<Task> list){
        list.remove(task);
    }

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

    /**
     * Finds the current list that contains the task.
     * @param task
     */
    public List<Task> getList(Task task) {
        List<Task> result = null;
        boolean foundTask = false;
        Iterator<Task> it = this.todoTasks.iterator();
        Iterator<Task> it2 = this.ongoingTasks.iterator();
        Iterator<Task> it3 = this.finishedTasks.iterator();

        while (it.hasNext() && !foundTask) {
        Task nxt = it.next();
        if (nxt.getTaskName().equalsIgnoreCase(task.getTaskName())) {
            foundTask = true;
            result = todoTasks;
        }
        }

        while (it2.hasNext() && !foundTask) {
            Task nxt = it.next();
            if (nxt.getTaskName().equals( task.getTaskName())) {
                foundTask = true;
                result = ongoingTasks;
            }
        }

        while (it3.hasNext() && !foundTask) {
            Task nxt = it.next();
            if (nxt.getTaskName().equals(task.getTaskName())) {
                foundTask = true;
                result = finishedTasks;
            }
        }

        return result;
    }
}

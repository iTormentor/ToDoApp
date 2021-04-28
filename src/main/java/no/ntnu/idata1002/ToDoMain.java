package no.ntnu.idata1002;

import java.util.ArrayList;
import java.util.List;

public class ToDoMain {

    private final List<Project> projectList;

    /**
     * Creates a List that can be filled with projects
     */
    public ToDoMain(){
        projectList = new ArrayList<>();
    }


    /**
     * Fills up the application with various information.
     * For testing purposes
     */
    //TODO Cant finish before the Task classes is finished
    public void fillWithDummies(){
        projectList.add(new IssueBoard("House-work"));
        projectList.add(new IssueBoard("Garden-work"));
        projectList.add(new SimpleProject("Grocery shopping"));
    }


    /**
     * Returns all the existing projects in a list
     *
     * @return projectList as ArrayList
     */
    public List<Project> getAllProjects(){
        return projectList;
    }

    /**
     * Checks all existing projects for their 'started' and 'finished' variable.
     * If started and not finished, they will be added to another list,
     * which will then be returned
     *
     * @return All projects with 'started' as true and 'finished' as false, in an ArrayList
     */
    public List<Project> listOngoingProjects(){
        List<Project> ongoingProjects = new ArrayList<>();
        for (Project project : projectList) {
            if(project.getStarted() && !project.getFinished()){
                ongoingProjects.add(project);
            }
        }
        return ongoingProjects;

    }

    /**
     * Checks all existing projects for their 'finished' variable.
     * If true, they will be added to another list, which will then
     * be returned
     *
     * @return All projects marked as
     */
    public List<Project> listFinishedProjects(){

        List<Project> doneProjects = new ArrayList<>();
        for (Project project : projectList) {
            if(project.getFinished()){
                doneProjects.add(project);
            }
        }

        return doneProjects;
    }


    /**
     * Checks all existing projects for their 'started' and 'finished' variable.
     * If both is false, they will be added to another list,
     * which will then be returned
     *
     * @return All projects with 'started' and 'finished' as false, in an ArrayList
     */
    public List<Project> listPlannedProjects(){
        List<Project> plannedProjects = new ArrayList<>();

        for (Project project : projectList) {
            if (!project.getStarted() && !project.getFinished()){
                plannedProjects.add(project);
            }
        }
        return plannedProjects;
    }

    /**
     * Adds an existing project to the list of all projects
     *
     * @param project The project to be added
     */
    public void addProject(Project project){

        projectList.add(project);
    }


    /**
     * Removes an existing project from the projectList
     * @param project The project to be removed
     */
    public void removeProject(IssueBoard project){
        projectList.remove(project);
    }
}

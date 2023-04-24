package org.clientproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskID;
    private int projectID;
    private String taskName;
    private String taskDesc;
    private String taskAssignee;
    private int taskPriority;
    private int taskStatus;
    private String taskNotes;
    private boolean deleted;

    // Bare minimum constructor.
    public TaskEntity(int taskID, int projectID, String taskName, String taskDesc) {
        this.taskID = taskID;
        this.projectID = projectID;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.deleted = false;
    }


    // Full constructor
    public TaskEntity(int taskID, int projectID, String taskName, String taskDesc, String taskAssignee, int taskPriority, int taskStatus, String taskNotes) {
        this.taskID = taskID;
        this.projectID = projectID;
        this.taskName = taskName;
        this.taskDesc = taskDesc;
        this.taskAssignee = taskAssignee;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.taskNotes = taskNotes;
        this.deleted = false; // Default to false. This is for security reasons. We want to retain tasks for future reference to avoid "the blame game".
    }


    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(String taskNotes) {
        this.taskNotes = taskNotes;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

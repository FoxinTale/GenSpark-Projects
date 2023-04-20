package org.example.Entity;

import jakarta.persistence.*;

import java.io.File;

@Entity
@Table(name="projects")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectID;
    private String projectName;
    private int clientID;
    private String projectDesc;
    private File projectContract;
    private String projectStatus;


    public ProjectEntity(int projectID, String projectName, int clientID, String projectDesc, File projectContract, String projectStatus) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.clientID = clientID;
        this.projectDesc = projectDesc;
        this.projectContract = projectContract;
        this.projectStatus = projectStatus;
    }


    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public File getProjectContract() {
        return projectContract;
    }

    public void setProjectContract(File projectContract) {
        this.projectContract = projectContract;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

}

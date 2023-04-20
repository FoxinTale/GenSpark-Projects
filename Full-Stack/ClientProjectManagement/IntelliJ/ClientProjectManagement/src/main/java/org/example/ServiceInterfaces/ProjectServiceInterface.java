package org.example.ServiceInterfaces;

import org.example.Entity.ProjectEntity;

import java.util.List;

public interface ProjectServiceInterface {

    List<ProjectEntity> getAllProjects();

    ProjectEntity getProjectByID(int projectID);

    ProjectEntity addProject(ProjectEntity project);

    ProjectEntity updateProject(ProjectEntity project);

    ProjectEntity deleteProjectByID(int projectID);

}

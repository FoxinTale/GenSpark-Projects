package org.clientproject.ServiceInterfaces;

import org.clientproject.Entity.ProjectEntity;

import java.util.List;

public interface ProjectServiceInterface {

    List<ProjectEntity> getAllProjects();

    ProjectEntity getProjectByID(int projectID);

    ProjectEntity addProject(ProjectEntity project);

    ProjectEntity updateProject(ProjectEntity project);

    String deleteProjectByID(int projectID);

}

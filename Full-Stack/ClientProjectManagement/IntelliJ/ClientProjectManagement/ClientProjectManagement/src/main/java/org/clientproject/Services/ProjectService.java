package org.clientproject.Services;

import org.clientproject.DAO.ProjectDAO;
import org.clientproject.Entity.ProjectEntity;
import org.clientproject.ServiceInterfaces.ProjectServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceInterface {
    private ProjectDAO projectDAO;
    private ProjectEntity projectEntity;

    @Override
    public List<ProjectEntity> getAllProjects() {
        return this.projectDAO.findAll();
    }

    @Override
    public ProjectEntity getProjectByID(int projectID) {
        Optional<ProjectEntity> projectList = this.projectDAO.findById(projectID);

        ProjectEntity projectEntity = null;

        if(projectList.isPresent()){
            projectEntity = projectList.get();
        } else {
            throw new RuntimeException("There is no Project found for id: " + projectID);
        }

        return projectEntity;
    }

    @Override
    public ProjectEntity addProject(ProjectEntity project) {
        return this.projectDAO.save(project);
    }

    @Override
    public ProjectEntity updateProject(ProjectEntity project) {
        return this.projectDAO.save(project);
    }

    @Override
    public String deleteProjectByID(int projectID) {
        this.projectDAO.deleteById(projectID);
        return "Project has been removed";
    }
}

package org.clientproject.ServiceInterfaces;

import org.clientproject.Entity.TaskEntity;

import java.util.List;

public interface TaskServiceInterface {
    List<TaskEntity> getAllTasks();

    TaskEntity getTaskByProjectID(int projectID);

    TaskEntity addTask(TaskEntity task);

    TaskEntity updateTask(TaskEntity task);

}

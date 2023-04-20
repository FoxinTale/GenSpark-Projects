package org.example.ServiceInterfaces;

import org.example.Entity.TaskEntity;
import org.example.Services.TaskService;

import java.util.List;

public interface TaskServiceInterface {
    List<TaskEntity> getAllTasks();

    TaskEntity getTaskByProjectID(int projectID);

    TaskEntity addTask(TaskEntity task);

    TaskEntity updateTask(TaskEntity task);

}

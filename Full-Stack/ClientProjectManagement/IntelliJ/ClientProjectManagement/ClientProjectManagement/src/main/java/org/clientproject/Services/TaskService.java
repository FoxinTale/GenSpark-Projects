package org.clientproject.Services;

import org.clientproject.DAO.TaskDAO;
import org.clientproject.Entity.TaskEntity;
import org.clientproject.ServiceInterfaces.TaskServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInterface {
    private TaskDAO taskDAO;
    private TaskEntity taskEntity;

    @Override
    public List<TaskEntity> getAllTasks() {
        return this.taskDAO.findAll();
    }

    @Override
    public TaskEntity getTaskByProjectID(int taskID) {
        Optional<TaskEntity> taskList = this.taskDAO.findById(taskID);
        TaskEntity taskEntity = null;

        if(taskList.isPresent()){
            taskEntity = taskList.get();
        } else {
            throw new RuntimeException("There is no Client found for id: " + taskID);
        }

        return taskEntity;
    }

    @Override
    public TaskEntity addTask(TaskEntity task) {
        return this.taskDAO.save(task);
    }

    @Override
    public TaskEntity updateTask(TaskEntity task) {
        return this.taskDAO.save(task);
    }

    // We do not have a "delete task" for this.
}

package service;

import dao.TaskDAO;
import model.Task;
import java.sql.SQLException;
import java.util.List;

public class TaskService {
    private TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void addTask(Task task) {
        try {
            taskDAO.addTask(task);
            System.out.println("Task added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void listTasks() {
        try {
            List<Task> tasks = taskDAO.getAllTasks();
            tasks.forEach(task -> System.out.println(task.getId() + ". " + task.getTitle() + " - " + task.getDescription()));
        } catch (SQLException e) {
            System.out.println("Error retrieving tasks: " + e.getMessage());
        }
    }

    public void completeTask(int id) {
        try {
            taskDAO.markTaskAsCompleted(id);
            System.out.println("Task marked as completed!");
        } catch (SQLException e) {
            System.out.println("Error completing task: " + e.getMessage());
        }
    }
}
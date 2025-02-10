package controller;

import model.Task;
import service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TaskController {
    private final TaskService taskService;
    private final Scanner scanner;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    taskService.listTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        LocalDateTime dueDate = LocalDateTime.now().plusDays(2);

        Task task = new Task(0, title, description, dueDate, false);
        taskService.addTask(task);
    }

    private void completeTask() {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = scanner.nextInt();
        taskService.completeTask(taskId);
    }
}
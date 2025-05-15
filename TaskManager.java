import java.util.*;

public class TaskManager {
    public ArrayList<Task> tasks;
    private Categories categories;

    public TaskManager() {
        tasks = new ArrayList<>();
        categories = new Categories();  
    }

    // method to add a task to the list
    // method now implements category class
    public void addTask(String taskDescription, String category) {
        Task newTask = new Task(taskDescription);
        tasks.add(newTask);
        categories.addTaskToCategory(category, newTask);
        System.out.println("Task added under category [" + category + "]: " + taskDescription);
    }
    

    // method to view all tasks
    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". [" + (task.isCompleted() ? "X" : " ") + "] " + task.getDescription());
        }
    }

    // method to mark a task as completed
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasksByCategory(String category) {
        categories.viewTasksByCategory(category);
    }

    public Set<String> getCategories() {
        return categories.getAllCategories();
    }

    // inner task class to represent a task with a description and completion status
    public static class Task {
        public String description;
        public boolean completed;

        public Task(String description) {
            this.description = description;
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

    
        }
    }

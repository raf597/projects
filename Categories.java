import java.util.*;

public class Categories {
    
    // map to store categories and their list of task
    public Map<String, ArrayList<TaskManager.Task>> categoryMap = new HashMap<>();

    public Categories() {
        categoryMap = new HashMap<>();

    }
    // add to specific category
    public void addTaskToCategory(String category, TaskManager.Task task) {
        categoryMap.putIfAbsent(category, new ArrayList<>());
        categoryMap.get(category).add(task);
    }

    // display all task in specific category
    public void viewTasksByCategory(String category) {
        if (!categoryMap.containsKey(category)) {
            System.out.println("No tasks found for category: " + category); 
            return;
        }

        ArrayList<TaskManager.Task> tasks = categoryMap.get(category);
        System.out.println("Tasks in category \"" + category + "\":" );

        // print each task with the status
        for (int i = 0; i < tasks.size(); i++) {
            TaskManager.Task task = tasks.get(i);
            System.out.println((i+1) + ". [" + (task.isCompleted() ? "X" : " ") + "] " + task.getDescription());
        }
}
        // return list of category names
    public Set<String> getAllCategories() {
            return categoryMap.keySet();
}
}
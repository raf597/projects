import java.util.*;

public class ToDoList {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

      TaskManager taskManager = new TaskManager();

        int choice;

        do { 
            System.out.println("To-Do List");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.println("5. View Tasks by Category");
            System.out.println("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: 
                System.out.print("Enter task description: ");
                String task = input.nextLine();
                System.out.print("Enter task category: ");
                String category = chooseCategory(input);
                taskManager.addTask(task, category);
                    break;
                case 2:
                    taskManager.viewTasks();
                    break;
                case 3:
                     System.out.print("Enter task number to mark complete: ");
                    int compTask = input.nextInt();
                    taskManager.markTaskCompleted(compTask - 1);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                    
                    // 5th case added to view tasks by category
                    case 5:

                    // get all category names from task manager
                    Set<String> categories = taskManager.getCategories();

                    // if no categories found, exit
                    if (categories.isEmpty()) {
                        System.out.println("No categories found.");
                        break;
                    }
                
                    System.out.println("Select a category to view:");
                    
                    // display each category with a number
                    int idx = 1;
                    List<String> categoryList = new ArrayList<>(categories);
                    for (String c : categoryList) {
                        System.out.println(idx + ". " + c);
                        idx++;
                    }
                    
                    // ask user to choose a category
                    System.out.print("Enter category number: ");
                    int catChoice = input.nextInt();
                    input.nextLine();  
                
                    if (catChoice < 1 || catChoice > categoryList.size()) {
                        System.out.println("Invalid category choice.");
                        break;
                    }
                
                    String chosenCategory = categoryList.get(catChoice - 1);
                    taskManager.viewTasksByCategory(chosenCategory);
                    break;
                
                default:
                    System.out.println("Invalid choice. Try again");

            }


        } while (choice != 4);

       }
       
       private static String chooseCategory(Scanner input) {
        String[] genericCategories = {"Work", "Home", "School", "Personal", "Exercise"};
        System.out.println("Choose a category or type a new one:");
    
        for (int i = 0; i < genericCategories.length; i++) {
            System.out.println((i + 1) + ". " + genericCategories[i]);
        }
        System.out.print("Enter number or type category name: ");
        String line = input.nextLine().trim();
    
        // Check if user entered a number for a generic category
        try {
            int choice = Integer.parseInt(line);
            if (choice >= 1 && choice <= genericCategories.length) {
                return genericCategories[choice - 1];
            }
        } catch (NumberFormatException e) {
            // Not a number so treat as a new category name below
        }
    
        // If not a valid number use input as new category name 
        if (!line.isEmpty()) {
            return line;
        } else {
            return "Uncategorized";
        }
    }
}

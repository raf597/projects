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
            System.out.println("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: 
                    System.out.print("Enter task description: ");
                    String task = input.nextLine();
                    taskManager.addTask(task);
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
                default:
                    System.out.println("Invalid choice. Try again");

            }


        } while (choice != 4);

       }
}

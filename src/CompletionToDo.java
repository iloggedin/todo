import java.util.Scanner;
public class CompletionToDo{
    private Scanner scan = new Scanner(System.in);
    private Boolean completed;
    public void check(){
        System.out.println("Please insert the task that has been completed");
        String taskCompleted = scan.nextLine();
        if(){
            completed = true;
            todos.remove(taskCompleted);
        } else {
            System.out.println("please enter a ToDo that's actually in the list: ");
            check();
        }
    }
}

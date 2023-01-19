import java.util.ArrayList;
import java.util.Scanner;

public class ToDoManager extends CompletionToDo {

    public ArrayList<String> todos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void add() {
        System.out.println("Type here what you want to add to your list: ");
        System.out.println("type \"quit\" if you want to quit and display the list");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("quit")){
                System.out.println(todos);
                Menu();
                break;
            }
            todos.add(input);
        }
    }

    public void display(){
        System.out.println(todos);
        Menu();
    }


    public void completed(){
        System.out.println("what task did you complete?");
        char answer = sc.next().charAt(0);
        if(answer == 'y'){
            Boolean done = true;

        }
    }

    public void Menu(){
        System.out.println("choose a number from one of the following things you want to do: \n1: Add\n2: Display\n3: Remove");
        int number = sc.nextInt();
        switch (number) {
            case 1 -> add();
            case 2 -> display();
            case 3 -> check();
        }

    }
}

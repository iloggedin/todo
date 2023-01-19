package me.iloggedin.todo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class TodoManager {
    public final HashMap<UUID, Todo> todos = new HashMap<>();

    public String promptText = "choose a number from one of the following things you want to do: \n0: Quit\n1: Add\n2: Display\n3: Check off";

    public String prompt(String message) {
        Scanner scanner = new Scanner(System.in);

        if (message != null)
            System.out.println(message);

        return scanner.nextLine();
    }

    public String prompt() {
        return this.prompt(null);
    }

    public boolean add() {
        System.out.println("Input new items, 'stop' to stop:");

        while (true) {
            String input = this.prompt();

            if (input.equalsIgnoreCase("stop")){
                return false;
            }

            var uuid = UUID.randomUUID();

            this.todos.put(uuid, new Todo(uuid, input));

            System.out.println("Added");
        }
    }

    public boolean list() {
        System.out.println("Todos:");

        for (Todo todo : this.todos.values()) {
            System.out.printf("Content=%s; Completed=%b\n", todo.getContent(), todo.isCompleted());
        }

        System.out.println();

        return false;
    }

    public boolean complete() {
        System.out.println("Choose an item to complete: ");

        String query = this.prompt();

        var found = this.todos.values().stream()
                .filter((todo) -> todo.getContent().equalsIgnoreCase(query))
                .map((todo) -> {
                    todo.setCompleted(true);
                    return todo.getUuid();
                })
                .toList();

        if (found.isEmpty()) {
            System.out.println("failed at finding matching items");
        } else {
            for (UUID uuid : found) {
                this.todos.remove(uuid);
            }
        }

        return false;
    }

    public void loop() {
        while (true) {
            var quit = true;
            var op = Integer.parseInt(this.prompt(this.promptText));

            switch (op) {
                case 0 -> quit = true;
                case 1 -> quit = this.add();
                case 2 -> quit = this.list();
                case 3 -> quit = this.complete();
                default -> quit = false;
            }

            if (quit)
                break;
        }
    }

    public void start() {
        this.loop();
    }
}

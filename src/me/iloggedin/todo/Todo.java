package me.iloggedin.todo;

import java.util.UUID;

public class Todo {
    private final UUID uuid;

    private String  content;
    private boolean completed;

    public Todo(UUID uuid, String content) {
        this.uuid      = uuid;
        this.content   = content;
        this.completed = false;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
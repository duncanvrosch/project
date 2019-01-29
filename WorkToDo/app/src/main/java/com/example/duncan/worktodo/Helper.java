package com.example.duncan.worktodo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Helper implements Serializable {

    String title, name, description, priority, timestamp;

    public Helper(String title, String name, String description, String priority, String timestamp) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() { return priority; }

    public String getTimestamp() { return timestamp; }
}

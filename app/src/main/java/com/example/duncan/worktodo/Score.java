package com.example.duncan.worktodo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Score implements Serializable {

    String title, description, priority, timestamp;

    public Score(String title, String description, String priority, String timestamp) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

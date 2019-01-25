package com.example.duncan.worktodo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {

    String username, password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

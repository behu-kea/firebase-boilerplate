package com.example.firebase;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Classroom(List<User> users) {
        this.users = users;
    }
}

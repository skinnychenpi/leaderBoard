package com.example.test_leaderboard.entity;

import lombok.Data;

@Data
public class User {
    private int user_id;
    private String user_name;
    private String password;


    public int getUserId() {
        return user_id;
    }
    public String getUsername() {
        return user_name;
    }
}

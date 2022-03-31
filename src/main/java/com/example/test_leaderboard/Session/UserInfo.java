package com.example.test_leaderboard.Session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

public class UserInfo {
    private int user_id;
    private String user_name;

    public UserInfo(int id, String username) {
        this.user_id=id;
        this.user_name=username;
    }

    public int getUserId() {
        return user_id;
    }
    public String getUsername() {
        return user_name;
    }

}

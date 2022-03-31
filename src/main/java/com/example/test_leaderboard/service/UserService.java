package com.example.test_leaderboard.service;

import com.example.test_leaderboard.entity.Student;
import com.example.test_leaderboard.entity.User;

import java.util.List;

public interface UserService {
    public List<User> verifyUsernameAndPassword(String user_name, String password);
    public List<User> verifyUserExistence(String user_name);
    public void register(String user_name, String password);
}

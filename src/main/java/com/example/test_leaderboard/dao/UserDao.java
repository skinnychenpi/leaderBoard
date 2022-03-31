package com.example.test_leaderboard.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.test_leaderboard.entity.User;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> verifyUsernameAndPassword(String user_name, String password);
    public List<User> verifyUserExistence(String user_name);
    public void register(String user_name, String password);
}

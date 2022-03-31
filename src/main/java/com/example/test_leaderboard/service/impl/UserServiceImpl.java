package com.example.test_leaderboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test_leaderboard.dao.UserDao;
import com.example.test_leaderboard.entity.User;
import com.example.test_leaderboard.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> verifyUsernameAndPassword(String user_name, String password) {
        return userDao.verifyUsernameAndPassword(user_name,password);
    }

    @Override
    public List<User> verifyUserExistence(String user_name) {
        return userDao.verifyUserExistence(user_name);
    }

    @Override
    public void register(String user_name, String password) {
        userDao.register(user_name, password);
    }


}

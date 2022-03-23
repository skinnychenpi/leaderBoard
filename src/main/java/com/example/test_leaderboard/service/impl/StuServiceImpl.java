package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.dao.StuDao;
import com.example.test_leaderboard.entity.Student;
import com.example.test_leaderboard.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    public List<Student> selectStudent(String sql) {
        return stuDao.selectStudent(sql);
    }
}

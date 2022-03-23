package com.example.test_leaderboard.service;

import com.example.test_leaderboard.entity.Student;

import java.util.List;

public interface StuService {
    public List<Student> selectStudent(String sql);
}

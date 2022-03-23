package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuDao {
    // 这里参数的名字必须要写value
    public List<Student> selectStudent(String value);
}

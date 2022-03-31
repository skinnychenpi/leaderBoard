package com.example.test_leaderboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.test_leaderboard.entity.Problem;

@Mapper
public interface ProblemDao {
    Problem selectProblem(Integer problemNumber);
    List<Problem> showAllProblem();
}

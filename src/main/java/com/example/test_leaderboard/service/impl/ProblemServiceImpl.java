package com.example.test_leaderboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test_leaderboard.dao.ProblemDao;
import com.example.test_leaderboard.entity.Problem;
import com.example.test_leaderboard.service.ProblemService;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemDao problemDao;

    @Override
    public Problem selectProblem(Integer problemNumber) {
        return problemDao.selectProblem(problemNumber);
    }
}

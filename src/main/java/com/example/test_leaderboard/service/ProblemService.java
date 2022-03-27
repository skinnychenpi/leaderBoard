package com.example.test_leaderboard.service;

import com.example.test_leaderboard.entity.Problem;

public interface ProblemService {
    Problem selectProblem(Integer problemNumber);
}

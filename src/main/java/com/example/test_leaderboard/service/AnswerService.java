package com.example.test_leaderboard.service;

import java.util.List;

public interface AnswerService {
    public List<Object> answer(String sql, String userName, int problemNumber);
}

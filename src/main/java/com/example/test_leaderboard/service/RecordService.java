package com.example.test_leaderboard.service;

import java.util.Date;

public interface RecordService {
    public void record(String userName,
                       int problemNumber,
                       double timeCost,
                       long currentTime);
}

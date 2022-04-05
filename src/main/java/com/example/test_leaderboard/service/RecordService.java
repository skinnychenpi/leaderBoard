package com.example.test_leaderboard.service;

import com.example.test_leaderboard.entity.UserRecord;

import java.util.Date;
import java.util.List;

public interface RecordService {
    public void record(String userName,
                       int problemNumber,
                       double timeCost,
                       long currentTime);
    public List<UserRecord> userRecord (String userName,int problemNumber);
}

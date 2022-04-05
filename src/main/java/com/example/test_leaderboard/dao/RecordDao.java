package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.UserRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface RecordDao {
    public void record(String userName,
                       int problemNumber,
                       double timeCost,
                       long currentTime);
    public List<UserRecord> userRecord(String userName, int problemNumber);
}

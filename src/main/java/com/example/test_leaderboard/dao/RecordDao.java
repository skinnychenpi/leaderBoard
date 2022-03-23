package com.example.test_leaderboard.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
@Mapper
public interface RecordDao {
    public void record(String userName,
                       int problemNumber,
                       double timeCost,
                       long currentTime);
}

package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.dao.RecordDao;
import com.example.test_leaderboard.entity.UserRecord;
import com.example.test_leaderboard.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public void record(String userName,
                       int problemNumber,
                       double timeCost,
                       long currentTime){
        recordDao.record(userName,problemNumber,timeCost,currentTime);
    }

    @Override
    public List<UserRecord> userRecord(String userName,int problemNumber){
        return recordDao.userRecord(userName,problemNumber);
    }
}

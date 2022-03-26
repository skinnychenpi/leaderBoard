package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.dao.JudgeDao;
import com.example.test_leaderboard.dao.StuDao;
import com.example.test_leaderboard.entity.Judge;
import com.example.test_leaderboard.entity.Student;
import com.example.test_leaderboard.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JudgeServiceImpl implements JudgeService {
    @Autowired
    private JudgeDao judgeDao;

    @Override
    public boolean JudgeSQL(String sql, int problemNumber){
        List<Judge> judgeList = judgeDao.JudgeSQL(sql.substring(0,sql.length()-1),problemNumber);
        if(judgeList.size()==1)
            return true;
        else
            return false;
    }
}

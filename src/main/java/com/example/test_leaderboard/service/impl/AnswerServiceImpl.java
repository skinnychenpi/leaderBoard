package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.service.AnswerService;
import com.example.test_leaderboard.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private StuServiceImpl stuService;
    @Autowired
    private JudgeServiceImpl judgeService;
    @Autowired
    private ExplainServiceImpl explainService;
    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private RankServiceImpl rankService;

    @Override
    public List<Object> answer(String sql, String userName, int problemNumber){
        List<Object> res = new ArrayList<>();
        res.add(stuService.selectStudent(sql));//add sql outcome anyway
        if(judgeService.JudgeSQL(sql,problemNumber)){//if sql is correct
            res.add(explainService.explainSQL(sql));//add sql timecost
            recordService.record(
                    userName,
                    problemNumber,
                    explainService.explainSQL(sql),
                    System.currentTimeMillis()/1000);//record user info
            res.add(rankService.showUserRank(problemNumber,userName)); //add user rank
        }
        else{//if sql is wrong
            res.add("Wrong SQL");
        }
        return res;
    }
}

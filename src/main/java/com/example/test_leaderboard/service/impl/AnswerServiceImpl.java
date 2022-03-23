package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.service.AnswerService;
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

    @Override
    public List<Object> answer(String sql, String userName, int problemNumber){
        List<Object> res = new ArrayList<>();
        res.add(stuService.selectStudent(sql));//sql outcome
        if(judgeService.JudgeSQL(sql,problemNumber)){
            res.add(explainService.explainSQL(sql));//sql timecost
            recordService.record(
                    userName,
                    problemNumber,
                    explainService.explainSQL(sql),
                    System.currentTimeMillis()/1000);//record
        }
        else{
            res.add("Wrong SQL");
        }
        return res;
    }
}

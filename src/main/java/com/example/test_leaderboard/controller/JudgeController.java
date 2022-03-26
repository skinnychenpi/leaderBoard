package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.service.JudgeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    @RequestMapping("/judge")
    public boolean judgeSQL(@Param("sql") String sql,@Param("problemNumber") int problemNumber){
        return judgeService.JudgeSQL(sql,problemNumber);
    }
}

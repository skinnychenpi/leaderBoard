package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.service.AnswerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/answer")
    public List<Object> Answer(@Param("sql") String sql,
                               @Param("userName") String userName,
                               @Param("problemNumber") int problemNumber,
                               @Param("order") String order){
        return answerService.answer(sql,userName,problemNumber,order);
    }
}

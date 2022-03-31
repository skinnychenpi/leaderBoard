package com.example.test_leaderboard.controller;

import java.util.List;

import com.example.test_leaderboard.entity.Problem;
import com.example.test_leaderboard.service.ProblemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @RequestMapping(value = "/problem",method = RequestMethod.GET)
    public Problem selectStudent(@Param("problemNumber") Integer problemNumber){
        return problemService.selectProblem(problemNumber);
    }

    @RequestMapping(value = "/allProblem",method = RequestMethod.GET)
    public List<Problem> showAllProblem(){
        return problemService.showAllProblem();
    }
}

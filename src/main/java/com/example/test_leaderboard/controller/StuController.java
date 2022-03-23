package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.entity.Student;
import com.example.test_leaderboard.service.StuService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StuController {

    @Autowired
    private StuService stuService;

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> selectStudent(@Param("sql") String sql){
        return stuService.selectStudent(sql);
    }
}

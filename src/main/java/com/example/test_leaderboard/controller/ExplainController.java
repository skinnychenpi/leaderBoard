package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.entity.Explain;
import com.example.test_leaderboard.service.ExplainService;
import com.example.test_leaderboard.tools.ExtractNumber;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExplainController {

    @Autowired
    private ExplainService explainService;

    @RequestMapping("/explain")
    public double explainSQL(@Param("sql") String sql){
        return explainService.explainSQL(sql);
    }
}

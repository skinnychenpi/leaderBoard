package com.example.test_leaderboard.controller;

import com.example.test_leaderboard.entity.Rank;
import com.example.test_leaderboard.service.RankService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class RankController {
    @Autowired
    private RankService rankService;

    @RequestMapping("allRank")
    public List<Rank> showAllRank(@Param("problemNumber") int problemNumber){
        return rankService.showAllRank(problemNumber);
    }

    @RequestMapping("userRank")
    public BigInteger showUserRank(@Param("problemNumber") int problemNumber,
                                   @Param("userName") String userName){
        return rankService.showUserRank(problemNumber,userName);
    }
}

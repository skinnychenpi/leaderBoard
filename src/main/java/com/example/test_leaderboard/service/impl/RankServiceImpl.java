package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.dao.RankDao;
import com.example.test_leaderboard.entity.Rank;
import com.example.test_leaderboard.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class RankServiceImpl implements RankService {
    @Autowired
    private RankDao rankDao;

    @Autowired
    private ProblemServiceImpl problemService;

    @Override
    public List<Rank> showAllRank(int problemNumber){
        String order = problemService.selectProblem(problemNumber).getOrder();
        if(order.equals("fast"))
            return rankDao.showAllRankFast(problemNumber);
        else
            return rankDao.showAllRankSlow(problemNumber);
    }

    @Override
    public BigInteger showUserRank(int problemNumber, String userName){
        String order = problemService.selectProblem(problemNumber).getOrder();
        if(order.equals("fast"))
            return rankDao.showUserRankFast(problemNumber,userName);
        else
            return rankDao.showUserRankSlow(problemNumber,userName);
    }
}

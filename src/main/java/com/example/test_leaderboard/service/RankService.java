package com.example.test_leaderboard.service;

import com.example.test_leaderboard.entity.Rank;

import java.math.BigInteger;
import java.util.List;

public interface RankService {
    public List<Rank> showAllRank(int problemNumber,String order);
    public BigInteger showUserRank(int problemNumber, String userName, String order);
}

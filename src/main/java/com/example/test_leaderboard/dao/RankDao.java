package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface RankDao {
    public List<Rank> showAllRankFast(int problemNumber);
    public List<Rank> showAllRankSlow(int problemNumber);
    public BigInteger showUserRankFast(int problemNumber, String userName);
    public BigInteger showUserRankSlow(int problemNumber, String userName);
}

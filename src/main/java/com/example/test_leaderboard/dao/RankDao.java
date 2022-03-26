package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.Rank;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface RankDao {
    public List<Rank> showAllRank(int problemNumber);
    public BigInteger showUserRank(int problemNumber, String userName);
}

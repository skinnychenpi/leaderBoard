package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.Judge;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface JudgeDao {
    // 这里参数的名字必须要写value
    public List<Judge> JudgeSQL(String value,int problemNumber);
}

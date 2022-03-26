package com.example.test_leaderboard.dao;

import com.example.test_leaderboard.entity.Explain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExplainDao {
    // 这里参数的名字必须要写value
    //public List<Explain> explainSQL(String value);
    public double explainSQL(String value);
}

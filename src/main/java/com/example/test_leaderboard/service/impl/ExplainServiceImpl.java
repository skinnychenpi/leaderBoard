package com.example.test_leaderboard.service.impl;

import com.example.test_leaderboard.dao.ExplainDao;
import com.example.test_leaderboard.entity.Explain;
import com.example.test_leaderboard.service.ExplainService;
import com.example.test_leaderboard.tools.ExtractNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplainServiceImpl implements ExplainService {

    @Autowired
    private ExplainDao explainDao;


    @Override
    public double explainSQL(String sql){
        List<Explain> explainMessage = explainDao.explainSQL(sql);
        for(int i = 0; i < explainMessage.size(); i++){
            if(explainMessage.get(i).getExplainContent().contains("Execution Time"))
                return ExtractNumber.extractNumber(explainMessage.get(i).getExplainContent());
        }
        return 9999.9999;
    }
}

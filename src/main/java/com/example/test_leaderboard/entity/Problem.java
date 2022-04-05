package com.example.test_leaderboard.entity;

import lombok.Data;

@Data
public class Problem {
    private Integer problem_number;
    private String description;
    private String order;

    public String getOrder() {
        return order;
    }
}

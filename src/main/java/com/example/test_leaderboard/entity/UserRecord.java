package com.example.test_leaderboard.entity;

import lombok.Data;

@Data
public class UserRecord {
    private int submitIndex;
    private String userName;
    private int problemNumber;
    private double timeCost;
    private int submitTime;
}

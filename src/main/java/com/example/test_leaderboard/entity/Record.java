package com.example.test_leaderboard.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Record {
    private String userName;
    private int problemNumber;
    private double timeCost;
    private long currentTime;
}

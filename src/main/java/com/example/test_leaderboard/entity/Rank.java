package com.example.test_leaderboard.entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Rank {
    private BigInteger rank;
    private String userName;
    private int problemNumber;
    private double timeCost;
    private long submitTime;
}

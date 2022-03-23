package com.example.test_leaderboard.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumber {
    public static double extractNumber(String str) {
        return Double.valueOf(str.substring(15,str.length()-2));
    }

}

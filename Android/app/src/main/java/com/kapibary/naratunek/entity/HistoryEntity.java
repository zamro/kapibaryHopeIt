package com.kapibary.naratunek.entity;

/**
 * Created by slyboots on 10/27/17.
 */

public class HistoryEntity {
    private String challenge, date, sum;

    public HistoryEntity(String challenge, String date, String sum) {
        this.challenge = challenge;
        this.date = date;
        this.sum = sum;

    }

    public String getChallenge() {
        return challenge;
    }

    public String getDate() {
        return date;
    }

    public String getSum() {
        return sum;
    }
}

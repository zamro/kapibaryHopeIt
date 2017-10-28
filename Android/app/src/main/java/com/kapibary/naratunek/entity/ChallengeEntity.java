package com.kapibary.naratunek.entity;

/**
 * Created by slyboots on 10/27/17.
 */

public class ChallengeEntity {
    private String name;
    private Double amount;
    private String date;
    private boolean status;

    public ChallengeEntity(String name, Double amount, String date, boolean status) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public Double getAmount() {
        return amount;
    }
    public String getDate() {
        return date;
    }
    public boolean getStatus() {
        return status;
    }
}

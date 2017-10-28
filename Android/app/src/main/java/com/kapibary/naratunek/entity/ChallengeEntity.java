package com.kapibary.naratunek.entity;

import java.io.Serializable;

public class ChallengeEntity implements Serializable{
    private String name;
    private Double amount;
    private String date;
    private boolean status;
    private Double currentAmount;

    public ChallengeEntity(String name, Double amount, String date, boolean status, Double currentAmount) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.currentAmount = currentAmount;
    }

    public String getName() {
        return name;
    }
    public Double getAmount() {
        return amount;
    }
    public Double getCurrentAmount() {
        return currentAmount;
    }
    public String getDate() {
        return date;
    }
    public boolean getStatus() {
        return status;
    }
}

package com.kapibary.naratunek.entity;

/**
 * Created by mariusz on 28.10.17.
 */

public class PrizeEntity {
    private String name;
    private int points;

    public PrizeEntity(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}

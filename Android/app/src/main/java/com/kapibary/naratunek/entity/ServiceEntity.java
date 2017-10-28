package com.kapibary.naratunek.entity;

/**
 * Created by mariusz on 28.10.17.
 */

public class ServiceEntity {

    private String serviceSubject;
    private String price;
    private String deadline;

    public ServiceEntity(String serviceSubject, String price, String deadline) {
        this.serviceSubject = serviceSubject;
        this.price = price;
        this.deadline = deadline;
    }

    public String getServiceSubject() {
        return serviceSubject;
    }

    public String getPrice() {
        return price;
    }

    public String getDeadline() {
        return deadline;
    }
}

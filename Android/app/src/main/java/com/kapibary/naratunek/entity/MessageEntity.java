package com.kapibary.naratunek.entity;

/**
 * Created by slyboots on 10/27/17.
 */

public class MessageEntity {

    private String name, receiveTime, message;

    public MessageEntity(String name, String receiveTime, String message) {
        this.name = name;
        this.receiveTime = receiveTime;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getReceiveTime() {
        return receiveTime;
    }
}

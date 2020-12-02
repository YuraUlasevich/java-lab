package com.ulasevich.scooters.models;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class Order {
    private Integer id;

    @Digits(integer=3, fraction = 0)
    private Integer userId;
    @Digits(integer=3, fraction = 0)
    private Integer scooterId;
    @Size(min=5, max = 6)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScooterId() {
        return scooterId;
    }

    public void setScooterId(Integer scooterId) {
        this.scooterId = scooterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(Integer id, Integer userId, Integer scooterId, String status) {
        this.id = id;
        this.userId = userId;
        this.scooterId = scooterId;
        this.status = status;
    }

    public Order() {
    }
}

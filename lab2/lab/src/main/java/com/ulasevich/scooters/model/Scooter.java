package com.ulasevich.scooters.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

public class Scooter {
    private String location;
    private String producer;
    private String brand;
    private Integer charge_level;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCharge_level() {
        return charge_level;
    }

    public void setCharge_level(Integer charge_level) {
        this.charge_level = charge_level;
    }

    public Scooter(Long id, String location, String producer, String brand, Integer charge_level) {
        this.location = location;
        this.producer = producer;
        this.brand = brand;
        this.charge_level = charge_level;
    }

    public Scooter(String location, String producer, String brand, Integer charge_level) {
        this.location = location;
        this.producer = producer;
        this.brand = brand;
        this.charge_level = charge_level;
    }

    public Scooter() {
    }
}

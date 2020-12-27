package com.ulasevich.scooters.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Scooters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Please fill location")
    @Length(max = 40, message = "To Long")
    @Length(min = 5, message = "To Short")
    private String location;

    @NotBlank(message = "Please fill producer")
    @Length(max = 20, message = "To Long")
    @Length(min = 2, message = "To Short")
    private String producer;
    @NotBlank(message = "Please fill brand")
    @Length(max = 20, message = "To Long")
    @Length(min = 2, message = "To Short")
    private String brand;

    @Min(0)
    @Max(100)
    private Integer charge_level;



    @OneToMany(fetch = FetchType.EAGER, mappedBy = "scooter")
    private List<Order> order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getChargeLevel() {
        return charge_level;
    }

    public void setChargeLevel(Integer charge_level) {
        this.charge_level = charge_level;
    }

    public Scooters() {
    }


    public Integer getCharge_level() {
        return charge_level;
    }

    public void setCharge_level(Integer charge_level) {
        this.charge_level = charge_level;
    }

    public Scooters(String location, String producer, String brand, Integer charge_level) {
        this.location = location;
        this.producer = producer;
        this.brand = brand;
        this.charge_level = charge_level;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Scooter{"+"id="+this.id+", location='"+this.location+'\''+", " +
                "producer='"+this.producer+'\''+", brand='"+this.brand+'\''+", chargeLevel="+this.charge_level+'}';
    }
}

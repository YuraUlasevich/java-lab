package com.ulasevich.scooters.models;


import javax.validation.constraints.Size;

public class User {
    private Integer id;

    @Size(min=2, max=10)
    private String name;
    @Size(min=2, max=20)
    private String email;
    @Size(min=6)
    private String login;
    @Size(min=6)
    private String password;
    @Size(min=7)
    private String phone;
    @Size(min=5)
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(Integer id, String name, String email, String login, String password, String phone, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }
}


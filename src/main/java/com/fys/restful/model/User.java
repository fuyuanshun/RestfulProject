package com.fys.restful.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private String id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String phone;
    private String address;
    private String hobby;
    private String registerDate;

    public User(){

    }

    public User(String username, String password, String sex, String email, String phone, String address, String hobby) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.hobby = hobby;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}

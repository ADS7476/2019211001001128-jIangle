package com.jiangle.model;

import java.sql.Date;

public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String gender;
    private java.util.Date birthDate;
    private String sex;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", gender='" + gender + '\'' + ", birthDate=" + birthDate + '}';
    }

    //constructor
    public User() {
    }

    public User(String id, String username, String password, String email, String gender,String sex, java.util.Date birthDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.sex = sex;
        this.birthDate = birthDate;
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
        this. password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {

        this.sex = sex;
    }
    public java.util.Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
    }


    public void setBirthday(Date birthday) {
    }


    public Date getBirthday() {
        return null;
    }
}
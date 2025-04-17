package com.cpt202.FitnessTrainerAppointmentSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String username;
    private String nickname;
    private String password;
    private String gender;
    private String phone;
    private String birthday;
    private String about;
    private String avatarUrl;

    
    public User(int id, String email, String username, String nickname, 
    String password, String gender, String phone, String birthday, String about, String avatarUrl) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.about = about;
        this.avatarUrl = avatarUrl;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }
    
    public void setAbout(String about) {
        this.about = about;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }


    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }
    
}

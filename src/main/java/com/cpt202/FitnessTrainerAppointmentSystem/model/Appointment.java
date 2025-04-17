package com.cpt202.FitnessTrainerAppointmentSystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userid")
    private int userId;

    @Column(name = "trainerid")
    private int trainerId;

    @Column(name = "coursename")
    private String courseName;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "image_url")
    private String image_url;


    @Transient
    private String trainerName; // Transient field to hold trainer name

    // Constructors, Getters, and Setters

    public Appointment(int userId, int trainerId, String courseName, String time) {


        this.userId = userId;
        this.trainerId = trainerId;
        this.courseName = courseName;
        this.time = time;
    }

    public Appointment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", userId=" + userId +
                ", trainerId=" + trainerId +
                ", date=" + date +
                ", time=" + time +
                '}';
    }


}

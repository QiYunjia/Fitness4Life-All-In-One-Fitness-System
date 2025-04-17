package com.cpt202.FitnessTrainerAppointmentSystem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Noti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String notiname;
    private String Content;
    private String Time;
    private LocalDateTime LocalTime;


    
    public Noti(int id, String notiname, String content, String time, LocalDateTime localTime) {
        this.id = id;
        this.notiname = notiname;
        Content = content;
        Time = time;
        LocalTime = localTime;
    }
    // public Noti(int id, String notiname, String content, String time) {
    //     this.id = id;
    //     this.notiname = notiname;
    //     Content = content;
    //     Time = time;
    // }
    public Noti() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNotiname() {
        return notiname;
    }
    public void setNotiname(String notiname) {
        this.notiname = notiname;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
    }
    public LocalDateTime getLocalTime() {
        return LocalTime;
    }
    public void setLocalTime(LocalDateTime localTime) {
        LocalTime = localTime;
    }




    

   
    

}

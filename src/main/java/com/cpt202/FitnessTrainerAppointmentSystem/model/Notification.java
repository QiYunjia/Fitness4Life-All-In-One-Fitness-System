



















package com.cpt202.FitnessTrainerAppointmentSystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notificationId;
    private String notificationName;
    // private String content;
    // private Blob picture;







    
    public int getNotificationId() {
        return notificationId;
    }
    public Notification(String notificationName) {
        this.notificationName = notificationName;
    }
    public Notification(int notificationId, String notificationName) {
        this.notificationId = notificationId;
        this.notificationName = notificationName;
    }
    public Notification() {
    }
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    public String getNotificationName() {
        return notificationName;
    }
    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    








    
    

    
    
    
   



    
    

    
}

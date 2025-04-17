package com.cpt202.FitnessTrainerAppointmentSystem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int planid;



    public Subscribe(int id, int planid) {
        this.id = id;
        this.planid = planid;
    }
    public Subscribe() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPlanid() {
        return planid;
    }
    public void setPlanid(int planid) {
        this.planid = planid;
    }


    

}

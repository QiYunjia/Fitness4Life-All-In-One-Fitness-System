package com.cpt202.FitnessTrainerAppointmentSystem.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Classfortrain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String classname;
    private int classlevel;
    private String classcontent;


    
    public Classfortrain(int id, String classname, int classlevel, String classcontent) {
        this.id = id;
        this.classname = classname;
        this.classlevel = classlevel;
        this.classcontent = classcontent;
    }
    public Classfortrain() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClassname() {
        return classname;
    }
    public void setClassname(String classname) {
        this.classname = classname;
    }
    public int getClasslevel() {
        return classlevel;
    }
    public void setClasslevel(int classlevel) {
        this.classlevel = classlevel;
    }
    public String getClasscontent() {
        return classcontent;
    }
    public void setClasscontent(String classcontent) {
        this.classcontent = classcontent;
    }
    public Classfortrain findByClassId(int classId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClassId'");
    }

    
}

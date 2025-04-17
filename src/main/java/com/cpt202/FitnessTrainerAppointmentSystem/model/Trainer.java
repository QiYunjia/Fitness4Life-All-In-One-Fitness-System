package com.cpt202.FitnessTrainerAppointmentSystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "level")
    private String level;

    @Column(name = "timecollection")
    private String timeCollection;

    @Column(name = "course")
    private String course;

    @Column(name = "coursename")
    private String coursename;


    @Column(name = "intro")
    private String intro;

    // @Column(name = "classid")
    // private int classId;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "classfortrain", nullable = false)
    // private Classfortrain classfortrain;

    @Column(name = "imageUrl")
    private String imageUrl;

    public Trainer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Trainer() {
    }

    public Trainer(String name, int age, String level, String timeCollection, String intro, int classId, String course,String coursename,String imageUrl) {

        this.name = name;
        this.age = age;
        this.level = level;
        this.timeCollection = timeCollection;
        this.course=course;
        this.coursename=coursename;
        this.intro = intro;
        // this.classId = classId;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTimeCollection() {
        return timeCollection;
    }

    public void setTimeCollection(String timeCollection) {
        this.timeCollection = timeCollection;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    // public int getClassId() {
    //     return classId;
    // }

    // public void setClassId(int classId) {
    //     this.classId = classId;
    // }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    // public Classfortrain getClassForTrain() { // 添加 getClassForTrain 方法
    //     return classfortrain;
    // }

    // public void setClassForTrain(Classfortrain classForTrain) { // 添加 setClassForTrain 方法
    //     this.classfortrain = classForTrain;
    // }


    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level='" + level + '\'' +
                ", timeCollection='" + timeCollection + '\'' +
                ", course='" + course + '\'' +
                ", coursename='" + coursename + '\'' +

                ", intro='" + intro + '\'' +
                // ", classId=" + classId +
                ", imageUrl=" + imageUrl +

                '}';
    }
}


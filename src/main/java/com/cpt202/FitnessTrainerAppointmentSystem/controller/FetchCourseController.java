package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Course;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.CourseRepository;


@RestController
public class FetchCourseController {
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }
}

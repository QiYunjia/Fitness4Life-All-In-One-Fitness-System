package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Course;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.CourseRepository;

@Controller
public class AppointmentController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/appointment_page")
    public String get(Model m) {
        List<Course> courses = courseRepository.findAll();
        m.addAttribute("courses", courses);
        return "MakeAppointment";
    }

    @GetMapping("/managerViewAppointment")
    public String managerViewAppointment(Model m) {
        List<Course> courses = courseRepository.findAll();
        m.addAttribute("courses", courses);
        return "managerViewAppointment"; 
    }

}

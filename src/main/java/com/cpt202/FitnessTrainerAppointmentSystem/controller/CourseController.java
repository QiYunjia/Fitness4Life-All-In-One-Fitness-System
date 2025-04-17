package com.cpt202.FitnessTrainerAppointmentSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Course;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.CourseRepository;
import com.cpt202.FitnessTrainerAppointmentSystem.services.StoreImage;


@Controller
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StoreImage storeImage;

    @GetMapping("/addCourse")
    public String addCourse(Model m) {
        m.addAttribute("course", new Course());
        return "addCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(@RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("description") String description) {
        String url = storeImage.store(file);
        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()

                .path(file.getOriginalFilename())
                .toUriString();

        Course course = new Course(name, description, uri);
        courseRepository.save(course);
        return "redirect:/manageCourses";
    }

    @GetMapping("/manageCourses")
    public String manageCourses() {
        return "manageCourses";
    }

    @GetMapping("/modifyCourse/{id}")
    public String modifyCourse(@PathVariable int id, Model m) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        m.addAttribute("course", course);
        return "modifyCourse";
    }
    @PostMapping("/modifyCourse")
    public String modifyCourse(@RequestParam Integer id, @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name, @RequestParam("description") String description) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid course Id:" + id));
        if (!file.isEmpty()) {
            String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(file.getOriginalFilename())
                    .toUriString();
            course.setImage_url(uri);
            storeImage.store(file);
        }
        course.setId(id);
        course.setName(name);
        course.setDescription(description);
        courseRepository.save(course);
        return "redirect:/manageCourses";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id, Model m) {
        courseRepository.deleteById(id);
        return "redirect:/manageCourses";
    }
}

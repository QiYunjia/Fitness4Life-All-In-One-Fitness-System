package com.cpt202.FitnessTrainerAppointmentSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Course;



@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{
    
}

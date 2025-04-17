package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;

// import com.cpt202.FitnessTrainerAppointmentSystem.controller.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Plan;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PlanRepo extends JpaRepository<Plan,Integer>{

}

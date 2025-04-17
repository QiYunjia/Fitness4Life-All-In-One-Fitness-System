package com.cpt202.FitnessTrainerAppointmentSystem.repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {

    List<Trainer> findByName(String name);
    List<Trainer> findByCourse(String Course);

    

}

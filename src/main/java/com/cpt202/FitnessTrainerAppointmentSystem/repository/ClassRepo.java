package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Classfortrain;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClassRepo extends JpaRepository<Classfortrain,Integer>{
    
}

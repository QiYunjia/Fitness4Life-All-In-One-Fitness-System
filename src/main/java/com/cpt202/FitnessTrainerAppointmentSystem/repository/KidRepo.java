package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Kid;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface KidRepo extends JpaRepository<Kid,Integer>{

  

}


    


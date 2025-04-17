package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Manager;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer>{
    Manager findByName(String name);
}

package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Noti;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface NotiRepo extends JpaRepository<Noti,Integer>{
    
}


















package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Notification;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Integer>{
    
}

package com.cpt202.FitnessTrainerAppointmentSystem.repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByTrainerId(Long trainerId);
    List<Appointment> findByTrainerIdAndDateAndTime(int trainerId,String date, String time);
    List<Appointment> findByUserId(int userId);
}


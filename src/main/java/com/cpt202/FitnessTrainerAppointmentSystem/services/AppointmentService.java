package com.cpt202.FitnessTrainerAppointmentSystem.services;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.AppointmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    public Appointment createOrUpdateAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> listAppointments() {
        return appointmentRepo.findAll();
    }

    public Optional<Appointment> getAppointmentById(int id) {
        return appointmentRepo.findById(id);
    }

    public void deleteAppointment(int id) {
        Optional<Appointment> optionalAppointment = appointmentRepo.findById(id);
        appointmentRepo.deleteById(id);
    }

    public List<Appointment> getAppointmentsByTrainerId(Long trainerId) {
        return appointmentRepo.findByTrainerId(trainerId);
    }

}

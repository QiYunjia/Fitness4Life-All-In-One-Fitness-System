package com.cpt202.FitnessTrainerAppointmentSystem.controller;

public class TrainerNotFoundException extends RuntimeException{
    public TrainerNotFoundException(Long id) {
        super("Trainer not found with id: " + id);
    }
}

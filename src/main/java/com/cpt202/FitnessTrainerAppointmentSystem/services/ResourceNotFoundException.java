package com.cpt202.FitnessTrainerAppointmentSystem.services;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

package com.cpt202.FitnessTrainerAppointmentSystem.services;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Plan;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlanRepo planRepo;

    public PlanService(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    public List<Plan> getAllPlans() {
        return planRepo.findAll();
    }

    public Plan getPlanById(Integer id) {
        return planRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found with id " + id));
    }

    public Double getPlanPriceById(Integer id) {
        return planRepo.findById(id).get().getPrice();
    }

    // Other methods for creating, updating, and deleting subscriptions
}

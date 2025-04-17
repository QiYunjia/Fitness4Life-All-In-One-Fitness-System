package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByUserId(int userId);
    List<Order> findAllByUserId(int userId);
}


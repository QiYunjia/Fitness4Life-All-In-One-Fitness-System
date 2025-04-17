package com.cpt202.FitnessTrainerAppointmentSystem.services;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersById(int id) {
        return orderRepository.findAllByUserId(id);
    }

    public Order saveOrders(Order order) { return orderRepository.save(order); }
}

package com.cpt202.FitnessTrainerAppointmentSystem.controller;


import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cpt202.FitnessTrainerAppointmentSystem.services.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user_order")
    public String listOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("orders", orderService.getOrdersById(user.getId()));
        return "myorders";
    }
}


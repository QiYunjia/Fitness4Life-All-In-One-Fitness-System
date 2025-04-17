package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;

import com.cpt202.FitnessTrainerAppointmentSystem.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cpt202.FitnessTrainerAppointmentSystem.services.OrderService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Controller
public class SubscriptionController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PlanService planService;


    @PostMapping("/silver_order")
    public String saveSilverOrder(@ModelAttribute("silverOrder") Order order, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        // Get the current time and save it to the order
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentTimeAsDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());

        if (order.getPlanName().equals("Silver Plan (6 months)")) {
            Double price = planService.getPlanPriceById(1);
            order.setPrice(price);
            LocalDateTime sixMonthsLater = currentTime.plus(6, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(sixMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }
        if (order.getPlanName().equals("Silver Plan (12 months)")) {
            Double price = planService.getPlanPriceById(2);
            order.setPrice(price);
            LocalDateTime twelveMonthsLater = currentTime.plus(12, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(twelveMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }


        order.setSubscribingDate(currentTimeAsDate);
        orderService.saveOrders(order);
        return "payment/paysuccess"; // Redirect after post to prevent duplicate submissions
    }

    @PostMapping("/gold_order")
    public String saveGoldOrder(@ModelAttribute("goldOrder") Order order, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        // Get the current time and save it to the order
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentTimeAsDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());

        if (order.getPlanName().equals("Gold Plan (6 months)")) {
            Double price = planService.getPlanPriceById(3);
            order.setPrice(price);
            LocalDateTime sixMonthsLater = currentTime.plus(6, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(sixMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }
        if (order.getPlanName().equals("Gold Plan (12 months)")) {
            Double price = planService.getPlanPriceById(4);
            order.setPrice(price);
            LocalDateTime twelveMonthsLater = currentTime.plus(12, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(twelveMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }
        order.setSubscribingDate(currentTimeAsDate);
        orderService.saveOrders(order);
        return "payment/paysuccess"; // Redirect after post to prevent duplicate submissions
    }

    @PostMapping("/diamond_order")
    public String saveDiamondOrder(@ModelAttribute("diamondOrder") Order order, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        order.setUserId(user.getId());
        // Get the current time and save it to the order
        LocalDateTime currentTime = LocalDateTime.now();
        Date currentTimeAsDate = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant());

        if (order.getPlanName().equals("Diamond Plan (6 months)")) {
            Double price = planService.getPlanPriceById(5);
            order.setPrice(price);
            LocalDateTime sixMonthsLater = currentTime.plus(6, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(sixMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }
        if (order.getPlanName().equals("Diamond Plan (12 months)")) {
            Double price = planService.getPlanPriceById(6);
            order.setPrice(price);
            LocalDateTime twelveMonthsLater = currentTime.plus(12, ChronoUnit.MONTHS);

            // Convert it to Date and save it to the order
            Date sixMonthsLaterAsDate = Date.from(twelveMonthsLater.atZone(ZoneId.systemDefault()).toInstant());
            order.setExpireDate(sixMonthsLaterAsDate);
        }
        order.setSubscribingDate(currentTimeAsDate);
        orderService.saveOrders(order);
        return "payment/paysuccess"; // Redirect after post to prevent duplicate submissions
    }
}

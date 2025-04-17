package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Plan;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.services.PlanService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class PayController {

    @Autowired
    private PlanService planService;

    @GetMapping("/pay_page_silver")
    public String getPayPageSilver(Model m, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Plan> plans = new LinkedList<>();
            plans.add(planService.getPlanById(1));
            plans.add(planService.getPlanById(2));
            m.addAttribute("plans", plans);
            m.addAttribute("silverOrder", new Order());
            return "payment/payment_silver";
        }
        return "redirect:/log_in";

    }

    @GetMapping("/pay_page_gold")
    public String getPayPageGold(Model m, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Plan> plans = new LinkedList<>();
            plans.add(planService.getPlanById(3));
            plans.add(planService.getPlanById(4));
            m.addAttribute("plans", plans);
            m.addAttribute("goldOrder", new Order());
            return "payment/payment_gold";
        }
        return "redirect:/log_in";
    }

    @GetMapping("/pay_page_diamond")
    public String getPayPageDiamond(Model m, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<Plan> plans = new LinkedList<>();
            plans.add(planService.getPlanById(5));
            plans.add(planService.getPlanById(6));
            m.addAttribute("plans", plans);
            m.addAttribute("diamondOrder", new Order());
            return "payment/payment_diamond";
        }
        return "redirect:/log_in";
    }



}

package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Noti;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Trainer;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.AppointmentRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.NotiRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.TrainerRepo;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotiController {
    @Autowired
    private NotiRepo notiRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @GetMapping("/supernotis_page")
    public String getNotiPage(Model m, HttpSession session) {
        List<Noti> notis = notiRepo.findAll();
        Collections.reverse(notis);
        m.addAttribute("notis", notis);
        m.addAttribute("noti", new Noti());

        User user = (User) session.getAttribute("user");
        List<Appointment> appointments = appointmentRepo.findByUserId(user.getId());
        m.addAttribute("appointments", appointments);
        m.addAttribute("appointment", new Appointment());

        Map<Long, String> trainerNames = new HashMap<>();
        List<Trainer> trainers = trainerRepo.findAll();
        for (Trainer trainer : trainers) {
            trainerNames.put(trainer.getId(), trainer.getName());
        }
        m.addAttribute("trainerNames", trainerNames);

        return "viewNoti";
    }

    @PostMapping("/supernotis_page")
    public String postAddNoti(@ModelAttribute Noti noti, Model model) {
        notiRepo.save(noti);
        return "redirect:/notis_page";
    }

    @GetMapping("/notis_page")
    public String getAddNoti(Model model) {
        List<Noti> notis = notiRepo.findAll();
        Collections.reverse(notis);
        model.addAttribute("notis", notis);
        model.addAttribute("noti", new Noti());
        return "sendNoti";
    }

    @PostMapping("/notis_page")
    public String addNoti(@ModelAttribute("noti") Noti noti) {

        LocalDateTime currentTime = LocalDateTime.now();

        noti.setLocalTime(currentTime);
 
        notiRepo.save(noti);
        return "redirect:/notis_page";
    }

    @PostMapping("/deleteNoti/{id}")
    public String deleteNoti(@PathVariable int id, Model m) {
        notiRepo.deleteById(id);
        return "redirect:/notis_page";
    }

}

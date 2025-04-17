package com.cpt202.FitnessTrainerAppointmentSystem.controller;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
// import com.cpt202.FitnessTrainerAppointmentSystem.repository.UserRepo;

@Controller
public class Subscribe {
    @GetMapping("/subscribe_page")
    public String getSubscribePage(Model m){
        return "subscribe";
    }
       
}

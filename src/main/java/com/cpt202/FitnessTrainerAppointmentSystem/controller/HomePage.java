package com.cpt202.FitnessTrainerAppointmentSystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePage {


    @GetMapping("/home_page")
    public String getHomePage(Model m){
        return "homepage";
    }


    @GetMapping("/home_page_auth")
    public String getHomePageAuth(Model m){
        return "homepageAuth";
    }

}


package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Course;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Trainer;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.AppointmentRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.CourseRepository;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.TrainerRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.UserRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.services.OrderService;


@Controller
public class ReportController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private AppointmentRepo appointmentRepo;


private int calculateGoldSubscriptionsForMonth(List<Order> orders, int month) {
    int count = 0;
    for (Order order : orders) {
        if (order.getPlanName().startsWith("Gold") && getMonthFromDate(order.getSubscribingDate()) == month) {
            count++;
        }
    }
    return count;
}
private int calculateSilverSubscriptionsForMonth(List<Order> orders, int month) {
    int count = 0;
    for (Order order : orders) {
        if (order.getPlanName().startsWith("Silver") && getMonthFromDate(order.getSubscribingDate()) == month) {
            count++;
        }
    }
    return count;
}
private int calculateDiamondSubscriptionsForMonth(List<Order> orders, int month) {
    int count = 0;
    for (Order order : orders) {
        if (order.getPlanName().startsWith("Diamond") && getMonthFromDate(order.getSubscribingDate()) == month) {
            count++;
        }
    }
    return count;
}

private int getMonthFromDate(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.MONTH) + 1; 
}



    @GetMapping("/report_page")
public String getReportPage(Model m){
    List<Trainer> trainers=trainerRepo.findAll();
    m.addAttribute("trainers", trainers);

    List<Appointment> appointments=appointmentRepo.findAll();
    m.addAttribute("appointments", appointments);

   
    List<Order> orders = orderService.getAllOrders();
    m.addAttribute("orders", orders);

        // List<Order> orders = orderService.getAllOrders();
    List<Integer> goldSubscriptionsPerMonth = new ArrayList<>();
    List<Integer> silverSubscriptionsPerMonth = new ArrayList<>();
    List<Integer> diamondSubscriptionsPerMonth = new ArrayList<>();

    List<User> users=userRepo.findAll();
    m.addAttribute("users", users);

    List<Course> courses=courseRepo.findAll();
    m.addAttribute("courses", courses);

   
    Map<Long, Long> trainerIdCountMap = new HashMap<>();

    for (Appointment appointment : appointments) {
        long trainerId = appointment.getTrainerId();
      
        trainerIdCountMap.put(trainerId, trainerIdCountMap.getOrDefault(trainerId, 0L) + 1);
    }

    List<Map.Entry<Long, Long>> sortedEntries = trainerIdCountMap.entrySet().stream()
            .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
            .limit(5)
            .collect(Collectors.toList());
    
    m.addAttribute("topTrainerIdCounts", sortedEntries);



List<Long> sortedKeys = sortedEntries.stream()
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());


List<Long> sortedValues = sortedEntries.stream()
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());

        

 Map<Long, String> idToNameMap = trainers.stream()
 .collect(Collectors.toMap(Trainer::getId, Trainer::getName));

 List<String> sortedNames = sortedKeys.stream()
 .map(idToNameMap::get) 
 .collect(Collectors.toList());

m.addAttribute("sortedNames", sortedNames);
m.addAttribute("sortedKeys", sortedKeys);
m.addAttribute("sortedValues", sortedValues);








    
 
    for (int i = 1; i <= 7; i++) { 
        int count = calculateGoldSubscriptionsForMonth(orders, i);
        goldSubscriptionsPerMonth.add(count);
    }
    m.addAttribute("goldSubscriptionsPerMonth", goldSubscriptionsPerMonth);

 
    for (int i = 1; i <= 7; i++) {
        int count = calculateSilverSubscriptionsForMonth(orders, i);
        silverSubscriptionsPerMonth.add(count);
    }
    m.addAttribute("silverSubscriptionsPerMonth", silverSubscriptionsPerMonth);


    for (int i = 1; i <= 7; i++) { 
        int count = calculateDiamondSubscriptionsForMonth(orders, i);
        diamondSubscriptionsPerMonth.add(count);
    }
    m.addAttribute("diamondSubscriptionsPerMonth", diamondSubscriptionsPerMonth);

   
    
    return "report";
}


}

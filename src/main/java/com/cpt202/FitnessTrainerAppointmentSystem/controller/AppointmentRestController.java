package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Trainer;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Order;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.AppointmentRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.OrderRepository;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.TrainerRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/classes")
public class AppointmentRestController {

    @Autowired
    private TrainerRepo trainerRepository;
    @Autowired
    private AppointmentRepo appointmentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{appointmentTime}")
    public List<Trainer> getTrainerByAppointmentTime(@PathVariable String appointmentTime, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderRepository.findAllByUserId(user.getId());
        Order theOrder = orders.get(0);
        int max = 0;
        for (Order order : orders) {
            if (order.getId() >= max) {
                max = order.getId();
                theOrder = order;
            }
        }
        String planName = theOrder.getPlanName();
        String[] array = planName.split(" ");
        String planLevel = array[0];
        int Level = 0;
        if (planLevel.equalsIgnoreCase("Silver")) {
            Level = 3;
        }
        if (planLevel.equalsIgnoreCase("Gold")) {
            Level = 4;
        }
        if (planLevel.equalsIgnoreCase("Diamond")) {
            Level = 5;
        }
        List<Trainer> allTrainer = trainerRepository.findAll();
        List<Trainer> trainers = new ArrayList<>();
        for (Trainer trainer : allTrainer) {
            String[] level = trainer.getLevel().split("-");
            int levelNumber = Integer.parseInt(level[0]);
            String[] time = trainer.getTimeCollection().split(" ");
            if (Level >= levelNumber) {
                for (String t : time) {
                    if (t.equals(appointmentTime)) {
                        trainers.add(trainer);
                    }
                }
            }
        }
        return trainers;
    }

    @GetMapping("/{course}/{appointmentTime}")
    public List<Trainer> getTrainersByCourse(@PathVariable String course, @PathVariable String appointmentTime,
            HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderRepository.findAllByUserId(user.getId());
        Order theOrder = orders.get(0);
        int max = 0;
        for (Order order : orders) {
            if (order.getId() >= max) {
                max = order.getId();
                theOrder = order;
            }
        }
        String planName = theOrder.getPlanName();
        String[] array = planName.split(" ");
        String planLevel = array[0];
        int Level = 0;
        if (planLevel.equalsIgnoreCase("Silver")) {
            Level = 3;
        }
        if (planLevel.equalsIgnoreCase("Gold")) {
            Level = 4;
        }
        if (planLevel.equalsIgnoreCase("Diamond")) {
            Level = 5;
        }
        List<Trainer> allTrainer = trainerRepository.findByCourse(course);
        List<Trainer> trainers = new ArrayList<>();
        for (Trainer trainer : allTrainer) {
            String[] level = trainer.getLevel().split("-");
            int levelNumber = Integer.parseInt(level[0]);
            String[] time = trainer.getTimeCollection().split(" ");
            if (Level >= levelNumber) {
                for (String t : time) {
                    if (t.equals(appointmentTime)) {
                        trainers.add(trainer);
                    }
                }
            }
        }
        return trainers;
    }

    @GetMapping("")
    public void get() {

    }

    @PostMapping("")
    public ResponseEntity<?> saveAppointment(@RequestBody Map<String, Object> receivedMessage, HttpSession session) {
        Integer trainerId = (Integer) receivedMessage.get("trainerId");
        String time = (String) receivedMessage.get("selectedTime");
        String courseName = (String) receivedMessage.get("courseName");
        String date = (String) receivedMessage.get("selectedDate");
        String image_url = (String) receivedMessage.get("imageUrl");
        List<Appointment> appointments = appointmentRepository.findByTrainerIdAndDateAndTime(trainerId, date, time);
        if (appointments.isEmpty()) {
            Appointment appointment = new Appointment();
            User user = (User) session.getAttribute("user");
            appointment.setUserId(user.getId());
            appointment.setTrainerId(trainerId);
            appointment.setTime(time);
            appointment.setCourseName(courseName);
            appointment.setDate(date);
            appointment.setImage_url(image_url);
            appointmentRepository.save(appointment);
            return (ResponseEntity<?>) ResponseEntity.ok().body("Successful");
        }
        return (ResponseEntity<?>) ResponseEntity.status(409).body("Fail");

    }

    @GetMapping("/manager/{appointmentTime}")
    public List<Trainer> getTrainerByAppointmentTime(@PathVariable String appointmentTime) {
        List<Trainer> allTrainer = trainerRepository.findAll();
        List<Trainer> trainers = new ArrayList<>();
        for (Trainer trainer : allTrainer) {
            String[] time = trainer.getTimeCollection().split(" ");

            for (String t : time) {
                if (t.equals(appointmentTime)) {
                    trainers.add(trainer);
                }
            }

        }
        return trainers;
    }

    @GetMapping("/manager/{course}/{appointmentTime}")
    public List<Trainer> getTrainersByCourse(@PathVariable String course, @PathVariable String appointmentTime) {
        List<Trainer> allTrainer = trainerRepository.findByCourse(course);
        List<Trainer> trainers = new ArrayList<>();
        for (Trainer trainer : allTrainer) {
            String[] time = trainer.getTimeCollection().split(" ");
            for (String t : time) {
                if (t.equals(appointmentTime)) {
                    trainers.add(trainer);
                }
            }

        }
        return trainers;
    }

}

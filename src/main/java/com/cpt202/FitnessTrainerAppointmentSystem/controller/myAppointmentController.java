package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Appointment;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.AppointmentRepo;

import jakarta.servlet.http.HttpSession;
@RestController
public class myAppointmentController {
    @Autowired
    private AppointmentRepo appointmentRepository;

    @GetMapping("/myCurrentApppointments")
    public List<Appointment> getCurrentAppointments(HttpSession session){
        User user = (User) session.getAttribute("user");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d",Locale.US);
        String formattedDate = currentDate.format(formatter);
        String[] array = formattedDate.split(" ");
        String month = array[0];
        int monthNumber = 0;
        int date = Integer.parseInt(array[1]);
        if(month.equals("January")){
            monthNumber = 1;
        }
        if(month.equals("February")){
            monthNumber = 2;
        }
        if(month.equals("March")){
            monthNumber = 3;
        }
        if(month.equals("April")){
            monthNumber = 4;
        }
        if(month.equals("May")){
            monthNumber = 5;
        }
        if(month.equals("June")){
            monthNumber = 6;
        }
        if(month.equals("July")){
            monthNumber = 7;
        }
        if(month.equals("August")){
            monthNumber = 8;
        }
        if(month.equals("September")){
            monthNumber = 9;
        }
        if(month.equals("October")){
            monthNumber = 10;
        }
        if(month.equals("November")){
            monthNumber = 11;
        }
        if(month.equals("December")){
            monthNumber = 12;
        }
        List<Appointment> appointments = appointmentRepository.findByUserId(user.getId());
        List<Appointment> appointmentList = new ArrayList<>();
        for(Appointment appointment:appointments){
            String[] array1 = appointment.getDate().split(" ");
            String storedMonth = array1[0];
            int storedDate = Integer.parseInt(array1[1]);
            int storedMonthNumber = 0;
            if(storedMonth.equals("January")){
                storedMonthNumber = 1;
            }
            if(storedMonth.equals("February")){
                storedMonthNumber = 2;
            }
            if(storedMonth.equals("March")){
                storedMonthNumber = 3;
            }
            if(storedMonth.equals("April")){
                storedMonthNumber = 4;
            }
            if(storedMonth.equals("May")){
                storedMonthNumber = 5;
            }
            if(storedMonth.equals("June")){
                storedMonthNumber = 6;
            }
            if(storedMonth.equals("July")){
                storedMonthNumber = 7;
            }
            if(storedMonth.equals("August")){
                storedMonthNumber = 8;
            }
            if(storedMonth.equals("September")){
                storedMonthNumber = 9;
            }
            if(storedMonth.equals("October")){
                storedMonthNumber = 10;
            }
            if(storedMonth.equals("November")){
                storedMonthNumber = 11;
            }
            if(storedMonth.equals("December")){
                storedMonthNumber = 12;
            }
            if(storedMonthNumber > monthNumber){
                appointmentList.add(appointment);

            }
            if(storedMonthNumber==monthNumber && storedDate>=date){
                appointmentList.add(appointment);
            }
        }
        return appointmentList;
    }
    @GetMapping("/updateMyCurrentAppointment")
    public void get(){

    }
    @PostMapping("/updateMyCurrentAppointment")
    public void saveAppointment(@RequestBody Map<String, Object> receivedMessage) {
        Integer id = (Integer) receivedMessage.get("appointmentId");
        String time = (String) receivedMessage.get("appointmentTime");
        String date = (String) receivedMessage.get("appointmentDate");
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment Id:" + id));
        appointment.setDate(date);
        appointment.setTime(time);
        appointmentRepository.save(appointment);
    
    }
    @GetMapping("/myCurrentAppointments/{id}")
    public Optional<Appointment> getAppointment(@PathVariable int id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment;
    }
    @GetMapping("/deleteAppointment")
    public void delete(){

    }
    @PostMapping("/deleteAppointment")
    public void delete(@RequestBody Map<String, Object> receivedMessage){
        Integer id = (Integer) receivedMessage.get("appointmentId");
        appointmentRepository.deleteById(id);

    }
    @GetMapping("/appointmentHistory")
    public List<Appointment> getAppointmentHistory(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Appointment> appointments = appointmentRepository.findByUserId(user.getId());
        return appointments;
    }
}

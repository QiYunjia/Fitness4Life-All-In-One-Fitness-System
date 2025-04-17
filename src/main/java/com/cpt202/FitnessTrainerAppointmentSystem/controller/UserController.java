package com.cpt202.FitnessTrainerAppointmentSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Manager;
import com.cpt202.FitnessTrainerAppointmentSystem.model.Trainer;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;
import com.cpt202.FitnessTrainerAppointmentSystem.repository.UserRepo;
import com.cpt202.FitnessTrainerAppointmentSystem.services.StoreImage;

import jakarta.servlet.http.HttpSession;




@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StoreImage storeImage;

    @GetMapping("/user_home_page")
    public String getUserHomePage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("manager", new Manager());
            return "userInfo";
        } else {
            model.addAttribute("user", new User());
            model.addAttribute("manager", new Manager());
            return "logIn";
        }
    }
    
    @GetMapping("/add_user")
    public String getUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("manager", new Manager());
        return "signUp";

    }

    @PostMapping("/add_user")
    public String postAddUser(@ModelAttribute User user, Model model) {
        
        User existingUser = userRepo.findByUsername(user.getUsername());
        User existingUserByEmail = userRepo.findByEmail(user.getEmail());

        // Check if username has already existed in db 
        if (existingUser != null) {
            // If so, send error image at sign up page
            model.addAttribute("manager", new Manager());
            model.addAttribute("error", "Username already exists. Please choose a different username.");
            return "signUp";
        } else if (existingUserByEmail != null) {
            // Check if email exists, send error message to sign up page
            model.addAttribute("manager", new Manager());
            model.addAttribute("error", "Email already used. Please use another email.");
            return "signUp";
        } else {
            // Else, sign up successfully, trun to success page
            model.addAttribute("manager", new Manager());
            model.addAttribute("success", "Sign up successfully. Now you can log in!");
            userRepo.save(user);
            return "signUp";
        }
    }

    @GetMapping("/log_in")
    public String getLogInPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // If a user has logged in, when he visit loggin page, redirect him to user_home_page
            return "homepageAuth";
        }
        model.addAttribute("user", new User());
        model.addAttribute("manager", new Manager());
        return "logIn";
    }

    @PostMapping("/log_in")
    public String logIn(@RequestParam String username, @RequestParam String password, HttpSession session, Model m) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home_page_auth";
        } else {
            m.addAttribute("user", new User());
            m.addAttribute("manager", new Manager());
            m.addAttribute("loginerror", "Invalid username or password. Please check again.");
            return "logIn"; 
        }
    }
    
    @PostMapping("/user_home_page")
    public String updateProfile(@ModelAttribute User updateUser, HttpSession session, Model model) {

        // Get current user from session
        User currentUser = (User) session.getAttribute("user");
        User existingUserByEmail = userRepo.findByEmail(updateUser.getEmail());
        
        if(currentUser != null){ // Only logged in user can modify information
            // Update user information
            if(updateUser.getNickname() != null && !updateUser.getNickname().isEmpty())
                currentUser.setNickname(updateUser.getNickname());

            if(updateUser.getGender() != null)
                currentUser.setGender(updateUser.getGender());

            if(updateUser.getBirthday() != null)
                currentUser.setBirthday(updateUser.getBirthday());

            // Check if the email is different from the current user's email
            if (!updateUser.getEmail().equals(currentUser.getEmail())) {
                // Check if the email is already used by other users
                if (existingUserByEmail != null) {
                    model.addAttribute("manager", new Manager());
                    model.addAttribute("error", "Email already used. Please use another email.");
                    model.addAttribute("user", currentUser);
                    return "userInfo";
                }
            }
            // Update the email
            currentUser.setEmail(updateUser.getEmail());

            if(updateUser.getPhone() != null && !updateUser.getPhone().isEmpty())
                currentUser.setPhone(updateUser.getPhone());

            if(updateUser.getAbout() != null && !updateUser.getAbout().isEmpty())
                currentUser.setAbout(updateUser.getAbout());
        
               
            // Save updated user
            userRepo.save(currentUser);
            // Redirect to user home page
            return "redirect:/user_home_page";  
        }else
            return "redirect:/log_in";
        
    }

    @GetMapping("/user_msg")
    public String getUserMessagePage(Model m){
        m.addAttribute("user", new User());
        return "message";
    }

    @GetMapping("/user_appointment")
    public String getUserAppointmentPage(Model m){
        m.addAttribute("user", new User());
        return "myappointments";
    }

    @GetMapping("/user_changepsw")
    public String getUserChangePswPage(Model m){
        m.addAttribute("user", new User());
        return "changepassword";
    }

    @GetMapping("/user_delete")
    public String getUserCancelPage(Model m){
        m.addAttribute("user", new User());
        return "deleteaccount";
    }

    @GetMapping("/user_home_page/logout")
    public String logOut(HttpSession session) {
        session.invalidate(); // Clean user session
        return "redirect:/home_page"; // Redirect to home page
    }
    
    @PostMapping("/user_delete")
    public String deleteUser(@RequestParam String username,
                             @RequestParam String password,
                             HttpSession session,
                             RedirectAttributes redirectAttributes,
                             Model m) {
        User user = userRepo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Delete data from database, but keep the id only
            user.setUsername(null);
            user.setPassword(null);
            user.setEmail(null);
            userRepo.save(user);
            session.removeAttribute("user");
            return "redirect:/home_page";
        } else {
            // If username is not match to password, redirect to user_cancel page
            //redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
            m.addAttribute("error", "Invalid username or password.");
            return "deleteaccount";
        }
    }

    @GetMapping("/account-recovery")
    public String showAccountRecoveryForm(Model model) {
        model.addAttribute("user", new User());
        return "user/account-recovery";
    }

    @PostMapping("/account-recovery")
    public String accountRecovery(@ModelAttribute User user, Model model, HttpSession session) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            // User found, proceed with password reset
            session.setAttribute("user2", existingUser);
            return "user/password-reset";
        } else {
            // User not found, return error message
            model.addAttribute("error", "No user found with that email address");
        }
        return "user/account-recovery";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String newPassword, @RequestParam String confirmPassword, Model model, HttpSession session) {
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "user/password-reset";
        }

        // Get the user from the session
        User user = (User) session.getAttribute("user2");

        if (user != null) {
            // User found, update the password in the database
            user.setPassword(newPassword);
            userRepo.save(user);
            session.invalidate();
            model.addAttribute("success", "Reset password successful! Now you can get back to home page and log in!");
        } else {
            // User not found, return error message
            model.addAttribute("error", "User not found! (Maybe you've already reset the password)");
        }
        
        return "user/password-reset";
    }


    @PostMapping("/uploadAvatar")
    public String createOrUpdateTrainer(@RequestParam(name ="newAvatar",required = false) MultipartFile file, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser != null && file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String url = storeImage.store(file); // storeImage should have a method saveImage(MultipartFile file)
                
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/")
                    .path(fileName)
                    .toUriString();
        
            currentUser.setAvatarUrl(fileDownloadUri);
            userRepo.save(currentUser);

        }
        return "redirect:/user_home_page";
    }

}

//package com.company.web.controller;
//
//import java.util.UUID;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.company.web.entity.User;
//import com.company.web.service.UserService;
//
//@Controller
//public class RegisterController {
//
//    private UserService userService;
//
//    @Autowired
//    public RegisterController(UserService userService) {
//        this.userService = userService;
//    }
//
//    // Return registration form template
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("register");
//        return modelAndView;
//    }
//
//    // Process form input data
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {
//
//        // Lookup user in database by e-mail
//        User userExists = userService.getUserById(user.getId());
//
//        System.out.println(userExists);
//
//        // If doesn't exist
//        if (userExists != null) {
//            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
//            modelAndView.setViewName("register");
//            bindingResult.reject("id");
//        }
//
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("register");
//        } else {// new user so we create user
//
//            // Disable user&account
//            user.setEnabled(false);
//
//            // Generate random 36-character string token for confirmation link
//            user.setConfirmationToken(UUID.randomUUID().toString());
//
//            userService.saveUser(user);
//
//            modelAndView.setViewName("register");
//        }
//
//        return modelAndView;
//    }
//
//    // Process confirmation link
//    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
//    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
//
//        User account = userService.findByConfirmationToken(token);
//
//        if (account == null) { // No token found in DB
//            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
//        } else { // Token found
//            modelAndView.addObject("confirmationToken", account.getConfirmationToken());
//        }
//
//        modelAndView.setViewName("confirm");
//        return modelAndView;
//    }
//}
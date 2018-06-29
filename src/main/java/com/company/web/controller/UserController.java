package com.company.web.controller;

import com.company.web.entity.User;
import com.company.web.repository.UserRepository;
import com.company.web.service.SecurityService;
import com.company.web.service.UserService;
import com.company.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("users", new User());
        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("users") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/registration?error=" + String.join(",",
                    bindingResult.getAllErrors().stream().map(ObjectError::getCode).toArray(String[]::new));
        }
        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        model.addAttribute("posts", userRepository.findAll());
        return "redirect:/user";
    }

    @RequestMapping(value = "load", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "load";
    }

    @RequestMapping(value = {"/", "/user"}, method = RequestMethod.GET)
    public String welcome(Principal principal, Model model) {
        User byUsername = userRepository.findByUsername(principal.getName());
        model.addAttribute("user", byUsername);
        return "user";
    }
/**
 * Check if sender have sufficient amount of money, if so, transfer it to recipient.
 * @param userId Id of recipient in form of long.
 * @param amount amount of money to send from sender.
 * @param principal sender
 * @return redirects to/user
 * @throws Exception if recipient is not found
 */
    @Transactional
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public String transfer(@RequestParam Long userId, @RequestParam Integer amount, Principal principal) throws Exception {
        User sender = userRepository.findByUsername(principal.getName());
        if (amount<0){
            throw new Exception("Incorrect amount");
        }
        if (!userRepository.findById(userId).isPresent()) {
            throw new Exception("Does not exist");
        }
        User consignee = userRepository.findById(userId).get();
        if (sender.getBalance() < amount) {
            throw new Exception("No money no honey");
        }
        sender.setBalance(sender.getBalance() - amount);

        consignee.setBalance(consignee.getBalance() + amount);
        return "redirect:/user";
    }

    @Transactional
    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    public String recharge(@RequestParam Integer amount, Principal principal) throws Exception {
        User user = userRepository.findByUsername(principal.getName());
        if (amount<0){
            throw new Exception("Incorrect amount");
        }
        user.setBalance(user.getBalance() + amount);
        return "redirect:/user";
    }
}

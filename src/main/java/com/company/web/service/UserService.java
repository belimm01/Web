package com.company.web.service;

import com.company.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.web.entity.User;
import com.company.web.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    public List<User> getAllUsers() {
        for (User user : userRepository.findAll()) {
            System.out.println(user.toString());
        }
        return (List<User>) userRepository.findAll();
    }


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    public User updateUser(@PathVariable(value = "id") Long userId,
                           @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }


    public User updateBalance(@PathVariable(value = "id") Long accountId,
                                 @Valid @RequestBody User accountDetails) {

        User user = userRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

        user.setBalance(accountDetails.getBalance());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

}
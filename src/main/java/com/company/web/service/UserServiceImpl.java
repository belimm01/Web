package com.company.web.service;

import com.company.web.entity.User;
import com.company.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/**
 * Implementation of UserService. 
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    /**
     * Method saves user to database with its password.
     */
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    /**
     * Method finds user in database by Username.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    /**
     * Returns list of all found users in database.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }
}

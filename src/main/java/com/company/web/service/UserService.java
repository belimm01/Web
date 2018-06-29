package com.company.web.service;

import com.company.web.entity.User;

import java.util.List;
/**
 * Interface for UserService. Saving and founding users.
 * @author User
 */
public interface UserService {
    void save(User user);


    User findByUsername(String username);

    List<User> findAll();
}

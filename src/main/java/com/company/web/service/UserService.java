package com.company.web.service;

import com.company.web.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> findAll();
}

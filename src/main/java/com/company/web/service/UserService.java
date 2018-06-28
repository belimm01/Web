package com.company.web.service;

import com.company.web.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

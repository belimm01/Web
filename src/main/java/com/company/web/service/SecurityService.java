package com.company.web.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}

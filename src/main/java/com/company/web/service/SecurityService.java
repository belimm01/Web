package com.company.web.service;
/**
 * Interface for SecurityService of login.
 * @author User
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}

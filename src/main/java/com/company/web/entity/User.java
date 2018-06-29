package com.company.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
/**
 * Getting values from database and setting to attributes. 
 */
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_balance")
    private int balance;

    @Transient
    private String passwordConfirm;
/**
 * Getter for userId.
 * @return got id from database.
 */
    public Long getId() {
        return id;
    }
/**
 * Setter for id.
 * @param id id of user.
 */
    public void setId(Long id) {
        this.id = id;
    }
/**
 * Getter for userName.
 * @return got userName from database.
 */
    public String getUsername() {
        return username;
    }
/**
 * Setter for username.
 * @param username name of user.
 */
    public void setUsername(String username) {
        this.username = username;
    }
/**
 * Getter for password.
 * @return got password from database.
 */
    public String getPassword() {
        return password;
    }
/**
 * Setter for password..
 * @param password password of user.
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * Getter for balance.
 * @return got balance from database.
 */
    public int getBalance() {
        return balance;
    }
/**
 * Setter for balance.
 * @param balance balance of user.
 */
    public void setBalance(int balance) {
        this.balance = balance;
    }
/**
 * 
 * @return 
 */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
/**
 * 
 * @param passwordConfirm 
 */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

}

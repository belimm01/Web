package com.company.web.repository;

import com.company.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// You will now be able to use JpaRepository’s methods
// like save(),findOne(),findAll(),count(),delete()etc.

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}




package com.company.web.repository;

import com.company.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// You will now be able to use JpaRepository’s methods
// like save(),findOne(),findAll(),count(),delete()etc.

@Repository
/**
 * Interface for working with users in database.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findById(Long id);
}




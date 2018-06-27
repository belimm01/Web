package com.company.web.repository;

import com.company.web.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// You will now be able to use JpaRepository’s methods
// like save(),findOne(),findAll(),count(),delete()etc.

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByConfirmationToken(String confirmationToken);
}



package com.company.web.repository;

import com.company.web.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Interface for working with roles in database.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

}

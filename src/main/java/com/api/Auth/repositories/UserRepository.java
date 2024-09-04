package com.api.Auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.Auth.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}

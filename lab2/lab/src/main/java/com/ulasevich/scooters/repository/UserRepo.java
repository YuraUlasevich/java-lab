package com.ulasevich.scooters.repository;

import com.ulasevich.scooters.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}

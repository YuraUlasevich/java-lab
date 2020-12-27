package com.ulasevich.scooters.repository;

import com.ulasevich.scooters.domain.Order;
import com.ulasevich.scooters.domain.Scooters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser_id(Long userId);

    boolean existsByScooterIdAndStatus(Long scooterId, String status);
}

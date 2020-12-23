package com.ulasevich.scooters.repository;

import com.ulasevich.scooters.domain.Scooters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScootersRepository  extends JpaRepository<Scooters, Long> {
    List<Scooters> findByLocation(String location);
    //Scooters (Long id);
}

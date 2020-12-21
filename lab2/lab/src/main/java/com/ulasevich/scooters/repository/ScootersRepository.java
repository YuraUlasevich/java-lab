package com.ulasevich.scooters.repository;

import com.ulasevich.scooters.domain.Scooters;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScootersRepository  extends CrudRepository<Scooters, Long> {
    List<Scooters> findByLocation(String location);

    void delete(Scooters scooters);
    //List<Scooters> findById(Long id);
}

package com.ulasevich.scooters.Service;

import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Scooters;
import com.ulasevich.scooters.domain.User;
import com.ulasevich.scooters.repository.ScootersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScooterService {

    @Autowired
    ScootersRepository scootersRepository;
    public void saveScooter(String location, Integer charge_level, Scooters scooter) {
        scooter.setLocation(location);
        scooter.setCharge_level(charge_level);
        scootersRepository.save(scooter);
    }
}

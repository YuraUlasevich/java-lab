package com.ulasevich.scooters.repository;

import com.ulasevich.scooters.domain.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

}

package com.ulasevich.scooters.Service;

import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Users;
import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(Users users){
        Users usersDB = userRepo.findByUsername(users.getUsername());

        if (usersDB != null){
            return false;
        }
        users.setActive(true);
        users.setRole(Collections.singleton(Role.USER));
        users.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(users);

        if (!StringUtils.isEmpty(users.getEmail())){
            String message = String.format(
                    "Hello, %s! \n"+
                            "Welcome to Scooters. Please visit next link: http://localhost:8080/activate/%s",
                    users.getUsername(), users.getActivationCode()
            );
            mailSender.send(users.getEmail(), "Activation code", message);
        }
        return true;
    }

    public boolean activateUser(String code) {
        Users users = userRepo.findByActivationCode(code);

        if (users == null){
            return false;
        }

        users.setActivationCode(null);
        userRepo.save(users);

        return true;
    }
}

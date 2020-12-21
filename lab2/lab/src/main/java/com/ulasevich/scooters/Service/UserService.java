package com.ulasevich.scooters.Service;

import com.ulasevich.scooters.domain.Role;
import com.ulasevich.scooters.domain.Users;
import com.ulasevich.scooters.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MailSender mailSender;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


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
        //users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepo.save(users);

        sendMessage(users);
        return true;
    }

    private void sendMessage(Users users) {
        if (!StringUtils.isEmpty(users.getEmail())){
            String message = String.format(
                    "Hello, %s! \n"+
                            "Welcome to Scooters. Please visit next link: http://localhost:8080/activate/%s",
                    users.getUsername(), users.getActivationCode()
            );
            mailSender.send(users.getEmail(), "Activation code", message);
        }
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

    public List<Users> findAll() {
        return userRepo.findAll();
    }

    public void saveUser(Users user, String username, Map<String, String> form) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRole().clear();
        for (String key: form.keySet()) {
            if (roles.contains(key)){
                user.getRole().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
    }

    public void updateProfile(Users user, String password, String email) {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));
        if(isEmailChanged){
            user.setEmail(email);
            if (!StringUtils.isEmpty(email)){
                user.setActivationCode(UUID.randomUUID().toString());

            }
        }
        if (!StringUtils.isEmpty(password)){
            user.setPassword(password);
        }
        userRepo.save(user);
        if(isEmailChanged)
            sendMessage(user);
    }
}

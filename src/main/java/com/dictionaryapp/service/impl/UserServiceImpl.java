package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.DTo.UserLoginDTO;
import com.dictionaryapp.model.DTo.UserRegistrationDTO;
import com.dictionaryapp.model.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoginUser loginUser;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, LoginUser loginUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.loginUser = loginUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegistrationDTO userRegistrationDTO) {
         if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
             return false;
         }
        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationDTO.getUsername());
        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationDTO.getEmail());
        if (byUsername.isPresent() || byEmail.isPresent()) {
              return false;
         }
        User user = new User();
         user.setUsername(userRegistrationDTO.getUsername());
         user.setEmail(userRegistrationDTO.getEmail());
         user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
         this.userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> byUsername = this.userRepository.findByUsername(userLoginDTO.getUsername());
        if (byUsername.isPresent() && passwordEncoder.matches(userLoginDTO.getPassword(),byUsername.get().getPassword())) {
            this.loginUser.setUsername(userLoginDTO.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.loginUser.logout();
    }
}

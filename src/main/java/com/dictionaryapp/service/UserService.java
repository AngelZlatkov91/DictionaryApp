package com.dictionaryapp.service;

import com.dictionaryapp.model.DTo.UserLoginDTO;
import com.dictionaryapp.model.DTo.UserRegistrationDTO;

public interface UserService {

    boolean register(UserRegistrationDTO userRegistrationDTO);
    boolean login(UserLoginDTO userLoginDTO);

    void logout();

}

package com.codesoftlution.tallerSmartBackend.services;

import com.codesoftlution.tallerSmartBackend.models.UserModel;
import com.codesoftlution.tallerSmartBackend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository iUserRepository;

    public List<UserModel> getUsers(){
        return iUserRepository.findAll();
    }

    public UserModel saveUsers(UserModel userModel){
        return iUserRepository.save(userModel);
    }
}

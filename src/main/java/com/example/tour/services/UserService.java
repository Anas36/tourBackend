package com.example.tour.services;

//Business Logic layer

import com.example.tour.data.UserRepo;
import com.example.tour.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepo userRepo;


    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }

    public User getUserById(long id) {
        return userRepo.findById(id).orElse(null);
    }
}

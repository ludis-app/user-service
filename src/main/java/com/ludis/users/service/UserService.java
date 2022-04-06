package com.ludis.users.service;

import com.ludis.users.model.User;
import com.ludis.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUserItems() {
        System.out.println("Data creation started...");
        userRepository.save(new User(1, "John Doe", "johnyd", "12345", "UK"));
        userRepository.save(new User(2, "Jane Doe", "janee", "5425", "US"));
        userRepository.save(new User(3, "me :)", "dima", "6246547", "Bulgaria"));
        userRepository.save(new User(4, "John Doe The Second", "johnyd2", "12345", "Chile"));
        System.out.println("Data creation complete...");
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

package com.ludis.userservice.service;

import com.ludis.userservice.model.User;
import com.ludis.userservice.repository.UserRepository;
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
        userRepository.save(new User(1, "John Doe", "johnyd", "johny@hotmail.com", "12345", "UK"));
        userRepository.save(new User(2, "Jane Doe", "janee", "jane@hotmail.com","5425", "US"));
        userRepository.save(new User(3, "me :)", "dima", "dima@gmail.com","6246547", "Bulgaria"));
        userRepository.save(new User(4, "John Doe The Second", "johnyd2", "second@gmail.com","12345", "Chile"));
        System.out.println("Data creation complete...");
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

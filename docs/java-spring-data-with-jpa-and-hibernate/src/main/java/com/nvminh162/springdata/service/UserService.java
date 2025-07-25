package com.nvminh162.springdata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nvminh162.springdata.domain.User;
import com.nvminh162.springdata.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> handleGetAllUser() {
        return this.userRepository.findAll();
    }

    public User handleFindById(long id) {
        return this.userRepository.findById(id);
    }

    public void handleDeleteById(long id) {
        this.userRepository.deleteById(id);
    }
}
package com.nvminh162.laptopshop.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nvminh162.laptopshop.domain.Role;
import com.nvminh162.laptopshop.domain.User;
import com.nvminh162.laptopshop.repository.RoleRepository;
import com.nvminh162.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User saveAUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteAUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleById(long id) {
        return this.roleRepository.findById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}

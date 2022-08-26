package com.example.practicaapx.services;


import com.example.practicaapx.model.User;
import com.example.practicaapx.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository usRepository;

    public UserServiceImpl(UserRepository usRepository) {
        this.usRepository = usRepository;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        usRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return usRepository.findById(id).get();
    }

    @Override
    public User insert(User us) {
        return usRepository.save(us);
    }

    @Override
    public void updateUser(Long id, User us) {
        User userFromDb = usRepository.findById(id).get();
        
        userFromDb.setEmail(us.getEmail());
        userFromDb.setFirstName(us.getFirstName());
        userFromDb.setLastName(us.getLastName());
        userFromDb.setAvatar(us.getAvatar());
        usRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long todoId) {
        usRepository.deleteById(todoId);
    }
}

package com.example.practicaapx.services;

import com.example.practicaapx.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Long id);

    User insert(User us);

    void updateUser(Long id, User us);

    void deleteUser(Long userId);
}

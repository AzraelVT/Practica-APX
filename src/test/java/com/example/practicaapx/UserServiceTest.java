package com.example.practicaapx;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.practicaapx.model.User;
import com.example.practicaapx.repositories.UserRepository;
import com.example.practicaapx.services.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Autowired
    @InjectMocks
    private UserServiceImpl userService;
    private User user1;
    private User user2;
    List<User> userList;
    @BeforeEach
    public void setUp() {
    	userList = new ArrayList<>();
    	user1 = new User("rebar@gmail.com", "Pedro", "Perez", "Avatar1");
    	user2 = new User("paron@gmail.com", "Cesar", "Mendez", "Avatar2");
    	userList.add(user1);
    	userList.add(user2);
    }
    @AfterEach
    public void tearDown() {
    	user1 = user2 = null;
    	userList = null;
    }
}
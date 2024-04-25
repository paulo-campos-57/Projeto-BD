package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.User;
import com.id.project_bd.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String createUser(@RequestBody User user) {
        userRepository.insertUser(user);
        return "Usuário criado com sucesso!\n";
    }

    @DeleteMapping
    public String deleteUser(@RequestBody User user) {
        userRepository.deleteUser(user);
        return "Usuário deletado com sucesso!\n";
    }
}

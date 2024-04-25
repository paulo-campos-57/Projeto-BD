package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.User;
import com.id.project_bd.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping
    public List<User> getUser() {
        return userRepository.getAllUsers();
    }

    @PutMapping("/{id_user}")
    public String updateUser(@PathVariable int id_user, @RequestBody User user) {
        user.setId_user(id_user);
        userRepository.updateUser(user);
        return "Endereço do user " + user.getId_user() + " com sucesso!\n";
    }
}

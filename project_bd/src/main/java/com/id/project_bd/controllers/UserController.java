package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.User;
import com.id.project_bd.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView userForm(User user) {
        userRepository.insertUser(user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sucesso");
        return mv;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userRepository.insertUser(user);
        return "Usuário " + user.getId_user() + " criado com sucesso!\n";
    }

    @DeleteMapping("/{id_user}")
    public String deleteUser(@PathVariable int id_user) {
        boolean deleted = userRepository.deleteUser(id_user);
        if (deleted) {
            return "Usuário " + id_user + " deletado com sucesso!\n";
        } else {
            return "Usuário com ID " + id_user + " não encontrado para exclusão.\n";
        }
    }

    @GetMapping
    public List<User> getUser() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/lista")
    public ModelAndView getAllUsers() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getAllUsers());
        mv.setViewName("listaUsuarios");
        return mv;
    }

    @GetMapping("/{id_user}")
    public ModelAndView getSpecificUser(@PathVariable int id_user) {
        User user = userRepository.getUserById(id_user);
        ModelAndView mv = new ModelAndView();
        if (user != null) {
            mv.addObject("user", user);
            mv.setViewName("detalhesUsuario");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    @PutMapping("/{id_user}")
    public String updateUser(@PathVariable int id_user, @RequestBody User user) {
        user.setId_user(id_user);
        userRepository.updateUser(user);
        return "Endereço do user " + user.getId_user() + " com sucesso!\n";
    }
}
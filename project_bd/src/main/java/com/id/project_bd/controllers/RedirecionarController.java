package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.User;
import com.id.project_bd.repository.UserRepository;

@RestController
@RequestMapping("/redirecionar")
public class RedirecionarController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id_user}")
    public ModelAndView redirecionar(@PathVariable("id_user") int id_user) {
        User user = userRepository.getUserById(id_user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirecionar");
        mv.addObject("user", user);
        return mv;
    }
}

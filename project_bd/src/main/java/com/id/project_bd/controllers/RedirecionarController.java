package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Historia;
import com.id.project_bd.models.User;
import com.id.project_bd.repository.HistoriaRepository;
import com.id.project_bd.repository.UserRepository;

@RestController
@RequestMapping("/redirecionar")
public class RedirecionarController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoriaRepository historiaRepository;

    @GetMapping("/usuario/{id_user}")
    public ModelAndView redirecionarUsuario(@PathVariable("id_user") int id_user) {
        User user = userRepository.getUserById(id_user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirecionarUsuario");
        mv.addObject("user", user);
        return mv;
    }

    @GetMapping("/historia/{id_historia}")
    public ModelAndView redirecionarHIstoria(@PathVariable("id_historia") int id_historia){
        Historia historia = historiaRepository.getHistoriaById(id_historia);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirecionarHisoria");
        mv.addObject("historia", historia);
        return mv;
    }
}

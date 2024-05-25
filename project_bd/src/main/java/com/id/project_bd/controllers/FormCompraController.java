package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.repository.UserRepository;

@RestController
@RequestMapping("/finalizar")
public class FormCompraController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/compra/{id_produto}")
    public ModelAndView finalizarCompra() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("compraForm");
        return mv;
    }

    @GetMapping("/compra/verificar/{id_produto}")
    public ModelAndView verificarCompra(@PathVariable String id_produto, @RequestParam String username) {
        ModelAndView mv = new ModelAndView();

        boolean userExists = userRepository.existsByUsername(username);

        if (userExists) {
            mv.setViewName("compraSucesso");
        } else {
            mv.setViewName("compraFalha");
        }

        return mv;
    }

}

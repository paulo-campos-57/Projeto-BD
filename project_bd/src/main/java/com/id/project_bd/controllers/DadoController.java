package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Dado;
import com.id.project_bd.repository.DadoRepository;

@RestController
@RequestMapping("/dados")
public class DadoController {
    
    @Autowired
    private DadoRepository dadoRepository;

    @PostMapping
    public String createDado(@RequestBody Dado dado) {
        dadoRepository.insertDado(dado);
        System.out.println(dado.getFk_id_produto());
        System.out.println(dado.getQtd_lados());
        return "Dado inserido!";
    }
}

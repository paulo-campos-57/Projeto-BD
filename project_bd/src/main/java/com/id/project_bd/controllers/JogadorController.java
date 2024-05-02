package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Jogador;
import com.id.project_bd.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @PostMapping
    public String createJogador(@RequestBody Jogador jogador){
        jogadorRepository.insertJogador(jogador);
        return "Jogador inserido!\n";
    }
}

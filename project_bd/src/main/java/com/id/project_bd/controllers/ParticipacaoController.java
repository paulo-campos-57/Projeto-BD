package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Participacao;
import com.id.project_bd.repository.ParticipacaoRepository;

@RestController
@RequestMapping("/participacao")
public class ParticipacaoController {
    
    @Autowired
    private ParticipacaoRepository participacaoRepository;

    @PostMapping
    public String createParticipacao(@RequestBody Participacao participacao){
        participacaoRepository.insertParticipacao(participacao);
        return "Participacao inserida!\n";
    }

    @GetMapping
    public List<Participacao> getParticipacao(){
        return participacaoRepository.getAllParticipacao();
    }
}

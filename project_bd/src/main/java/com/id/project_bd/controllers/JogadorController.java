package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @DeleteMapping("/{fk_id_user}")
    public String deletejogador(@PathVariable int fk_id_user){
        boolean deleted = jogadorRepository.deleteJogador(fk_id_user);
        if(deleted){
            return "Jogador deletado!\n";
        } else {
            return "O jogador com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Jogador> getJogador(){
        return jogadorRepository.getAllJogadores();
    }

    //Não criei PUT de jogador pois ele não tem nada pra mudar
}

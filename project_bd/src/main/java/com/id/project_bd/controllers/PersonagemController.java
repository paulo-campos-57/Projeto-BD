package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Personagem;
import com.id.project_bd.repository.PersonagemRepository;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    @PostMapping
    public String createPersonagem(@RequestBody Personagem personagem) {
        personagemRepository.insertPersonagem(personagem);
        return "Personagem inserido com sucesso!\n";
    }

    @DeleteMapping("/{id_personagem}")
    public String deletePersonagem(@PathVariable int id_personagem) {
        boolean deleted = personagemRepository.deletePersonagem(id_personagem);
        if (deleted) {
            return "Personagem " + id_personagem + " deletado com sucesso!\n";
        } else {
            return "Personagem " + id_personagem + " não encontrado no banco de dados\n";
        }
    }

    @GetMapping
    public List<Personagem> getPersonagens(){
        return personagemRepository.getAllPersonagens();
    }

    @PutMapping("/{id_personagem}")
    public String updatePersonagem(@PathVariable int id_personagem, @RequestBody Personagem personagem){
        personagem.setId_personagem(id_personagem);
        personagemRepository.updatePersonagem(personagem);
        return "Personagem "+ id_personagem + " modificado com sucesso!\n";
    }

}

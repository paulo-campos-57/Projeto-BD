package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Historia;
import com.id.project_bd.repository.HistoriaRepository;

@RestController
@RequestMapping("/historia")
public class HistoriaController {

    @Autowired
    private HistoriaRepository historiaRepository;

    @PostMapping
    public String createHistoria(@RequestBody Historia historia){
        historiaRepository.insertHistoria(historia);
        return "Historia criada!\n";
    }

    @DeleteMapping("/{id_historia}")
    public String deleteHistoria(@PathVariable int id_historia){
        boolean deleted = historiaRepository.deleteHistoria(id_historia);
        if(deleted){
            return "Historia deletada!\n";
        } else {
            return "A historia com essas informações não existe!\n";
        }
    }
}

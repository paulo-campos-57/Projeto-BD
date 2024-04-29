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
        return "Dado inserido!";
    }

    @DeleteMapping("/{fk_id_produto}")
    public String deleteDado(@PathVariable int fk_id_produto) {
        boolean deleted = dadoRepository.deleteDado(fk_id_produto);
        if (deleted) {
            return "Dado removido.\n";
        } else {
            return "O dado com essas informações não existe no banco de dados.\n";
        }
    }

    @GetMapping
    public List<Dado> getDado() {
        return dadoRepository.getAllDados();
    }

    @PutMapping("/{fk_id_produto}")
    public String updateDado(@PathVariable int fk_id_produto, @RequestBody Dado dado) {
        dado.setFk_id_produto(fk_id_produto);
        dadoRepository.updateDado(dado);
        return "Informações sobre o dado salvas com sucesso.\n";
    }
}

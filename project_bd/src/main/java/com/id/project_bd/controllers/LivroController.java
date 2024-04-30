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

import com.id.project_bd.models.Livro;
import com.id.project_bd.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public String createLivro(@RequestBody Livro livro){
        livroRepository.insertLivro(livro);
        return "Livro inserido!\n";
    }

    @DeleteMapping("/{fk_id_produto}")
    public String deleteLivro(@PathVariable int fk_id_produto){
        boolean deleted = livroRepository.deleteLivro(fk_id_produto);
        if (deleted){
            return "Livro removido!\n";
        } else {
            return "O livro com essas informações não existe no banco de dados!\n";
        }

    }

    @GetMapping
    public List<Livro> getLivro(){
        return livroRepository.getAllLivros();
    }

    @PutMapping("/{fk_id_produto}")
    public String updateLivro(@PathVariable int fk_id_produto, @RequestBody Livro livro){
        livro.setFk_id_produto(fk_id_produto);
        livroRepository.updateLivro(livro);
        return "Informações salvas com sucesso!\n";
    }
}

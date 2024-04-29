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

import com.id.project_bd.models.Produto;
import com.id.project_bd.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public String createProduto(@RequestBody Produto produto){
        produtoRepository.insertProduto(produto);
        return "Produto " + produto.getId_produto() + " cadastrado com sucesso!\n";
    }

    @DeleteMapping("/{id_produto}")
    public String deleteProduto(@PathVariable int id_produto){
        boolean deleted = produtoRepository.deleteProduto(id_produto);
        if (deleted) {
            return "Produto " + id_produto + " deletado com sucesso!\n";
        } else {
            return "Produto " + id_produto + " não encontradp para exclusão!\n";
        }
    }

    @GetMapping
    public List<Produto> getProdutos(){
        return produtoRepository.getAllProdutos();
    }

    @PutMapping("/{id_produto}")
    public String updateProduto(@PathVariable int id_produto, @RequestBody Produto produto){
        produto.setIdproduto(id_produto);
        produtoRepository.updateProduto(produto);
        return "Valores do produto "+ id_produto + " atualizado com sucesso!\n";
    }
}

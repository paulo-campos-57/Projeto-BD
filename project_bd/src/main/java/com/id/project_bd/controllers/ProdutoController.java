package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Produto;
import com.id.project_bd.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public String createProduto(@RequestBody Produto produto) {
        produtoRepository.insertProduto(produto);
        return "Produto " + produto.getIdProduto() + " cadastrado com sucesso!\n";
    }

    @PutMapping("/{id_produto}")
    public String updateProduto(@PathVariable int id_produto, @RequestBody Produto produto) {
        produto.setIdProduto(id_produto);
        produtoRepository.updateProduto(produto);
        return "Produto do id " + produto.getIdProduto() + " atualizado com sucesso!\n";
    }
    
    
}

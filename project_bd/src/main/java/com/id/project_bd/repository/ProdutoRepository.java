package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Produto;

@Repository
public class ProdutoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Inserir no banco de dados o produto
    public void insertProduto(Produto produto){
        jdbcTemplate.update("INSERT INTO PRODUTO(NOME_PRODUTO, DESCRICAO, PRECO) VALUES (?, ?, ?)",
        produto.getnomeProduto(), produto.getDescricao(), produto.getPreco());
    }

}

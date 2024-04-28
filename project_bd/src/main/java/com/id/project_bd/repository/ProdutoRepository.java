package com.id.project_bd.repository;

import java.util.List;

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

        // Obter o ID gerado e atribuí-lo ao produto
        Integer idGerado = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        produto.setIdProduto(idGerado);
    }

    public void deleteProduto(Produto produto){
        jdbcTemplate.update("DELETE FROM PRODUTO WHERE ID_PRODUTO = ?", produto.getIdProduto());

        Integer idGerado = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        produto.setIdProduto(idGerado);
    }

    public List<Produto> getAllProdutos(){
        return jdbcTemplate.query("SELECT * FROM PRODUTO", (resultSet, rowNum) -> {
            Produto produto = new Produto();
            produto.setIdProduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnomeProduto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            return produto;
        });
    }

    //alterando o valor de descrição e preco em produto
    public void updateProduto(Produto produto){
        jdbcTemplate.update("UPDATE PRODUTO SET DESCRICAO = ?, PRECO = ? WHERE ID_PRODUTO = ?",
        produto.getDescricao(), produto.getPreco(), produto.getIdProduto());
    }

}

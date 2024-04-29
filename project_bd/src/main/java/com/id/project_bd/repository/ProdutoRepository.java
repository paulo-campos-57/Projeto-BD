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

    // inserir produto no banco de dados
    public void insertProduto(Produto produto) {
        jdbcTemplate.update("INSERT INTO PRODUTO(ID_PRODUTO, NOME_PRODUTO, DESCRICAO, PRECO) VALUES(?, ?, ?, ?)",
                produto.getId_produto(), produto.getnome_produto(), produto.getDescricao(), produto.getPreco());
    }

    // deletando um produto do banco de dados
    public boolean deleteProduto(int id_produto) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM PRODUTO WHERE ID_PRODUTO = ?", id_produto);
        return rowsAffected > 0;
    }

    public List<Produto> getAllProdutos() {
        return jdbcTemplate.query("SELECT * FROM PRODUTO", (resultSet, rowNum) -> {
            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            return produto;
        });
    }

    public void updateProduto(Produto produto) {
        jdbcTemplate.update("UPDATE PRODUTO SET DESCRICAO = ?, PRECO = ? WHERE ID_PRODUTO = ?",
                produto.getDescricao(), produto.getPreco(), produto.getId_produto());
    }
}

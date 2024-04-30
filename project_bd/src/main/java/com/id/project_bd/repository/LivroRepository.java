package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Livro;
import com.id.project_bd.models.Produto;

@Repository
public class LivroRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLivro(Livro livro){
        jdbcTemplate.update("INSERT INTO LIVRO(FK_ID_PRODUTO, QTD_PAGINAS, ESTADO) VALUES(?, ?, ?)",
        livro.getFk_id_produto(), livro.getQtd_paginas(), livro.getEstado());
    }

    public boolean deleteLivro(int fk_id_produto){
        int rowsAffected = jdbcTemplate.update("DELETE FROM LIVRO WHERE FK_ID_PRODUTO = ?", fk_id_produto);
        return rowsAffected > 0;
    }

    public List<Livro> getAllLivros(){
        String sql = "SELECT L.FK_ID_PRODUTO, L.QTD_PAGINAS, L.ESTADO, P.ID_PRODUTO, P.NOME_PRODUTO, P.DESCRICAO, P.PRECO " +
                     "FROM LIVRO L " +
                     "INNER JOIN PRODUTO P ON L.FK_ID_PRODUTO = P.ID_PRODUTO";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Livro livro = new Livro();
            livro.setFk_id_produto(resultSet.getInt("FK_ID_PRODUTO"));
            livro.setQtd_paginas(resultSet.getInt("QTD_PAGINAS"));
            livro.setEstado(resultSet.getDouble("ESTADO"));

            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));

            livro.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            livro.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            livro.setDescricao(resultSet.getString("DESCRICAO"));
            livro.setPreco(resultSet.getDouble("PRECO"));
            return livro;

        });
    }

    public void updateLivro(Livro livro){
    jdbcTemplate.update("UPDATE LIVRO SET QTD_PAGINAS = ?, ESTADO = ? WHERE FK_ID_PRODUTO = ?", 
    livro.getQtd_paginas(), livro.getEstado(), livro.getFk_id_produto());
    }
}

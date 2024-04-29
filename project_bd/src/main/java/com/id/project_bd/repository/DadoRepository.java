package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Dado;

@Repository
public class DadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private boolean produtoExists(int id_produto) {
        String sql = "SELECT COUNT(*) FROM PRODUTO WHERE ID_PRODUTO = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, id_produto);
        return count > 0;
    }

    public void insertDado(Dado dado) {
        // Verifica se o id_produto existe na tabela PRODUTO
        if (produtoExists(dado.getId_produto())) {
            jdbcTemplate.update("INSERT INTO DADO(FK_ID_PRODUTO, QTD_LADOS) VALUES (?, ?)",
                    dado.getFk_id_produto(), dado.getQtd_lados());
        } else {
            throw new RuntimeException("ID_PRODUTO não encontrado na tabela PRODUTO.");
        }
    }

}

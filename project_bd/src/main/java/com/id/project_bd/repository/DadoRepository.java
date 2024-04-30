package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Dado;
import com.id.project_bd.models.Produto;

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

    public boolean deleteDado(int fk_id_produto) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM DADO WHERE FK_ID_PRODUTO = ?", fk_id_produto);
        return rowsAffected > 0;
    }

    public List<Dado> getAllDados() {
        String sql = "SELECT D.FK_ID_PRODUTO, D.QTD_LADOS, P.ID_PRODUTO, P.NOME_PRODUTO, P.DESCRICAO, P.PRECO " +
                "FROM DADO D " +
                "INNER JOIN PRODUTO P ON D.FK_ID_PRODUTO = P.ID_PRODUTO";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Dado dado = new Dado();
            dado.setFk_id_produto(resultSet.getInt("FK_ID_PRODUTO"));
            dado.setQtd_lados(resultSet.getInt("QTD_LADOS"));

            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));

            dado.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            dado.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            dado.setDescricao(resultSet.getString("DESCRICAO"));
            dado.setPreco(resultSet.getDouble("PRECO"));

            return dado;
        });
    }

    public void updateDado(Dado dado) {
        jdbcTemplate.update("UPDATE DADO SET QTD_LADOS = ? WHERE FK_ID_PRODUTO = ?",
                dado.getQtd_lados(), dado.getFk_id_produto());
    }

}

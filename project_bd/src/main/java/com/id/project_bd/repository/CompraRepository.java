package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Compra;
import com.id.project_bd.models.Produto;

@Repository
public class CompraRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCompra(Compra compra) {
        jdbcTemplate.update("INSERT INTO COMPRA (ID_COMPRA, ID_PRODUTO, ID_USER, DATA_COMPRA) VALUES (?, ?, ?, ?)",
            compra.getId_compra(), compra.getId_produto(), compra.getId_user(), compra.getData_compra());
    }

    public boolean deleteCompra(int idCompra) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM COMPRA WHERE ID_COMPRA = ?", idCompra);
        return rowsAffected > 0;
    }

    public List<Compra> getAllCompras() {
        String sql = "SELECT C.ID_COMPRA, C.ID_PRODUTO, C.ID_USER, C.DATA_COMPRA, " +
                     "P.NOME_PRODUTO, P.DESCRICAO, P.PRECO " +
                     "FROM COMPRA C " +
                     "INNER JOIN PRODUTO P ON C.ID_PRODUTO = P.ID_PRODUTO";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(resultSet.getInt("ID_COMPRA"));
            
            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            
            compra.setId_produto(produto);
            compra.setId_user(resultSet.getInt("ID_USER"));
            compra.setData_compra(resultSet.getDate("DATA_COMPRA"));

            return compra;
        });
    }

    public void updateCompra(Compra compra) {
        jdbcTemplate.update("UPDATE COMPRA SET ID_PRODUTO = ?, ID_USER = ?, DATA_COMPRA = ? WHERE ID_COMPRA = ?",
                compra.getId_produto().getId_produto(), compra.getId_user(), compra.getData_compra(), compra.getId_compra());
    }
}

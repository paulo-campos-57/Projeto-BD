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
        jdbcTemplate.update("INSERT INTO COMPRA(ID_COMPRA, FK_ID_PRODUTO, FK_ID_USER, DATA_COMPRA) VALUES(?, ?, ?, ?)",
                compra.getId_compra(), compra.getFk_id_produto(), compra.getFk_id_user(), compra.getData_compra());
    }

    public List<Compra> getAllCompras() {
        String sql = "SELECT C.ID_COMPRA, C.FK_ID_PRODUTO, C.FK_ID_USER, C.DATA_COMPRA, P.ID_PRODUTO, P.NOME_PRODUTO, P.DESCRICAO, P.PRECO " +
                        "FROM COMPRA C " +
                        "INNER JOIN PRODUTO P ON C.FK_ID_PRODUTO = P.ID_PRODUTO";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(resultSet.getInt("ID_COMPRA"));
            compra.setFk_id_produto(resultSet.getInt("FK_ID_PRODUTO"));
            compra.setFk_id_user(resultSet.getInt("FK_ID_USER"));
            compra.setData_compra(resultSet.getDate("DATA_COMPRA"));

            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));

            compra.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            compra.setnome_produto(resultSet.getString("NOME_PRODUTO"));
            compra.setDescricao(resultSet.getString("DESCRICAO"));
            compra.setPreco(resultSet.getDouble("PRECO"));

            return compra;
        });
    }
}
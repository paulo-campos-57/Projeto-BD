package com.id.project_bd.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Produto;

@Repository
public class ProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // inserir produto no banco de dados
    public Produto insertProduto(Produto produto) {
        String sql = "INSERT INTO PRODUTO(NOME_PRODUTO, DESCRICAO, PRECO, FK_ID_USER) VALUES(?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getnome_produto());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setInt(4, produto.getFk_id_user());
            return ps;
        }, keyHolder);

        int generatedId = keyHolder.getKey().intValue();
        produto.setIdproduto(generatedId);

        return produto;
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

package com.id.project_bd.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Produto;

@Repository
public class ProdutoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Produto> produtoMapper = new RowMapper<Produto>() {
        @Override
        public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
            Produto produto = new Produto(
                    rs.getInt("ID_PRODUTO"),
                    rs.getString("NOME_PRODUTO"),
                    rs.getString("DESCRICAO"),
                    rs.getDouble("PRECO"),
                    rs.getInt("FK_ID_USER"));
            return produto;
        }
    };

    // inserir produto no banco de dados
    public Produto insertProduto(Produto produto) {
        String sql = "INSERT INTO PRODUTO(NOME_PRODUTO, DESCRICAO, PRECO, FK_ID_USER) VALUES(?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getNome_produto());
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
        List<Produto> produtos = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM PRODUTO", (resultSet, rowNum) -> {
            Produto produto = new Produto();
            produto.setIdproduto(resultSet.getInt("ID_PRODUTO"));
            produto.setNome_produto(resultSet.getString("NOME_PRODUTO"));
            produto.setDescricao(resultSet.getString("DESCRICAO"));
            produto.setPreco(resultSet.getDouble("PRECO"));
            produto.setFk_id_user(resultSet.getInt("FK_ID_USER"));
            produtos.add(produto);
            return null;
        });
        return produtos;
    }

    public List<Produto> getSortedByName() {
        return jdbcTemplate.query("SELECT * FROM PRODUTO " +
        "ORDER BY NOME_PRODUTO ASC", produtoMapper);
    }

    public List<Produto> getSortedByPrice() {
        return jdbcTemplate.query("SELECT * FROM PRODUTO " +
        "ORDER BY PRECO ASC", produtoMapper);
    }

    public void updateProduto(Produto produto) {
        jdbcTemplate.update("UPDATE PRODUTO SET DESCRICAO = ?, PRECO = ? WHERE ID_PRODUTO = ?",
                produto.getDescricao(), produto.getPreco(), produto.getId_produto());
    }

    public Produto getProdutoById(int id_produto) {
        String sql = "SELECT * FROM PRODUTO WHERE ID_PRODUTO = ?";
        return jdbcTemplate.queryForObject(sql, produtoMapper, id_produto);
    }

}

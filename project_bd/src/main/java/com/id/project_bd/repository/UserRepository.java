package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.id.project_bd.models.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId_user(rs.getInt("ID_USER"));
            user.setUser_name(rs.getString("USER_NAME"));
            user.setSenha(rs.getString("SENHA"));
            user.setContato1(rs.getString("CONTATO1"));
            user.setContato2(rs.getString("CONTATO2"));
            user.setEstado(rs.getString("ESTADO"));
            user.setCidade(rs.getString("CIDADE"));
            user.setBairro(rs.getString("BAIRRO"));
            user.setRua(rs.getString("RUA"));
            user.setNumero(rs.getString("NUMERO"));
            user.setComplemento(rs.getString("COMPLEMENTO"));
            return user;
        }
    };

    // Inserir no banco de dados o user
    public void insertUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO USER(USER_NAME, SENHA, CONTATO1, CONTATO2, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, COMPLEMENTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUser_name(), user.getSenha(), user.getContato1(), user.getContato2(),
                user.getEstado(), user.getCidade(), user.getBairro(), user.getRua(), user.getNumero(),
                user.getComplemento());
        user.setId_user(user.getId_user());
    }

    // Excluir usuário com base no ID
    public boolean deleteUser(int id_user) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM USER WHERE ID_USER = ?", id_user);
        return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (usuário excluído)
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", (resultSet, rowNum) -> {
            User user = new User();
            user.setId_user(resultSet.getInt("ID_USER"));
            user.setUser_name(resultSet.getString("USER_NAME"));
            user.setSenha(resultSet.getString("SENHA"));
            user.setContato1(resultSet.getString("CONTATO1"));
            user.setContato2(resultSet.getString("CONTATO2"));
            user.setEstado(resultSet.getString("ESTADO"));
            user.setCidade(resultSet.getString("CIDADE"));
            user.setBairro(resultSet.getString("BAIRRO"));
            user.setRua(resultSet.getString("RUA"));
            user.setNumero(resultSet.getString("NUMERO"));
            user.setComplemento(resultSet.getString("COMPLEMENTO"));
            return user;
        });
    }

    public User getUserById(int id_user) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID_USER = ?", userMapper, id_user);
    }

    public void updateUser(User user) {
        jdbcTemplate.update(
                "UPDATE USER SET CONTATO1 = ?, CONTATO2 = ?, ESTADO = ?, CIDADE = ?, BAIRRO = ?, RUA = ?, NUMERO =?, COMPLEMENTO = ? WHERE ID_USER = ?",
                user.getContato1(), user.getContato2(), user.getEstado(), user.getCidade(), user.getBairro(),
                user.getRua(), user.getNumero(),
                user.getComplemento(), user.getId_user());
    }
}

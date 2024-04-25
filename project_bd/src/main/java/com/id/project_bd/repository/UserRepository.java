package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.id.project_bd.models.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO USER(USER_NAME, SENHA, CONTATO1, CONTATO2, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, COMPLEMENTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUser_name(), user.getSenha(), user.getContato1(), user.getContato2(),
                user.getEstado(), user.getCidade(), user.getBairro(), user.getRua(), user.getNumero(),
                user.getComplemento());
    }

    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM USER WHERE ID_USER = ?", user.getId_user());
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

    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE USER SET ESTADO = ?, CIDADE = ?, BAIRRO = ?, RUA = ?, NUMERO =?, COMPLEMENTO = ? WHERE ID_USER = ?",
        user.getEstado(), user.getCidade(), user.getBairro(), user.getRua(), user.getNumero(), user.getComplemento(), user.getId_user());
    }
}

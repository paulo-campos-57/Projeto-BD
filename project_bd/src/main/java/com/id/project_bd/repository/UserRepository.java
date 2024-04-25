package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(User user) {
        jdbcTemplate.update("INSERT INTO USER(ID_USER, USER_NAME, SENHA, CONTATO1, CONTATO2, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, COMPLEMENTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
        user.getId_user(), user.getUser_name(), user.getSenha(), user.getContato1(), user.getContato2(), user.getEstado(), user.getCidade(), user.getBairro(), user.getRua(), user.getNumero(), user.getComplemento());
    }

    public void deleteUser(int cod) {
        jdbcTemplate.update("DELETE FROM USER WHERE ID_USER = ?", cod);
    }
}

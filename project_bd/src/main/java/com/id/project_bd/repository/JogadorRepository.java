package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Jogador;

@Repository
public class JogadorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertJogador(Jogador jogador){
        jdbcTemplate.update("INSERT INTO JOGADOR(FK_ID_USER) VALUES(?)", jogador.getFk_id_user());
        System.out.println("to aq");
        System.out.println(jogador.getFk_id_user());
    }
}

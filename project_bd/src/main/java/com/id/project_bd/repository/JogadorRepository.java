package com.id.project_bd.repository;

import java.util.List;

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

    public boolean deleteJogador(int fk_id_user){

        jdbcTemplate.update("DELETE FROM participacao WHERE FK_ID_PERSONAGEM = ?", fk_id_user);

        int rowsAffected = jdbcTemplate.update("DELETE FROM JOGADOR WHERE FK_ID_USER = ?", fk_id_user);
        return rowsAffected > 0;
    }

    public List<Jogador> getAllJogadores(){
        return jdbcTemplate.query("SELECT * FROM JOGADOR", (resultSet, rowNum) -> {
            Jogador jogador = new Jogador();
            jogador.setFk_id_user(resultSet.getInt("FK_ID_USER"));
            return jogador;
        });
    }
}

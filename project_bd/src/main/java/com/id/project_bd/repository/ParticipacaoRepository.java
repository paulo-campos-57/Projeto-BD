package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Participacao;

@Repository
public class ParticipacaoRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertParticipacao(Participacao participacao){
        jdbcTemplate.update("INSERT INTO PARTICIPACAO(FK_ID_PERSONAGEM, FK_ID_MESTRE, FK_ID_HISTORIA) VALUES(?, ?, ?)", 
        participacao.getfk_id_personagem(), participacao.getfk_id_mestre(), participacao.getfk_id_historia());
    }

    public List<Participacao> getAllParticipacao(){
        return jdbcTemplate.query("SELECT * FROM PARTICIPACAO", (resultSet, rowNum) -> {
            Participacao participacao = new Participacao();
            participacao.setfk_id_personagem(resultSet.getInt("FK_ID_PERSONAGEM"));
            participacao.setfk_id_mestre(resultSet.getInt("FK_ID_MESTRE"));
            participacao.setfk_id_historia(resultSet.getInt("FK_ID_HISTORIA"));
            return participacao;
        });
    }
}

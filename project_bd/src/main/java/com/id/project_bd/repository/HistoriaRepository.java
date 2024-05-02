package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Historia;

@Repository
public class HistoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertHistoria(Historia historia){
        jdbcTemplate.update("INSERT INTO HISTORIA(ID_HISTORIA, NOME, PROLOGO, QTD_JOGADORES, DT_INICIO, PRESENCIAL, FK_ID_MESTRE) VALUES(?, ?, ?, ?, ?, ?, ?)", 
        historia.getIdhistoria(), historia.getNome(), historia.getPrologo(), historia.getQtd_jogadores(), historia.getDt_inicio(), historia.isPresencial(), historia.getFk_id_mestre());
    }

    public boolean deleteHistoria(int id_historia){
        int rowsAffected = jdbcTemplate.update("DELETE FROM HISTORIA WHERE ID_HISTORIA = ?", id_historia);
        return rowsAffected > 0;
    }
}

package com.id.project_bd.repository;

import java.util.List;

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

    public List<Historia> getAllHistoria(){
        return jdbcTemplate.query("SELECT * FROM HISTORIA", (resultSet, rowNum) -> {
            Historia historia = new Historia();
            historia.setIdhistoria(resultSet.getInt("ID_HISTORIA"));
            historia.setNome(resultSet.getString("NOME"));
            historia.setPrologo(resultSet.getString("PROLOGO"));
            historia.setQtd_jogadores(resultSet.getInt("QTD_JOGADORES"));
            historia.setDt_inicio(resultSet.getDate("DT_INICIO"));
            historia.setPresencial(resultSet.getBoolean("PRESENCIAL"));
            historia.setFk_id_mestre(resultSet.getInt("FK_ID_MESTRE"));
            return historia;
        });
    }

    public void updateHistoria(Historia historia){
        jdbcTemplate.update("UPDATE HISTORIA SET NOME = ?, PROLOGO = ?, QTD_JOGADORES = ?, PRESENCIAL = ? WHERE ID_HISTORIA = ?", 
        historia.getNome(), historia.getPrologo(), historia.getQtd_jogadores(), historia.isPresencial(), historia.getIdhistoria());
    }
}

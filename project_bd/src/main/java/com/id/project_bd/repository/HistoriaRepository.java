package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Historia;
import com.id.project_bd.models.Mestre;

@Repository
public class HistoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertHistoria(Historia historia){
        jdbcTemplate.update("INSERT INTO HISTORIA(NOME, PROLOGO, QTD_JOGADORES, DT_INICIO, PRESENCIAL, FK_ID_MESTRE) VALUES(?, ?, ?, ?, ?, ?)", 
        historia.getNome(), historia.getPrologo(), historia.getQtd_jogadores(), historia.getDt_inicio(), historia.isPresencial(), historia.getFk_id_mestre());
        historia.setId_historia(historia.getId_historia());
    }

    public boolean deleteHistoria(int id_historia){

        jdbcTemplate.update("DELETE FROM participacao WHERE FK_ID_HISTORIA = ?", id_historia);
    

        int rowsAffected = jdbcTemplate.update("DELETE FROM HISTORIA WHERE ID_HISTORIA = ?", id_historia);
        return rowsAffected > 0;
    }

    public List<Historia> getAllHistoria(){
        return jdbcTemplate.query("SELECT * FROM HISTORIA", (resultSet, rowNum) -> {
            Historia historia = new Historia();
            historia.setId_historia(resultSet.getInt("ID_HISTORIA"));
            historia.setNome(resultSet.getString("NOME"));
            historia.setPrologo(resultSet.getString("PROLOGO"));
            historia.setQtd_jogadores(resultSet.getInt("QTD_JOGADORES"));
            historia.setDt_inicio(resultSet.getDate("DT_INICIO"));
            historia.setPresencial(resultSet.getBoolean("PRESENCIAL"));
            historia.setFk_id_mestre(resultSet.getInt("FK_ID_MESTRE"));
            return historia;
        });
    }

    @SuppressWarnings("deprecation")
    public Historia getHistoriaById(int id_historia){
        String sql = "SELECT * FROM HISTORIA WHERE ID_HISTORIA = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{id_historia}, new BeanPropertyRowMapper<>(Historia.class));
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public void updateHistoria(Historia historia){
        jdbcTemplate.update("UPDATE HISTORIA SET NOME = ?, PROLOGO = ?, QTD_JOGADORES = ?, PRESENCIAL = ? WHERE ID_HISTORIA = ?", 
        historia.getNome(), historia.getPrologo(), historia.getQtd_jogadores(), historia.isPresencial(), historia.getId_historia());
    }
}

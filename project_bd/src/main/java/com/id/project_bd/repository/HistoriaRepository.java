package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Historia;
import com.id.project_bd.models.User;

@Repository
public class HistoriaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertHistoria(Historia historia) {
        jdbcTemplate.update(
                "INSERT INTO HISTORIA(NOME, PROLOGO, DT_INICIO, PRESENCIAL, FK_ID_MESTRE) VALUES(?, ?, ?, ?, ?)",
                historia.getNome(), historia.getPrologo(), historia.getDt_inicio(),
                historia.isPresencial(), historia.getFk_id_mestre());
        historia.setId_historia(historia.getId_historia());
    }

    public boolean deleteHistoria(int id_historia) {

        jdbcTemplate.update("DELETE FROM participacao WHERE FK_ID_HISTORIA = ?", id_historia);

        int rowsAffected = jdbcTemplate.update("DELETE FROM HISTORIA WHERE ID_HISTORIA = ?", id_historia);
        return rowsAffected > 0;
    }

    public List<Historia> getAllHistoria() {
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
    public List<User> getUsersByHistory(int id_historia) {
        String sql = "SELECT U.USER_NAME FROM USER U " + 
                "JOIN JOGADOR J ON U.ID_USER = J.FK_ID_USER " +
                "JOIN PERSONAGEM P2 ON J.FK_ID_USER = P2.FK_ID_JOGADOR " +
                "JOIN PARTICIPACAO P ON P2.ID_PERSONAGEM  = P.FK_ID_PERSONAGEM " +
                "JOIN HISTORIA H ON P.FK_ID_HISTORIA = H.ID_HISTORIA " +
                "WHERE H.ID_HISTORIA = ?;";

        return jdbcTemplate.query(sql, new Object[] { id_historia }, (resultSet, rowNum) -> {
            User user = new User();
            user.setUser_name(resultSet.getString("USER_NAME"));

            return user;
        });
    }

    @SuppressWarnings("deprecation")
    public Historia getHistoriaById(int id_historia) {
        String sql = "SELECT * FROM HISTORIA WHERE ID_HISTORIA = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[] { id_historia },
                    new BeanPropertyRowMapper<>(Historia.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateHistoria(Historia historia) {
        jdbcTemplate.update(
                "UPDATE HISTORIA SET NOME = ?, PROLOGO = ?, PRESENCIAL = ? WHERE ID_HISTORIA = ?",
                historia.getNome(), historia.getPrologo(), historia.isPresencial(),
                historia.getId_historia());
    }
    public List<Historia> getTop3LongasHistorias() {
        String sql = "SELECT * FROM HISTORIA ORDER BY DT_INICIO ASC LIMIT 3";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Historia.class));
    }
}

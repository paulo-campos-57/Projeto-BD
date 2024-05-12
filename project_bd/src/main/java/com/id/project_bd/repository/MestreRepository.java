package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Mestre;

@Repository
public class MestreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMestre(Mestre mestre) {
        jdbcTemplate.update("INSERT INTO MESTRE(FK_ID_USER, NPC, MONSTRO) VALUES(?, ?, ?)",
                mestre.getFk_id_user(), mestre.getNpc(), mestre.getMonstro());
    }

    public boolean deleteMestre(int fk_id_user) {
        // Antes de excluir o mestre, exclua os registros dependentes na tabela 'participacao'
        jdbcTemplate.update("DELETE FROM participacao WHERE FK_ID_MESTRE = ?", fk_id_user);
    
        // Agora você pode excluir o mestre na tabela 'MESTRE' sem violar a integridade
        int rowsAffected = jdbcTemplate.update("DELETE FROM MESTRE WHERE FK_ID_USER = ?", fk_id_user);
        return rowsAffected > 0;
    }
    

    public List<Mestre> getAllMestre() {
        return jdbcTemplate.query("SELECT * FROM MESTRE", (resultSet, rowNum) -> {
            Mestre mestre = new Mestre();
            mestre.setFk_id_user(resultSet.getInt("FK_ID_USER"));
            mestre.setNpc(resultSet.getString("NPC"));
            mestre.setMonstro(resultSet.getString("MONSTRO"));
            return mestre;
        });
    }

    @SuppressWarnings("deprecation")
    public Mestre getMestreById(int fk_id_user) {
        String sql = "SELECT * FROM MESTRE WHERE FK_ID_USER = ?";
        try {
            // Utiliza BeanPropertyRowMapper para mapear automaticamente os resultados para a classe Mestre
            return jdbcTemplate.queryForObject(sql, new Object[]{fk_id_user}, new BeanPropertyRowMapper<>(Mestre.class));
        } catch (EmptyResultDataAccessException e) {
            return null; // Lidar com o caso em que nenhum resultado é encontrado
        }
    }

    public void updateMestre(Mestre mestre){
        jdbcTemplate.update("UPDATE MESTRE SET NPC = ?, MONSTRO = ? WHERE FK_ID_USER = ?",
        mestre.getNpc(), mestre.getMonstro(), mestre.getFk_id_user());
    }
}

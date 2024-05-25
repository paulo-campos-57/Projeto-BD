package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Denuncia;

@Repository
public class DenunciaRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertDenuncia(Denuncia denuncia){
        jdbcTemplate.update("INSERT INTO DENUNCIA (FK_ID_DENUNCIA, FK_ID_DENUNCIADO, COMENTARIO) VALUES(?, ?, ?)",
        denuncia.getFk_id_denuncia(), denuncia.getFk_id_denunciado(), denuncia.getComentario());
    }

    @SuppressWarnings("deprecation")
    public List<Denuncia> getDenunciasById(int id_user){
        String sql = "select d.COMENTARIO from denuncia d " + 
        "where d.FK_ID_DENUNCIADO = ?;";

        return jdbcTemplate.query(sql, new Object[] {id_user}, (resultSet, rowNum) -> {
            Denuncia denuncia = new Denuncia();
            denuncia.setComentario(resultSet.getString("COMENTARIO"));

            return denuncia;

        });
    }
}

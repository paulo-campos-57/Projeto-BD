package com.id.project_bd.repository;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.id.project_bd.models.Personagem;

@Repository
public class PersonagemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Personagem> personagemMapper = new RowMapper<Personagem>() {
        @Override
        public Personagem mapRow(ResultSet rs, int rowNum) throws SQLException {
            Personagem personagem = new Personagem();
            personagem.setId_personagem(rs.getInt("ID_PERSONAGEM"));
            personagem.setNome(rs.getString("NOME"));
            personagem.setClasse(rs.getString("CLASSE"));
            personagem.setNivel(rs.getInt("NIVEL"));

            if (hasColumn(rs, "HABILIDADES")) {
                personagem.setHabilidades(rs.getString("HABILIDADES"));
            }
            if (hasColumn(rs, "BACKSTORY")) {
                personagem.setBackstory(rs.getString("BACKSTORY"));
            }
            if (hasColumn(rs, "FK_ID_JOGADOR")) {
                personagem.setFk_id_jogador(rs.getInt("FK_ID_JOGADOR"));
            }
            return personagem;
        }

        private boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                if (columnName.equalsIgnoreCase(metaData.getColumnName(i))) {
                    return true;
                }
            }
            return false;
        }
    };

    public void insertPersonagem(Personagem personagem) {
        jdbcTemplate.update(
                "INSERT INTO PERSONAGEM(NOME, CLASSE, NIVEL, HABILIDADES, BACKSTORY, FK_ID_JOGADOR) VALUES(?, ?, ?, ?, ?, ?)",
                personagem.getNome(), personagem.getClasse(), personagem.getNivel(), personagem.getHabilidades(),
                personagem.getBackstory(), personagem.getFk_id_jogador());
        personagem.setId_personagem(personagem.getId_personagem());
    }

    public boolean deletePersonagem(int id_personagem) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM PERSONAGEM WHERE ID_PERSONAGEM = ?", id_personagem);
        return rowsAffected > 0;
    }

    public List<Personagem> getAllPersonagens() {
        return jdbcTemplate.query("SELECT * FROM PERSONAGEM", (resultSet, rowNum) -> {
            Personagem personagem = new Personagem();
            personagem.setId_personagem(resultSet.getInt("ID_PERSONAGEM"));
            personagem.setNome(resultSet.getString("NOME"));
            personagem.setClasse(resultSet.getString("CLASSE"));
            personagem.setNivel(resultSet.getInt("NIVEL"));
            personagem.setHabilidades(resultSet.getString("HABILIDADES"));
            personagem.setBackstory(resultSet.getString("BACKSTORY"));
            personagem.setFk_id_jogador(resultSet.getInt("FK_ID_JOGADOR"));
            return personagem;
        });
    }

    @SuppressWarnings("deprecation")
    public Personagem getPersonagemById(int id_personagem) {
        String sql = "SELECT * FROM PERSONAGEM WHERE ID_PERSONAGEM = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[] { id_personagem },
                    new BeanPropertyRowMapper<>(Personagem.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Personagem> getAlphabetic() {
        return jdbcTemplate.query("SELECT * FROM PERSONAGEM ORDER BY NOME ASC", personagemMapper);
    }

    public List<Personagem> getByLevel() {
        return jdbcTemplate.query("SELECT * FROM PERSONAGEM ORDER BY NIVEL ASC", personagemMapper);
    }

    @SuppressWarnings("deprecation")
    public List<Personagem> getByClasse(String classe) {
        return jdbcTemplate.query("SELECT * FROM PERSONAGEM WHERE CLASSE = ?",
                new Object[] { classe },
                personagemMapper);
    }

    public void updatePersonagem(Personagem personagem) {
        jdbcTemplate.update(
                "UPDATE PERSONAGEM SET NOME = ?, CLASSE = ?, NIVEL = ?, HABILIDADES = ?, BACKSTORY = ? WHERE ID_PERSONAGEM = ?",
                personagem.getNome(), personagem.getClasse(), personagem.getNivel(), personagem.getHabilidades(),
                personagem.getBackstory(), personagem.getId_personagem());
    }
}

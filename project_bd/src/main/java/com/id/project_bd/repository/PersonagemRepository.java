package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Personagem;

@Repository
public class PersonagemRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertPersonagem(Personagem personagem){
        jdbcTemplate.update("INSERT INTO PERSONAGEM(NOME, CLASSE, NIVEL, HABILIDADES, BACKSTORY, FK_ID_JOGADOR) VALUES(?, ?, ?, ?, ?, ?)", 
        personagem.getNome(), personagem.getClasse(), personagem.getNivel(), personagem.getHabilidades(), personagem.getBackstory(), personagem.getFk_id_jogador());
        personagem.setId_personagem(personagem.getId_personagem());
    }

    public boolean deletePersonagem(int id_personagem){
        int rowsAffected = jdbcTemplate.update("DELETE FROM PERSONAGEM WHERE ID_PERSONAGEM = ?", id_personagem);
        return rowsAffected > 0;
    }

    public List<Personagem> getAllPersonagens(){
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

    public void updatePersonagem(Personagem personagem){
        jdbcTemplate.update("UPDATE PERSONAGEM SET NOME = ?, CLASSE = ?, NIVEL = ?, HABILIDADES = ?, BACKSTORY = ? WHERE ID_PERSONAGEM = ?", 
        personagem.getNome(), personagem.getClasse(), personagem.getNivel(), personagem.getHabilidades(), personagem.getBackstory(), personagem.getId_personagem());
    }
}

package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Mestre;
import com.id.project_bd.models.User;

@Repository
public class MestreRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMestre(Mestre mestre) {
        jdbcTemplate.update("INSERT INTO MESTRE(FK_ID_USER, NPC, MONSTRO) VALUES(?, ?, ?)",
                mestre.getFk_id_user(), mestre.getNpc(), mestre.getMonstro());
    }

    public boolean deleteMestre(int fk_id_user) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM MESTRE WHERE FK_ID_USER = ?", fk_id_user);
        return rowsAffected > 0;
    }

    public List<Mestre> getAllMestre() {
        String sql = "SELECT M.fk_id_user, M.npc, M.monstro, U.id_user, U.user_name, U.senha, U.contato1, U.contato2, "
                +
                "U.estado, U.cidade, U.bairro, U.rua, U.numero, U.complemento " +
                "FROM MESTRE M " +
                "INNER JOIN USER U ON M.fk_id_user = U.id_user";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Mestre mestre = new Mestre();
            mestre.setFk_id_user(resultSet.getInt("fk_id_user"));
            mestre.setNpc(resultSet.getString("npc"));
            mestre.setMonstro(resultSet.getString("monstro"));

            User user = new User();
            user.setId_user(resultSet.getInt("id_user"));
            user.setUser_name(resultSet.getString("user_name"));
            user.setSenha(resultSet.getString("senha"));
            user.setContato1(resultSet.getString("contato1"));
            user.setContato2(resultSet.getString("contato2"));
            user.setEstado(resultSet.getString("estado"));
            user.setCidade(resultSet.getString("cidade"));
            user.setBairro(resultSet.getString("bairro"));
            user.setRua(resultSet.getString("rua"));
            user.setNumero(resultSet.getString("numero"));
            user.setComplemento(resultSet.getString("complemento"));

            mestre.setId_user(resultSet.getInt("id_user"));
            mestre.setUser_name(resultSet.getString("user_name"));
            mestre.setSenha(resultSet.getString("senha"));
            mestre.setContato1(resultSet.getString("contato1"));
            mestre.setContato2(resultSet.getString("contato2"));
            mestre.setEstado(resultSet.getString("estado"));
            mestre.setCidade(resultSet.getString("cidade"));
            mestre.setBairro(resultSet.getString("bairro"));
            mestre.setRua(resultSet.getString("rua"));
            mestre.setNumero(resultSet.getString("numero"));
            mestre.setComplemento(resultSet.getString("complemento"));

            //mestre.setUser(user);
            return mestre;
        });
    }

    public void updateMestre(Mestre mestre){
        jdbcTemplate.update("UPDATE MESTRE SET NPC = ?, MONSTRO = ? WHERE FK_ID_USER = ?",
        mestre.getNpc(), mestre.getMonstro(), mestre.getFk_id_user());
    }
}

package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.id.project_bd.models.Historia;
import com.id.project_bd.models.User;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId_user(rs.getInt("ID_USER"));
            user.setUser_name(rs.getString("USER_NAME"));
            if (hasColumn(rs, "SENHA")) {
                user.setSenha(rs.getString("SENHA"));
            }
            if (hasColumn(rs, "CONTATO1")) {
                user.setContato1(rs.getString("CONTATO1"));
            }
            if (hasColumn(rs, "CONTATO2")) {
                user.setContato2(rs.getString("CONTATO2"));
            }
            if (hasColumn(rs, "ESTADO")) {
                user.setEstado(rs.getString("ESTADO"));
            }
            if (hasColumn(rs, "CIDADE")) {
                user.setCidade(rs.getString("CIDADE"));
            }
            if (hasColumn(rs, "BAIRRO")) {
                user.setBairro(rs.getString("BAIRRO"));
            }
            if (hasColumn(rs, "RUA")) {
                user.setRua(rs.getString("RUA"));
            }
            if (hasColumn(rs, "NUMERO")) {
                user.setNumero(rs.getString("NUMERO"));
            }
            if (hasColumn(rs, "COMPLEMENTO")) {
                user.setComplemento(rs.getString("COMPLEMENTO"));
            }
            return user;
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

    // Inserir no banco de dados o user
    public void insertUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO USER(USER_NAME, SENHA, CONTATO1, CONTATO2, ESTADO, CIDADE, BAIRRO, RUA, NUMERO, COMPLEMENTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getUser_name(), user.getSenha(), user.getContato1(), user.getContato2(),
                user.getEstado(), user.getCidade(), user.getBairro(), user.getRua(), user.getNumero(),
                user.getComplemento());
        user.setId_user(user.getId_user());
    }

    // Excluir usuário com base no ID
    public boolean deleteUser(int id_user) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM USER WHERE ID_USER = ?", id_user);
        return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada (usuário excluído)
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", (resultSet, rowNum) -> {
            User user = new User();
            user.setId_user(resultSet.getInt("ID_USER"));
            user.setUser_name(resultSet.getString("USER_NAME"));
            user.setSenha(resultSet.getString("SENHA"));
            user.setContato1(resultSet.getString("CONTATO1"));
            user.setContato2(resultSet.getString("CONTATO2"));
            user.setEstado(resultSet.getString("ESTADO"));
            user.setCidade(resultSet.getString("CIDADE"));
            user.setBairro(resultSet.getString("BAIRRO"));
            user.setRua(resultSet.getString("RUA"));
            user.setNumero(resultSet.getString("NUMERO"));
            user.setComplemento(resultSet.getString("COMPLEMENTO"));
            return user;
        });
    }

    @SuppressWarnings("deprecation")
    public List<Historia> getHistoriasById(int id_user) {
        String sql = "SELECT H.NOME, H.PROLOGO, H.DT_INICIO " +
                "FROM HISTORIA H " +
                "JOIN PARTICIPACAO P ON H.ID_HISTORIA = P.FK_ID_HISTORIA " +
                "JOIN PERSONAGEM PC ON P.FK_ID_PERSONAGEM = PC.ID_PERSONAGEM " +
                "JOIN JOGADOR J ON PC.FK_ID_JOGADOR = J.FK_ID_USER " +
                "WHERE J.FK_ID_USER = ?";

        return jdbcTemplate.query(sql, new Object[] { id_user }, (resultSet, rowNum) -> {
            Historia historia = new Historia();
            historia.setNome(resultSet.getString("NOME"));
            historia.setPrologo(resultSet.getString("PROLOGO"));
            historia.setDt_inicio(resultSet.getDate("DT_INICIO"));

            return historia;
        });
    }

    public List<User> getAllUsersSortedByName() {
        return jdbcTemplate.query("SELECT * FROM USER ORDER BY USER_NAME ASC", userMapper);
    }

    public User getUserById(int id_user) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID_USER = ?", userMapper, id_user);
    }

    public void updateUser(User user) {
        jdbcTemplate.update(
                "UPDATE USER SET CONTATO1 = ?, CONTATO2 = ?, ESTADO = ?, CIDADE = ?, BAIRRO = ?, RUA = ?, NUMERO =?, COMPLEMENTO = ? WHERE ID_USER = ?",
                user.getContato1(), user.getContato2(), user.getEstado(), user.getCidade(), user.getBairro(),
                user.getRua(), user.getNumero(),
                user.getComplemento(), user.getId_user());
    }

    public List<User> getTop3UsersByParticipations() {
        String sql = "SELECT ID_USER, USER_NAME, num_historias FROM (" +
                "SELECT u.ID_USER, u.USER_NAME, COUNT(p.FK_ID_HISTORIA) AS num_historias " +
                "FROM USER u " +
                "JOIN JOGADOR j ON u.ID_USER = j.FK_ID_USER " +
                "JOIN PERSONAGEM pc ON j.FK_ID_USER = pc.FK_ID_JOGADOR " +
                "JOIN PARTICIPACAO p ON pc.ID_PERSONAGEM = p.FK_ID_PERSONAGEM " +
                "GROUP BY u.ID_USER, u.USER_NAME " +
                "ORDER BY num_historias DESC " +
                ") AS temp LIMIT 3";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId_user(rs.getInt("ID_USER"));
            user.setUser_name(rs.getString("USER_NAME"));
            user.setNumHistorias(rs.getInt("num_historias"));
            return user;
        });
    }

    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM USER WHERE USER_NAME = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return count > 0;
    }

}

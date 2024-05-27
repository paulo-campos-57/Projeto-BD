package com.id.project_bd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.User;
import com.id.project_bd.models.Venda;

@Repository
public class VendaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertVenda(Venda venda) {
        jdbcTemplate.update("INSERT INTO VENDA(FK_ID_PRODUTO, FK_ID_USER, DATA_VENDA) VALUES(?, ?, ?)",
                venda.getFk_id_produto(), venda.getFk_id_user(), venda.getDataVenda());
    }

    public List<Venda> getAllVendas() {
        String sql = "SELECT V.ID_VENDA, V.FK_ID_PRODUTO, V.FK_ID_USER, V.DATA_VENDA, " +
                "U.ID_USER, U.USER_NAME, U.CONTATO1, U.CONTATO2, U.ESTADO, " +
                "U.BAIRRO, U.CIDADE, U.RUA, U.NUMERO, U.COMPLEMENTO " +
                "FROM VENDA V " +
                "INNER JOIN USER U ON V.FK_ID_USER = U.ID_USER";

        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Venda venda = new Venda();
            venda.setId_venda(resultSet.getInt("ID_VENDA"));
            venda.setFk_id_produto(resultSet.getInt("FK_ID_PRODUTO"));
            venda.setFk_id_user(resultSet.getInt("FK_ID_USER"));
            venda.setDataVenda(resultSet.getDate("DATA_VENDA"));

            User user = new User();
            user.setId_user(resultSet.getInt("ID_USER"));
            user.setUser_name(resultSet.getString("USER_NAME"));
            user.setContato1(resultSet.getString("CONTATO1"));
            user.setContato2(resultSet.getString("CONTATO2"));
            user.setEstado(resultSet.getString("ESTADO"));
            user.setCidade(resultSet.getString("CIDADE"));
            user.setBairro(resultSet.getString("BAIRRO"));
            user.setRua(resultSet.getString("RUA"));
            user.setNumero(resultSet.getString("NUMERO"));
            user.setComplemento(resultSet.getString("COMPLEMENTO"));

            venda.setId_user(resultSet.getInt("ID_USER"));
            venda.setUser_name(resultSet.getString("USER_NAME"));
            venda.setContato1(resultSet.getString("CONTATO1"));
            venda.setContato2(resultSet.getString("CONTATO2"));
            venda.setEstado(resultSet.getString("ESTADO"));
            venda.setCidade(resultSet.getString("CIDADE"));
            venda.setBairro(resultSet.getString("BAIRRO"));
            venda.setRua(resultSet.getString("RUA"));
            venda.setNumero(resultSet.getString("NUMERO"));
            venda.setComplemento(resultSet.getString("COMPLEMENTO"));

            return venda;
        });
    }

}

package com.id.project_bd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.id.project_bd.models.Compra;

@Repository
public class CompraRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertCompra(Compra compra){
        jdbcTemplate.update("INSERT INTO COMPRA(ID_COMPRA, FK_ID_PRODUTO, FK_ID_USER, DATA_COMPRA) VALUES(?, ?, ?, ?)",
        compra.getId_compra(), compra.getFk_id_produto(), compra.getFk_id_user(), compra.getData_compra());
    }

    
}

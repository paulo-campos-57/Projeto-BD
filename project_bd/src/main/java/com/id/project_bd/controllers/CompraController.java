package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Compra;
import com.id.project_bd.repository.CompraRepository;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @PostMapping
    public String createCompra(@RequestBody Compra compra){
        compraRepository.insertCompra(compra);
        return "compra inserida com sucesso!\n";
    }

    @GetMapping
    public List<Compra> getCompras() {
        return compraRepository.getAllCompras();
    }
}

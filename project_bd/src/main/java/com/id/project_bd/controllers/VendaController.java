package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Venda;
import com.id.project_bd.repository.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @PostMapping
    public String createVenda(@RequestBody Venda venda) {
        vendaRepository.insertVenda(venda);
        return "Venda inserida com sucesso!\n";
    }

    @GetMapping
    public List<Venda> getCompras() {
        return vendaRepository.getAllVendas();
    }
}

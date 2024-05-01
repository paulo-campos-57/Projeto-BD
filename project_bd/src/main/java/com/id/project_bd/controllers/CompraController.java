package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.id.project_bd.models.Compra;
import com.id.project_bd.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
public class CompraController {
    
    @Autowired
    private CompraRepository compraRepository;

    @PostMapping
    public String createCompra(@RequestBody Compra compra) {
        compraRepository.insertCompra(compra);
        return "Compra inserida!";
    }

    @DeleteMapping("/{idCompra}")
    public String deleteCompra(@PathVariable int idCompra) {
        boolean deleted = compraRepository.deleteCompra(idCompra);
        if (deleted) {
            return "Compra removida.\n";
        } else {
            return "A compra com esse ID não existe no banco de dados.\n";
        }
    }

    @GetMapping
    public List<Compra> getCompras() {
        return compraRepository.getAllCompras();
    }

    @PutMapping("/{idCompra}")
    public String updateCompra(@PathVariable int idCompra, @RequestBody Compra compra) {
        compra.setId_compra(idCompra);
        compraRepository.updateCompra(compra);
        return "Informações sobre a compra salvas com sucesso.\n";
    }
}

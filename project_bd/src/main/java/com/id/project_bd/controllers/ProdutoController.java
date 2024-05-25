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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Dado;
import com.id.project_bd.models.Livro;
import com.id.project_bd.models.Produto;
import com.id.project_bd.repository.DadoRepository;
import com.id.project_bd.repository.LivroRepository;
import com.id.project_bd.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private DadoRepository dadoRepository;

    @RequestMapping(value = "/{fk_id_user}", method = RequestMethod.GET)
    public ModelAndView produtoForm(@PathVariable int fk_id_user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("produtoForm");
        mv.addObject("fk_id_user", fk_id_user);
        return mv;
    }

    @RequestMapping(value = "/{fk_id_user}", method = RequestMethod.POST)
    public ModelAndView produtoForm(Produto produto, @RequestParam String tipo,
            @RequestParam(required = false) Integer qtd_paginas,
            @RequestParam(required = false) Integer estado,
            @RequestParam(required = false) Integer qtd_lados,
            @PathVariable int fk_id_user) {
        produto.setFk_id_user(fk_id_user);
        Produto savedProduto = produtoRepository.insertProduto(produto);

        if (tipo.equals("livro")) {
            Livro livro = new Livro();
            livro.setFk_id_produto(savedProduto.getId_produto());
            livro.setQtd_paginas(qtd_paginas);
            livro.setEstado(estado);
            livroRepository.insertLivro(livro);
        } else if (tipo.equals("dado")) {
            Dado dado = new Dado();
            dado.setFk_id_produto(savedProduto.getId_produto());
            dado.setQtd_lados(qtd_lados);
            dadoRepository.insertDado(dado);
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/alterar/{id_produto}", method = RequestMethod.POST)
    public ModelAndView alterarProduto(Produto produto) {
        produtoRepository.updateProduto(produto);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping
    public String createProduto(@RequestBody Produto produto) {
        produtoRepository.insertProduto(produto);
        return "Produto " + produto.getId_produto() + " cadastrado com sucesso!\n";
    }

    @DeleteMapping("/{id_produto}")
    public String deleteProduto(@PathVariable int id_produto) {
        boolean deleted = produtoRepository.deleteProduto(id_produto);
        if (deleted) {
            return "Produto " + id_produto + " deletado com sucesso!\n";
        } else {
            return "Produto " + id_produto + " não encontrado para exclusão!\n";
        }
    }

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoRepository.getAllProdutos();
    }

    @PutMapping("/{id_produto}")
    public String updateProduto(@PathVariable int id_produto, @RequestBody Produto produto) {
        produto.setIdproduto(id_produto);
        produtoRepository.updateProduto(produto);
        return "Valores do produto " + id_produto + " atualizado com sucesso!\n";
    }

    @GetMapping("/lista")
    public ModelAndView getAllProdutos() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("produtos", produtoRepository.getAllProdutos());
        mv.setViewName("listaProdutos");
        return mv;
    }

    @GetMapping("/lista/alfabetica")
    public ModelAndView getSortdeByName() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("produtos", produtoRepository.getSortedByName());
        mv.setViewName("listaProdutos");
        return mv;
    }

    @GetMapping("/lista/preco")
    public ModelAndView getSortdeByPrice() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("produtos", produtoRepository.getSortedByPrice());
        mv.setViewName("listaProdutos");
        return mv;
    }

    @GetMapping("/detalhes/{id_produto}")
    public ModelAndView getSpecificProduto(@PathVariable int id_produto) {
        Produto produto = produtoRepository.getProdutoById(id_produto);
        ModelAndView mv = new ModelAndView();
        if (produto != null) {
            mv.addObject("produto", produto);
            if (produto instanceof Dado) {
                Dado dado = (Dado) produto;
                mv.addObject("qtd_lados", dado.getQtd_lados());
                mv.setViewName("detalhesDado");
            } else if (produto instanceof Livro) {
                Livro livro = (Livro) produto;
                mv.addObject("estado", livro.getEstado());
                mv.addObject("qtd_paginas", livro.getQtd_paginas());
                mv.setViewName("detalhesLivro");
            } else {
                mv.setViewName("detalhesProduto");
            }
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

}

package com.id.project_bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Compra;
import com.id.project_bd.models.Venda;
import com.id.project_bd.repository.CompraRepository;
import com.id.project_bd.repository.UserRepository;
import com.id.project_bd.repository.VendaRepository;

@RestController
@RequestMapping("/finalizar")
public class FormCompraController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    CompraRepository compraRepository;

    @RequestMapping(value = "/compra/{id_produto}", method = RequestMethod.GET)
    public ModelAndView finalizarCompra(@PathVariable("id_produto") String id_produto) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("compraForm");
        return mv;
    }

    @RequestMapping(value = "/compra/{id_produto}", method = RequestMethod.POST)
    public ModelAndView verificarCompra(@PathVariable String id_produto, @RequestParam String username,
            @RequestParam java.sql.Date dataAtual) {
        ModelAndView mv = new ModelAndView();

        boolean userExists = userRepository.existsByUsername(username);

        if (userExists) {
            Integer id_comprador = userRepository.findIdByUsername(username);
            if (id_comprador != null) {
                System.out.println("ID_USER (Comprador): " + id_comprador);
                mv.addObject("id_comprador", id_comprador);
            }
            System.out.println("ID_PRODUTO: " + id_produto); // Imprimindo o valor de id_produto

            // Aqui você pode chamar o método para encontrar o vendedor do produto
            Integer id_vendedor = userRepository.findVendedorProduto(Integer.parseInt(id_produto));
            if (id_vendedor != null) {
                System.out.println("ID_USER (Vendedor): " + id_vendedor);
                mv.addObject("id_vendedor", id_vendedor);
            } else {
                System.out.println("Não foi possível encontrar o vendedor do produto com ID " + id_produto);
            }

            mv.addObject("id_produto", id_produto); // Adicionando id_produto ao ModelAndView
            mv.addObject("data_atual", dataAtual); // Adicionando a data atual ao ModelAndView

            userRepository.mudarUsuario(Integer.parseInt(id_produto), id_comprador);

            // Chamada para inserir a compra no banco de dados
            Venda venda = new Venda();
            venda.setFk_id_produto(Integer.parseInt(id_produto));
            venda.setFk_id_user(id_vendedor);
            venda.setDataVenda(dataAtual);// Usando a data atual recebida do formulário

            vendaRepository.insertVenda(venda);

            Compra compra = new Compra();
            compra.setFk_id_produto(Integer.parseInt(id_produto));
            compra.setFk_id_user(id_comprador);
            compra.setData_compra(dataAtual);

            compraRepository.insertCompra(compra);

            mv.setViewName("compraSucesso");
        } else {
            mv.setViewName("compraFalha");
        }

        return mv;
    }

}

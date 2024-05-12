package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Jogador;
import com.id.project_bd.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @RequestMapping(value = "/cadastro/{id_user}", method = RequestMethod.GET)
    public ModelAndView jogadorForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jogadorForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro/{id_user}", method = RequestMethod.POST)
    public ModelAndView jogadorForm(Jogador jogador){
        jogadorRepository.insertJogador(jogador);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView getAllJogadores(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("jogador", jogadorRepository.getAllJogadores());
        mv.setViewName("listaJogador");
        return mv;
    }

    @GetMapping("/excluir/{fk_id_user}")
    public String excluirJogador(@PathVariable("fk_id_user") Integer fk_id_user, Model model){
        jogadorRepository.deleteJogador(fk_id_user);
        model.addAttribute("jogador", jogadorRepository.getAllJogadores());
        return "listaJogador";
    }

    @PostMapping
    public String createJogador(@RequestBody Jogador jogador){
        jogadorRepository.insertJogador(jogador);
        return "Jogador inserido!\n";
    }

    @DeleteMapping("/{fk_id_user}")
    public String deletejogador(@PathVariable int fk_id_user){
        boolean deleted = jogadorRepository.deleteJogador(fk_id_user);
        if(deleted){
            return "Jogador deletado!\n";
        } else {
            return "O jogador com essas informações não existe no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Jogador> getJogador(){
        return jogadorRepository.getAllJogadores();
    }

    //Não criei PUT de jogador pois ele não tem nada pra mudar
}

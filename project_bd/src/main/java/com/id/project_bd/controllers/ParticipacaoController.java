package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Participacao;
import com.id.project_bd.repository.ParticipacaoRepository;

@RestController
@RequestMapping("/participacao")
public class ParticipacaoController {
    
    @Autowired
    private ParticipacaoRepository participacaoRepository;

    @RequestMapping(value = "/{id_personagem}/{fk_id_mestre}/{id_historia}", method = RequestMethod.GET)
    public ModelAndView participcaoForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("participacaoForm");
        return mv;
    }

    @RequestMapping(value = "/{id_personagem}/{fk_id_mestre}/{id_historia}", method = RequestMethod.POST)
    public ModelAndView participacaoForm(@PathVariable("id_personagem") int idPersonagem,
                                        @PathVariable("fk_id_mestre") int fkIdMestre,
                                        @PathVariable("id_historia") int idHistoria) {
        // Agora você pode usar os valores int idPersonagem, int fkIdMestre e int idHistoria diretamente aqui
        
        Participacao participacao = new Participacao();
        participacao.setfk_id_personagem(idPersonagem);
        participacao.setfk_id_mestre(fkIdMestre);
        participacao.setfk_id_historia(idHistoria);
        
        participacaoRepository.insertParticipacao(participacao);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }



    @PostMapping
    public String createParticipacao(@RequestBody Participacao participacao){
        participacaoRepository.insertParticipacao(participacao);
        return "Participacao inserida!\n";
    }

    @GetMapping
    public List<Participacao> getParticipacao(){
        return participacaoRepository.getAllParticipacao();
    }
}

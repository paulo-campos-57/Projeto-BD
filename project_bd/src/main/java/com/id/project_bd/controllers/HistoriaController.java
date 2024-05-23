package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Historia;
import com.id.project_bd.repository.HistoriaRepository;

@RestController
@RequestMapping("/historia")
public class HistoriaController {

    @Autowired
    private HistoriaRepository historiaRepository;

    @RequestMapping(value = "/cadastro/{fk_id_mestre}", method = RequestMethod.GET)
    public ModelAndView historiaForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("historiaForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro/{fk_id_mestre}", method = RequestMethod.POST)
    public ModelAndView mestreForm(Historia historia){
        historiaRepository.insertHistoria(historia);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView getAllHistorias(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("historia", historiaRepository.getAllHistoria());
        mv.setViewName("listaHistoria");
        return mv;
    }

    @GetMapping("/usuarios/{id_historia}")
    public ModelAndView getUserByHistory(@PathVariable int id_historia){
        ModelAndView mv = new ModelAndView();
        mv.addObject("historia", historiaRepository.getUsersByHistory(id_historia));
        mv.setViewName("idHIstorias");
        return mv;
    }

    @GetMapping("/{id_historia}")
    public ModelAndView getSpecificHistoria(@PathVariable int id_historia){
        Historia historia = historiaRepository.getHistoriaById(id_historia);
        ModelAndView mv = new ModelAndView();
        if (historia != null){
            mv.addObject("historia", historia);
            mv.setViewName("detalhesHistoria");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    @GetMapping("/excluir/{id_historia}")
    public String excluirHistoria(@PathVariable("id_historia") Integer id_historia, Model model){
        historiaRepository.deleteHistoria(id_historia);
        model.addAttribute("historia", historiaRepository.getAllHistoria());
        return "listaHistoria";
    }

    @GetMapping("/alterar/{id_historia}")
    public ModelAndView alterarHistoria(@PathVariable int id_historia){
        Historia historia = historiaRepository.getHistoriaById(id_historia);
        ModelAndView mv = new ModelAndView();
        if (historia != null){
            mv.addObject("historia", historia);
            mv.setViewName("alterarHistoria");
        } else {
            mv.setViewName("index");
        }     
        return mv;
    }

    @RequestMapping(value = "/alterar/{id_historia}", method = RequestMethod.POST)
    public ModelAndView alterarHistoria(Historia historia){
        historiaRepository.updateHistoria(historia);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping
    public String createHistoria(@RequestBody Historia historia){
        historiaRepository.insertHistoria(historia);
        return "Historia criada!\n";
    }

    @DeleteMapping("/{id_historia}")
    public String deleteHistoria(@PathVariable int id_historia){
        boolean deleted = historiaRepository.deleteHistoria(id_historia);
        if(deleted){
            return "Historia deletada!\n";
        } else {
            return "A historia com essas informações não existe!\n";
        }
    }

    @GetMapping
    public List<Historia> getHistoria(){
        return historiaRepository.getAllHistoria();
    }

    @PutMapping("/{id_historia}")
    public String updateHistoria(@PathVariable int id_historia, @RequestBody Historia historia){
        historia.setId_historia(id_historia);
        historiaRepository.updateHistoria(historia);
        return "A historia foi atualizada com sucesso!\n";
    }
}

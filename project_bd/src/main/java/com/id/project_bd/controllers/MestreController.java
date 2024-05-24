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

import com.id.project_bd.models.Mestre;
import com.id.project_bd.repository.MestreRepository;

@RestController
@RequestMapping("/mestres")
public class MestreController {

    @Autowired
    private MestreRepository mestreRepository;

    @RequestMapping(value = "/cadastro/{id_user}", method = RequestMethod.GET)
    public ModelAndView mestreForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mestreForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro/{id_user}", method = RequestMethod.POST)
    public ModelAndView mestreForm(Mestre mestre){
        mestreRepository.insertMestre(mestre);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView getAllMestres(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mestres", mestreRepository.getAllMestre());
        mv.setViewName("listaMestres");
        return mv;
    }

    @GetMapping("/{fk_id_user}")
    public ModelAndView getSpecificMestre(@PathVariable int fk_id_user){
        Mestre mestre = mestreRepository.getMestreById(fk_id_user);
        ModelAndView mv = new ModelAndView();
        if(mestre != null){
            mv.addObject("mestre", mestre);
            mv.setViewName("detalhesMestre");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    @GetMapping("/historias/{fk_id_user}")
    public ModelAndView getHistoryByMestre(@PathVariable int fk_id_user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("mestre", mestreRepository.getHistoryByMestre(fk_id_user));
        mv.setViewName("mestreHistorias");
        return mv;
    }

    @GetMapping("/alterar/{fk_id_user}")
    public ModelAndView alterarMestre(@PathVariable int fk_id_user){
        Mestre mestre = mestreRepository.getMestreById(fk_id_user);
        ModelAndView mv = new ModelAndView();
        if(mestre != null){
            mv.addObject("mestre", mestre);
            mv.setViewName("alterarMestre");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    @RequestMapping(value = "/alterar/{fk_id_user}", method = RequestMethod.POST)
    public ModelAndView alterarMestre(Mestre mestre){
        mestreRepository.updateMestre(mestre);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/excluir/{fk_id_user}")
    public String excluirMestre(@PathVariable("fk_id_user") Integer fk_id_user, Model model){
        mestreRepository.deleteMestre(fk_id_user);
        model.addAttribute("mestres", mestreRepository.getAllMestre());
        return "listaMestres";
    }


    @PostMapping
    public String createMestre(@RequestBody Mestre mestre){
        mestreRepository.insertMestre(mestre);
        return "Mestre inserido!\n";
    }

    @DeleteMapping("/{fk_id_user}")
    public String deleteMestre(@PathVariable int fk_id_user){
        boolean deleted = mestreRepository.deleteMestre(fk_id_user);
        if(deleted){
            return "Mestre deletado!\n";
        } else {
            return "O mestre com essas informações não exite no banco de dados!\n";
        }
    }

    @GetMapping
    public List<Mestre> getMestre(){
        return mestreRepository.getAllMestre();
    }

    @PutMapping("/{fk_id_user}")
    public String updateMestre(@PathVariable int fk_id_user, @RequestBody Mestre mestre){
        mestre.setFk_id_user(fk_id_user);
        mestreRepository.updateMestre(mestre);
        return "Novas informações salvas com sucesso!\n";
    }
}

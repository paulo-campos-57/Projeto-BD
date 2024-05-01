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

import com.id.project_bd.models.Mestre;
import com.id.project_bd.repository.MestreRepository;

@RestController
@RequestMapping("/mestres")
public class MestreController {

    @Autowired
    private MestreRepository mestreRepository;

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

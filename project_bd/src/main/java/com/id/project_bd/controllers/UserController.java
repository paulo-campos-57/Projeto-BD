package com.id.project_bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.id.project_bd.models.Denuncia;
import com.id.project_bd.models.Jogador;
import com.id.project_bd.models.User;
import com.id.project_bd.repository.DenunciaRepository;
import com.id.project_bd.repository.JogadorRepository;
import com.id.project_bd.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userForm");
        return mv;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView userForm(User user) {
        userRepository.insertUser(user);
        String userName = user.getUser_name();

        System.out.println("user: " + userName);

        Integer userid = userRepository.findId(userName);

        System.out.println("id: " + userid);

        Jogador jogador = new Jogador();
        jogador.setFk_id_user(userid);
        jogadorRepository.insertJogador(jogador);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("sucesso");
        return mv;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userRepository.insertUser(user);
        return "Usuário " + user.getId_user() + " criado com sucesso!\n";
    }

    @PostMapping("/denuncia")
    public String createDenuncia(@RequestBody Denuncia denuncia) {
        denunciaRepository.insertDenuncia(denuncia);
        return "Denuncia cadastrada";
    }

    @DeleteMapping("/{id_user}")
    public String deleteUser(@PathVariable int id_user) {
        boolean deleted = userRepository.deleteUser(id_user);
        if (deleted) {
            return "Usuário " + id_user + " deletado com sucesso!\n";
        } else {
            return "Usuário com ID " + id_user + " não encontrado para exclusão.\n";
        }
    }

    @GetMapping
    public List<User> getUser() {
        return userRepository.getAllUsers();
    }

    @GetMapping("/denuncia/{id_user}")
    public ModelAndView getAllUsers(@PathVariable("id_user") int id_user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getAllUsers());
        mv.addObject("currentUserId", id_user); // Passando o ID do usuário no caminho para o modelo
        mv.setViewName("listaDenuncia");
        return mv;
    }

    @GetMapping("/denuncia/{currentUserId}/{id_user}")
    public ModelAndView exibirFormularioDenuncia(@PathVariable("currentUserId") int currentUserId,
            @PathVariable("id_user") int idUser) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("currentUserId", currentUserId);
        mv.addObject("idUser", idUser);
        mv.setViewName("formularioDenuncia");
        return mv;
    }

    @PostMapping("/denuncia/{currentUserId}/{id_user}")
    public ModelAndView denunciarUsuario(@PathVariable("currentUserId") int currentUserId,
            @PathVariable("id_user") int idUser,
            @RequestParam("comentario") String comentario) {
        Denuncia denuncia = new Denuncia(currentUserId, idUser, comentario);
        denunciaRepository.insertDenuncia(denuncia);

        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getAllUsers());
        mv.addObject("currentUserId", currentUserId);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("verDenuncia/{id_user}")
    public ModelAndView denunciasById(@PathVariable int id_user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("denuncia", denunciaRepository.getDenunciasById(id_user));
        mv.setViewName("denunciasUsuario");
        return mv;
    }

    @GetMapping("/lista")
    public ModelAndView getAllUsers() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getAllUsers());
        mv.setViewName("listaUsuarios");
        return mv;
    }

    @GetMapping("/historias/{id_user}")
    public ModelAndView getHistoriasById(@PathVariable int id_user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getHistoriasById(id_user));
        mv.setViewName("historiasId");
        return mv;
    }

    @GetMapping("/lista/ordenado")
    public ModelAndView getAllUsersSortedByName() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getAllUsersSortedByName());
        mv.setViewName("listaUsuarios");
        return mv;
    }

    @GetMapping("/{id_user}")
    public ModelAndView getSpecificUser(@PathVariable int id_user) {
        User user = userRepository.getUserById(id_user);
        ModelAndView mv = new ModelAndView();
        if (user != null) {
            mv.addObject("user", user);
            mv.setViewName("detalhesUsuario");
        } else {
            mv.setViewName("index");
        }
        return mv;
    }

    @PutMapping("/{id_user}")
    public String updateUser(@PathVariable int id_user, @RequestBody User user) {
        user.setId_user(id_user);
        userRepository.updateUser(user);
        return "Endereço do user " + user.getId_user() + " com sucesso!\n";
    }

    @GetMapping("/alterar/{id_user}")
    public ModelAndView alterarUsuario(@PathVariable int id_user) {
        User user = userRepository.getUserById(id_user);
        ModelAndView mv = new ModelAndView();
        if (user != null) {
            mv.addObject("user", user);
            mv.setViewName("alterarUsuario");
        } else {
            mv.setViewName("index");
        }

        return mv;
    }

    @RequestMapping(value = "/alterar/{id_user}", method = RequestMethod.POST)
    public ModelAndView alterarUsuario(User user) {
        userRepository.updateUser(user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/excluir/{id_user}")
    public ModelAndView excluirUsuario(@PathVariable("id_user") Integer id_user, Model model) {
        userRepository.deleteUser(id_user);

        model.addAttribute("users", userRepository.getAllUsers());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/ranking")
    public ModelAndView getTop3UsersByParticipations() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", userRepository.getTop3UsersByParticipations());
        mv.setViewName("top3Users");
        return mv;
    }

}
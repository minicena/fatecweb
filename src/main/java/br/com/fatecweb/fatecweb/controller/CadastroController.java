package br.com.fatecweb.fatecweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.fatecweb.fatecweb.entity.Usuario;
import br.com.fatecweb.fatecweb.services.UsuarioService;



@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private UsuarioService service;

    // Exibe o formulário
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro"; // não precisa da barra
    }

    // Processa o formulário
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        service.save(usuario); 
        return "redirect:/login"; 
    }
}

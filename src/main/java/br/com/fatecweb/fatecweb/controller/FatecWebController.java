package br.com.fatecweb.fatecweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/fatecweb")
public class FatecWebController {
    
    @GetMapping
    public String String(Model model) {
        //Retorna a página index.html
        return "index";
    }
    
}

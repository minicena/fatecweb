package br.com.fatecweb.fatecweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecweb.fatecweb.entity.Curso;
import br.com.fatecweb.fatecweb.services.CursoService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService service;

    //Método para listar todos os cursos
    @GetMapping("/listar")
    public String listar(Model model) {
        //Busca todos os cursos
        List<Curso> cursos = service.findAll();
        //Adiciona a lista de cursos ao modelo
        model.addAttribute("cursos", cursos);
        //Retorna a página de formulário de cursos
        return "curso/listaCurso";
    }

    //Método para abrir o formulário de cadastro de cursos
    @GetMapping("/criar")
    public String criarForm(Model model) {
        //Adiciona um novo cursos
        model.addAttribute("curso", new Curso());
        //Retorna a página de formulário de alunos
        return "curso/formularioCurso";
    }

    //Método para salvar um curso
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Curso curso) {
        //Salvar o curso
        service.save(curso);
        //Redireciona para a lista de cursos
        return "redirect:/cursos/listar";
    }
    
    //Método para abrir o formulário de edição de curso
    @GetMapping("editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        //Busca o curso pelo id
        Curso curso = service.findById(id);
        //Adiciona o curso ao método
        model.addAttribute("curso", curso);
        //Retorna a página de formulário de curso
        return "curso/formularioCurso";
    }

        //Método para excluir um curso
        @GetMapping("/excluir/{id}")
        public String excluir(@PathVariable Integer id) {
            //Exclui o curso pelo id
            service.deleteById(id);
            //Redireciona para a lista de curso
            return "redirect:/cursos/listar";
        }
        
    
}
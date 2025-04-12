package br.com.fatecweb.fatecweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecweb.fatecweb.entity.Aluno;
import br.com.fatecweb.fatecweb.entity.Curso;
import br.com.fatecweb.fatecweb.services.AlunoService;
import br.com.fatecweb.fatecweb.services.CursoService;

import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService service;

    @Autowired
    private CursoService cursoservice;

    //Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model) {
        //Busca todos os alunos
        List<Aluno> alunos = service.findAll();
        //Adiciona a lista de alunos ao modelo
        model.addAttribute("alunos", alunos);
        //Retorna a página de formulário de alunos
        return "aluno/listaAluno";
    }

    //Método para abrir o formulário de cadastro de alunos
    @GetMapping("/criar")
    public String criarForm(Model model) {
        //Adiciona um novo aluno
        model.addAttribute("aluno", new Aluno());
        //Buscar todos os cursos
        List<Curso> cursos = cursoservice.findAll();
        model.addAttribute("cursos", cursos);
        //Retorna a página de formulário de alunos
        return "aluno/formularioAluno";
    }

    //Método para salvar um aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        //Salvar o aluno
        service.save(aluno);
        //Redireciona para a lista de alunos
        return "redirect:/alunos/listar";
    }

    //Método para abrir o formulário de edição de aluno
    @GetMapping("editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        //Busca o aluno pelo id
        Aluno aluno = service.findById(id);
        //Adiciona o aluno ao método
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoservice.findAll();
        model.addAttribute("cursos", cursos);
        //Retorna a página de formulário de aluno
        return "aluno/formularioAluno";
    }

    //Método para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        //Exclui o aluno pelo id
        service.deleteById(id);
        //Redireciona para a lista de aluno
        return "redirect:/alunos/listar";
    }
     
}
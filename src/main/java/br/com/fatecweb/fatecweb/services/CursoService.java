package br.com.fatecweb.fatecweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecweb.fatecweb.entity.Aluno;
import br.com.fatecweb.fatecweb.entity.Curso;
import br.com.fatecweb.fatecweb.repository.CursoRepository;

@Service
public class CursoService {

    //Injeção de dependencias do respositório de Curso

    @Autowired
    private CursoRepository repository;

    //Método para salvar um aluno
    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    //Método para lidar todos os alunos
    public List<Curso> findAll() {
        return repository.findAll();
    }

        //Método para buscar um curso pelo ID
    public Curso findById(Integer id) {
        //Retorna o curso com id especificado ou nulo se não existir
        return repository.findById(id).orElse(null);
    }

    //Método para excluir um curso pelo ID
    public void deleteById(Integer id) {
        //Excluindo o curso com o id especificado
        repository.deleteById(id);
    }
}
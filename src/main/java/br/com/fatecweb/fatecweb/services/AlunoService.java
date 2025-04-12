package br.com.fatecweb.fatecweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecweb.fatecweb.entity.Aluno;
import br.com.fatecweb.fatecweb.repository.AlunoRepository;

@Service
public class AlunoService {

    //Injeção de dependencias do respositório de Aluno

    @Autowired
    private AlunoRepository repository;

    //Método para salvar um aluno
    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }

    //Método para lidar todos os alunos
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    //Método para buscar um aluno pelo ID
    public Aluno findById(Integer id) {
        //Retorna o aluno com id especificado ou nulo se não existir
        return repository.findById(id).orElse(null);
    }

    //Método para excluir um aluno pelo ID
    public void deleteById(Integer id) {
        //Excluindo o aluno com o id especificado
        repository.deleteById(id);
    }

}

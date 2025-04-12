package br.com.fatecweb.fatecweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecweb.fatecweb.entity.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {
    
}

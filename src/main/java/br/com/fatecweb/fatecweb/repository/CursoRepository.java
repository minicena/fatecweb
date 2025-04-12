package br.com.fatecweb.fatecweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecweb.fatecweb.entity.Curso;

public interface CursoRepository  extends JpaRepository<Curso, Integer> {
    
}

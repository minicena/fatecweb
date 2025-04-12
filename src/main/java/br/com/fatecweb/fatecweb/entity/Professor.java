package br.com.fatecweb.fatecweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Pessoa{
    
    @Column(nullable = false, length = 40)
    private String formacaoProfessor;

    private Integer matriculaProfessor;
}

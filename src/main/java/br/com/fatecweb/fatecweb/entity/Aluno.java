package br.com.fatecweb.fatecweb.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false, length = 40)
    private String nomeAluno;

    @Column(nullable = false, length = 40)
    private String enderecoAluno;

    @Column(nullable = false, length = 11)
    private String cpfAluno;

    @Column(nullable = false, length = 11)
    private String telefoneAluno;

    private String raAluno;

    @ManyToOne
    @JoinColumn(name = "IdCurso_fk")
    private Curso curso;

}

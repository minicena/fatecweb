package br.com.fatecweb.fatecweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecweb.fatecweb.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findfindByLoginUsuario(String loginUsuario);
}

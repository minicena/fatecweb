package br.com.fatecweb.fatecweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fatecweb.fatecweb.entity.Usuario;
import br.com.fatecweb.fatecweb.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLoginUsuario(login)  // Corrigido aqui
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado " + login));
        return new UserDetailsImpl(usuario);
    }
}

package com.teste.gradle.demo.config.security;

import java.util.Optional;

import com.teste.gradle.demo.modelo.Usuario;
import com.teste.gradle.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
    Optional<Usuario> usuario = usuarioRepository.findByEmail(username);

    if(usuario.isPresent())
    {
      return usuario.get();
    }

    throw new UsernameNotFoundException("Dados invalidos!");

  }

}
package com.teste.gradle.demo.repository;

import java.util.Optional;

import com.teste.gradle.demo.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findByEmail(String nome);


}
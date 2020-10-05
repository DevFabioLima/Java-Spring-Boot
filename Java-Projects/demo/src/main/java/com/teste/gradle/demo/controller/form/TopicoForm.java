package com.teste.gradle.demo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.teste.gradle.demo.modelo.Curso;
import com.teste.gradle.demo.modelo.Topico;
import com.teste.gradle.demo.repository.CursoRepository;

import org.hibernate.validator.constraints.Length;

public class TopicoForm {
  
  @NotNull @NotEmpty @Length(min = 5)
  private String titulo;

  @NotNull @NotEmpty @Length(min = 7)
  private String mensagem;

  @NotNull @NotEmpty @Length(min = 3)
  private String nomeCurso;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getNomeCurso() {
    return nomeCurso;
  }

  public void setNomeCurso(String nomeCurso) {
    this.nomeCurso = nomeCurso;
  }

public Topico converter(CursoRepository cursoRepository) {
  Curso curso = cursoRepository.findByNome(nomeCurso);
	return new Topico(titulo, mensagem, curso);
}

  
}
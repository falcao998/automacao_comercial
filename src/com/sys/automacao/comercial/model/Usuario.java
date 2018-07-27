package com.sys.automacao.comercial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_usuario")
public class Usuario {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="NOME",nullable=false)
	private String nome;
	@Column(name="MATRICULA",nullable=false, unique=true)
	private String matricula;
	@Column(name="SENHA",nullable=false)
	private String senha;
	@Column(name="EMAIL",nullable=false)
	private String email;
	@Column(name="STATUS",nullable=false)
	private String status;
	@Column(name="NIVEL",nullable=false)
	private String nivel;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nome, String matricula, String senha, String email, String status, String nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
		this.email = email;
		this.status = status;
		this.nivel = nivel;
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMatricula() {
		return matricula;
	}
	
}
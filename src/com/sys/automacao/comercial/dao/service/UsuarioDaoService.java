package com.sys.automacao.comercial.dao.service;

import java.util.List;

import com.sys.automacao.comercial.dao.repository.UsuarioJpaDao;
import com.sys.automacao.comercial.model.Usuario;

public class UsuarioDaoService {

	UsuarioJpaDao repository = new UsuarioJpaDao();
	
	public Usuario find(Integer id) {
		Usuario usuario = repository.findById(id);
		repository.closeEntity();
		return usuario == null ? null : usuario;
	}
	
	public Usuario login(String matricula, String senha) {
		Usuario usuario = repository.findByMatriculaAndSenhaAndStatus(matricula,	senha, "ATIVO");
		repository.closeEntity();
		return usuario == null ? null : usuario;
	}
	
	public Usuario loginInativo(String matricula, String senha) {
		return repository.findByMatriculaAndSenhaAndStatus(matricula,	senha, "INATIVO");
	}
	
	public boolean save(String matricula,String nome,String senha, String email, String status, String nivel) {
		Usuario usuario = new Usuario(nome, matricula, senha, email, status, nivel);
		return repository.save(usuario);
	}
	
	public boolean remove(Integer id) {
		return repository.delete(find(id));
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}
	
	public List<Usuario> search(String pesquisa) {
		return repository.searchList(pesquisa);
	}
}
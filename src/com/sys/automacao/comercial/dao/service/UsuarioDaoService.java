package com.sys.automacao.comercial.dao.service;

import com.sys.automacao.comercial.dao.repository.UsuarioJpaDao;
import com.sys.automacao.comercial.model.Usuario;

public class UsuarioDaoService {

	UsuarioJpaDao repository = new UsuarioJpaDao();
	
	public Usuario find(Integer id) {
		Usuario usuario = repository.findById(id);
		return usuario == null ? null : usuario;
	}
	
	public Usuario login(String user, String senha) {
		Usuario usuario = repository.findByUserAndSenha(user,senha);
		return usuario == null ? null : usuario;
	}
	
	public Usuario loginAtivo(String user, String senha) {
		Usuario usuario = repository.findByUserAndSenhaAndStatus(user,	senha, "ATIVO");
		return usuario == null ? null : usuario;
	}
	
	public Usuario loginInativo(String user, String senha) {
		return repository.findByUserAndSenhaAndStatus(user,	senha, "INATIVO");
	}
}
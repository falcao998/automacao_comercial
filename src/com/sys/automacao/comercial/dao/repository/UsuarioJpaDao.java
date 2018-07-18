package com.sys.automacao.comercial.dao.repository;

import javax.persistence.EntityManager;

import com.sys.automacao.comercial.dao.ConexaoMySQLJPA;
import com.sys.automacao.comercial.model.Usuario;

public class UsuarioJpaDao {
	
	private EntityManager entity;
	
	public UsuarioJpaDao() {
		if (entity == null) {
			entity = ConexaoMySQLJPA.getEntityManagerMySQL();
		}
	}
	
	public Usuario findById(int id) {
		return entity.find(Usuario.class, id);
	}
	
	public Usuario findByUserAndSenha(String user, String senha) {
		return null;
	}
	
	public Usuario findByUserAndSenhaAndStatus(String user, String senha, String status) {
		return null;
	}
}

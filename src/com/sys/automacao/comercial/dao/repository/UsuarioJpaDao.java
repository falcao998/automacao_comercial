package com.sys.automacao.comercial.dao.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sys.automacao.comercial.dao.JpaUtil;
import com.sys.automacao.comercial.model.Usuario;

public class UsuarioJpaDao {
	
	private EntityManager entity;
	
	public UsuarioJpaDao() {
		entity = JpaUtil.getEntityManager();
	}
	
	public Usuario findById(int id) {
		entity = JpaUtil.getEntityManager();
		return entity.find(Usuario.class, id);
	}
	
	public Usuario findByUserAndSenha(String user, String senha) {
		return null;
	}
	
	public Usuario findByUserAndSenhaAndStatus(String user, String senha, String status) {
		try {
			entity = JpaUtil.getEntityManager();
			String consulta = "select c from Usuario c where c.user = :user and c.senha = :senha and status = :status";
			TypedQuery<Usuario> query = entity.createQuery(consulta, Usuario.class);
			query.setParameter("user", user);
			query.setParameter("senha", senha);
			query.setParameter("status", status);
			
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void closeEntity() {
		JpaUtil.closeEntityManager();
	}
}

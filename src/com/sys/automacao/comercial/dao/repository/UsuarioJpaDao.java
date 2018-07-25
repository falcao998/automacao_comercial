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
	
	public boolean save(Usuario usuario) {
		try {
			entity.persist(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Usuario findByMatriculaAndSenha(String matricula, String senha) {
		return null;
	}
	
	public Usuario findByMatriculaAndSenhaAndStatus(String matricula, String senha, String status) {
		try {
			entity = JpaUtil.getEntityManager();
			String consulta = "select c from Usuario c where c.matricula = :matricula and c.senha = :senha and status = :status";
			TypedQuery<Usuario> query = entity.createQuery(consulta, Usuario.class);
			query.setParameter("matricula", matricula);
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

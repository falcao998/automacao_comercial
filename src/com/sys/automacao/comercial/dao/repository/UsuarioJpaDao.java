package com.sys.automacao.comercial.dao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sys.automacao.comercial.dao.JpaUtil;
import com.sys.automacao.comercial.model.Usuario;

public class UsuarioJpaDao {
	
	private EntityManager entity;
	
	public UsuarioJpaDao() {
		entity = JpaUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
        return entity.createQuery("FROM Usuario").getResultList();
	}
	
	public Usuario findById(int id) {
		entity = JpaUtil.getEntityManager();
		return entity.find(Usuario.class, id);
	}
	
	public boolean save(Usuario usuario) {
		try {
			if (!entity.getTransaction().isActive()) {
				entity = JpaUtil.getEntityManager();
			}
			entity.getTransaction().begin();
			entity.persist(usuario);
			entity.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
            entity.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean delete(Usuario usuario) {
		try {
			if (!entity.getTransaction().isActive()) {
				entity = JpaUtil.getEntityManager();
			}
			entity.getTransaction().begin();
			entity.remove(entity.merge(usuario));
			entity.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
            entity.getTransaction().rollback();
			return false;
		}
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
	
	public List<Usuario> searchList(String pesquisa) {
		try {
			entity = JpaUtil.getEntityManager();
			String consulta = "SELECT c FROM Usuario c WHERE (LOWER(c.matricula) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.nivel) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.nome) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.email) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.status) LIKE LOWER('%'||:pesquisa||'%'))";
			TypedQuery<Usuario> query = entity.createQuery(consulta, Usuario.class);
			query.setParameter("pesquisa", pesquisa);
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void closeEntity() {
		JpaUtil.closeEntityManager();
	}
}

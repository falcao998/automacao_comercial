package com.sys.automacao.comercial.dao.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sys.automacao.comercial.dao.JpaUtil;
import com.sys.automacao.comercial.model.Cliente;

public class ClienteJpaDao {

	EntityManager entity;
	
	public ClienteJpaDao() {
		entity = JpaUtil.getEntityManager();
	}
	
	public void closeJpa() {
		JpaUtil.closeEntityManager();
	}
	
	private void getEntity() {
		if(entity == null)
			entity = JpaUtil.getEntityManager();
	}
	
	private void getEntityTransaction() {
		if(!entity.getTransaction().isActive())
			entity = JpaUtil.getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		return entity.createQuery("FROM Cliente").getResultList();
	}
	
	public Cliente findById(Integer id) {
		getEntity();
		return entity.find(Cliente.class, id);
	}
	
	public List<Cliente> searchList(String pesquisa) {
		try {
			getEntity();
			String consulta = "SELECT c FROM Cliente c WHERE (LOWER(c.codigo) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.telefone1) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.nome) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.email) LIKE LOWER('%'||:pesquisa||'%')) OR"
					+ " (LOWER(c.status) LIKE LOWER('%'||:pesquisa||'%'))";
			TypedQuery<Cliente> query = entity.createQuery(consulta, Cliente.class);
			query.setParameter("pesquisa", pesquisa);
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean save(Cliente cliente) {
		try {
			if (!entity.getTransaction().isActive()) {
				entity = JpaUtil.getEntityManager();
			}
			entity.getTransaction().begin();
			entity.persist(entity.merge(cliente));
			entity.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
            entity.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean delete(Cliente cliente) {
		try {
			if (!entity.getTransaction().isActive()) {
				entity = JpaUtil.getEntityManager();
			}
			entity.getTransaction().begin();
			entity.remove(entity.merge(cliente));
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
	
}

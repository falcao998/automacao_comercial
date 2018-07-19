package com.sys.automacao.comercial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory;
	private static final String PERSISTENCE_UNIT_MYSQL = "com.sys.automacaocomercial.jpa.mysql";
	private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();

	private JpaUtil() {
		throw new IllegalStateException("Classe Utilitária.");
	}

	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_MYSQL);
		}

		EntityManager entityManager = threadEntityManager.get();

		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = entityManagerFactory.createEntityManager();
			JpaUtil.threadEntityManager.set(entityManager);
		}

		return entityManager;
	}

	public static void closeEntityManager() {
		EntityManager em = threadEntityManager.get();

		if (em != null) {
			EntityTransaction transaction = em.getTransaction();

			if (transaction.isActive()) {
				transaction.commit();
			}

			em.close();

			threadEntityManager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		entityManagerFactory.close();
	}

}
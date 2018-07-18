package com.sys.automacao.comercial.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoMySQLJPA {
	
	private static EntityManagerFactory factoryMySQL = null;
    private static final String PERSISTENCE_UNIT_MYSQL = "com.sys.automacaocomercial.jpa.mysql";
    
    private ConexaoMySQLJPA() {
        throw new IllegalStateException("Classe Utilitária.");
    }

    static {
    	if(factoryMySQL == null)
    		factoryMySQL = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_MYSQL);
	}

    public static EntityManager getEntityManagerMySQL() {
    	return factoryMySQL.createEntityManager();
	}

}
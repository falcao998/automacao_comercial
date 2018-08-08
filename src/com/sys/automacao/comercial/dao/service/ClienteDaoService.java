package com.sys.automacao.comercial.dao.service;

import java.util.List;

import com.sys.automacao.comercial.dao.repository.ClienteJpaDao;
import com.sys.automacao.comercial.model.Cliente;

public class ClienteDaoService {
	
	ClienteJpaDao repository = new ClienteJpaDao();
	
	public Cliente find(Integer id) {
		Cliente cliente = repository.findById(id);
		repository.closeJpa();
		return cliente == null ? null : cliente;
	}
	
	public boolean save(Integer id, String matricula,String nome,String senha, String email, String status, String nivel) {
		Cliente cliente = new Cliente();
		return repository.save(cliente);
	}
	
	public boolean remove(Integer id) {
		return repository.delete(find(id));
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public List<Cliente> search(String pesquisa) {
		return repository.searchList(pesquisa);
	}
}

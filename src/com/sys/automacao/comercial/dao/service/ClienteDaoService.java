package com.sys.automacao.comercial.dao.service;

import java.util.List;

import com.sys.automacao.comercial.dao.repository.ClienteJpaDao;
import com.sys.automacao.comercial.model.Cliente;
import com.sys.automacao.comercial.model.Usuario;

public class ClienteDaoService {
	
	ClienteJpaDao repository = new ClienteJpaDao();
	
	public Cliente find(Integer id) {
		Cliente cliente = repository.findById(id);
		repository.closeJpa();
		return cliente == null ? null : cliente;
	}
	
	public Usuario login(String matricula, String senha) {
//		Usuario usuario = repository.findByCodigoAndSenhaAndStatus(matricula,	senha, "ATIVO");
//		repository.closeJpa();
//		return usuario == null ? null : usuario;
		return null;
	}
	
	public Usuario loginInativo(String matricula, String senha) {
//		return repository.findByMatriculaAndSenhaAndStatus(matricula,	senha, "INATIVO");
		return null;
	}
	
	public boolean save(Integer id, String matricula,String nome,String senha, String email, String status, String nivel) {
//		Usuario usuario = new Usuario(id, nome, matricula, senha, email, status, nivel);
//		return repository.save(usuario);
		return false;
	}
	
	public boolean remove(Integer id) {
//		return repository.delete(find(id));
		return false;
	}
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public List<Cliente> search(String pesquisa) {
		return repository.searchList(pesquisa);
	}
}

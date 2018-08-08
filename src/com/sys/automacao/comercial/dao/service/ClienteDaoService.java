package com.sys.automacao.comercial.dao.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	
	public boolean save(Integer id, String codigo, String nome, LocalDateTime dataCadastro, String telefone1, String telefone2,
			String telefone3, String email, String site, Double limiteCredito, String observacao,
			String vendedorPreferencial, String codigoRegimeTributario, String ibge, byte[] fotoCLiente,
			LocalDate dataNascimento, String cep, String endereco, String numero, String complemento, String bairro,
			String cidade, String estado, boolean pessoaFIsica, String cpf, String identidade, String cnpj,
			String inscricaoEstaual, String status) {
		
		Cliente cliente = new Cliente(id, codigo, nome, dataCadastro, telefone1, telefone2, telefone3, email, site,
				limiteCredito, observacao, vendedorPreferencial, codigoRegimeTributario, ibge, fotoCLiente, dataNascimento,
				cep, endereco, numero, complemento, bairro, cidade, estado, pessoaFIsica, cpf, identidade, cnpj, 
				inscricaoEstaual, status);
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

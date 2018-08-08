package com.sys.automacao.comercial.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="sys_cliente")
public class Cliente {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="CODIGO",unique=true,nullable=false,length=8)
	private String codigo;
	
	@Column(name="NOME",nullable=false,length=120)
	private String nome;
	
	@Column(name="DATA_CADASTRO",nullable=false)
	private LocalDateTime dataCadastro;
	
	@Column(name="TELEFONE_1")
	private String telefone1;
	
	@Column(name="TELEFONE_2")
	private String telefone2;
	
	@Column(name="TELEFONE_3")
	private String telefone3;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SITE")
	private String site;
	
	@Column(name="LIMITE_CREDITO")
	private Double limiteCredito;
	
	@Column(name="OBSERVACAO")
	private String observacao;
	
	@Column(name="VENDEDOR_PREFERENCIAL")
	private String vendedorPreferencial;
	
	@Column(name="CODIGO_REGIME_TRIBUTARIO")
	private String codigoRegimeTributario;
	
	@Column(name="IBGE")
	private String ibge;
	
	@Lob
	@Column(name="FOTO_CLIENTE")
	private byte[] fotoCLiente;
	
	@Column(name="DATA_NASCIMENTO")
	private LocalDate dataNascimento;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="NUMERO")
	private String numero;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="PESSOA_FISICA")
	private boolean pessoaFIsica;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="IDENTIDADE")
	private String identidade;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@Column(name="INSCRICAO_ESTADUAL")
	private String inscricaoEstaual;
	
	@Column(name="STATUS")
	private String status;
	
	public Cliente() {
		
	}
	
	public Cliente(Integer id, String codigo, String nome, LocalDateTime dataCadastro, String telefone1, String telefone2,
			String telefone3, String email, String site, Double limiteCredito, String observacao,
			String vendedorPreferencial, String codigoRegimeTributario, String ibge, byte[] fotoCLiente,
			LocalDate dataNascimento, String cep, String endereco, String numero, String complemento, String bairro,
			String cidade, String estado, boolean pessoaFIsica, String cpf, String identidade, String cnpj,
			String inscricaoEstaual, String status) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.telefone3 = telefone3;
		this.email = email;
		this.site = site;
		this.limiteCredito = limiteCredito;
		this.observacao = observacao;
		this.vendedorPreferencial = vendedorPreferencial;
		this.codigoRegimeTributario = codigoRegimeTributario;
		this.ibge = ibge;
		this.fotoCLiente = fotoCLiente;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pessoaFIsica = pessoaFIsica;
		this.cpf = cpf;
		this.identidade = identidade;
		this.cnpj = cnpj;
		this.inscricaoEstaual = inscricaoEstaual;
		this.status = status;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getVendedorPreferencial() {
		return vendedorPreferencial;
	}

	public void setVendedorPreferencial(String vendedorPreferencial) {
		this.vendedorPreferencial = vendedorPreferencial;
	}

	public String getCodigoRegimeTributario() {
		return codigoRegimeTributario;
	}

	public void setCodigoRegimeTributario(String codigoRegimeTributario) {
		this.codigoRegimeTributario = codigoRegimeTributario;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public byte[] getFotoCLiente() {
		return fotoCLiente;
	}

	public void setFotoCLiente(byte[] fotoCLiente) {
		this.fotoCLiente = fotoCLiente;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isPessoaFIsica() {
		return pessoaFIsica;
	}

	public void setPessoaFIsica(boolean pessoaFIsica) {
		this.pessoaFIsica = pessoaFIsica;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstaual() {
		return inscricaoEstaual;
	}

	public void setInscricaoEstaual(String inscricaoEstaual) {
		this.inscricaoEstaual = inscricaoEstaual;
	}

	public Integer getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
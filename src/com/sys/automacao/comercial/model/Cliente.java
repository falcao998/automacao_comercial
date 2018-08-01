package com.sys.automacao.comercial.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sys_cliente")
public class Cliente {

	@Id
	private Long id;
	
	@Column(name="CODIGO",unique=true,nullable=false,length=8)
	private String codigo;
	
	@Column(name="NOME",nullable=false,length=120)
	private String nome;
	
	@Column(name="DATA_CADASTRO",nullable=false)
	private LocalDateTime dataCadastro;
	
	/*
	-	CPF
	-	IDENTIDADE
	
	-	CNPJ
	-	INSCRIÇÃO ESTADUAL
	-	INSCRIÇÃO MUNICIPAL
	-	DATA NASCIMENTO
	
	-	CEP
	-	ENDEREÇO
	-	NÚMERO
	-	COMPLEMENTO
	-	BAIRRO
	-	CIDADE
	-	ESTADO
	
	-	IBGE
	-	CRT CÓDIGO DE REGIME TRIBUTÁRIO
	
	-	TELEFONE 1
	-	TELEFONE 2
	- 	TELEFONE 3
	-	EMAIL
	-	SITE
	-	LIMITE DE CRÉDITO
	-	OBSERVAÇÕES
	-	FOTO DO CLIENTE
	-	INFORMAÇÕES COMPLEMENTARES
	-	VENDEDOR PREFERENCIAL
	
	*/
}

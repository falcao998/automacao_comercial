package com.sys.automacao.comercial.model;

public enum StatusUsuarioEnum {
	
	ATIVO("ATIVO"), INATIVO("INATIVO"),EXCLUIDO("EXCLUÍDO");

	private String status;
	
	StatusUsuarioEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
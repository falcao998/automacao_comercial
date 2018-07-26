package com.sys.automacao.comercial.model;

public enum NivelUsuarioEnum {

	VENDEDOR("VENDEDOR"),GERENTE("GERENTE"),ADMINISTRADOR("ADMINISTRADOR"),RECURSOS_HUMANOS("RECURSOS_HUMANOS"),CONTÁBIL("CONTÁBIL");
	
	private String nivel;
	
	NivelUsuarioEnum(String nivel) {
		this.nivel = nivel;
	}

	public String getNivel() {
		return nivel;
	}
}
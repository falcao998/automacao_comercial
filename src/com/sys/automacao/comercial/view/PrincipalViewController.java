package com.sys.automacao.comercial.view;

import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

public class PrincipalViewController {
	
	private ExchangeStage exchangeStage = new ExchangeStage();
	
	@FXML
	private BorderPane borderPanePrincipal;

	@FXML
	public void handleSair() {
		System.exit(0);
	}
	
	@FXML
	public void hadlerTrocarUsuario() {
		sairTela();
	}
	
	@FXML
	public void hadlerCadastroUsuario() {
		usuarioTela();
	}
	
	@FXML
	public void hadlerCadastroCliente() {
		clienteTela();
	}
	
	public void sairTela() {
		exchangeStage.exchange("/com/sys/automacao/comercial/view/Login.fxml", StageStyle.UNDECORATED, borderPanePrincipal, false, null);
	}
	
	public void usuarioTela() {
		exchangeStage.exchange("/com/sys/automacao/comercial/view/usuario/UsuarioListar.fxml", StageStyle.DECORATED,"CADASTRO DE USUÁRIO(S)");
	}
	
	public void clienteTela() {
		exchangeStage.exchange("/com/sys/automacao/comercial/view/cliente/ClienteListar.fxml", StageStyle.DECORATED,"CADASTRO DE CLIENTE(S)");
	}
}

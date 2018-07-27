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
	
	public void sairTela() {
		exchangeStage.exchange("../view/Login.fxml", StageStyle.UNDECORATED, borderPanePrincipal, false,"LOGIN");
	}
	
	public void usuarioTela() {
		exchangeStage.exchange("../view/UsuarioListar.fxml", StageStyle.DECORATED,"CADASTRO DE USUÁRIO(S)");
	}
}

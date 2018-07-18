package com.sys.automacao.comercial.view;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;
//import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginViewController {
	
	private UsuarioDaoService service = new UsuarioDaoService();
	
//	private ExchangeStage exchangeStage;
	
	@FXML
	private AnchorPane anchorPaneLogin;
	
	@FXML
	private JFXTextField tfUsuario;
	
	@FXML
	private JFXPasswordField pfSenha;
	
	@FXML
	private Label lUsuarioEmpty;
	
	@FXML
	private Label lSenhaEmpty;
	
	@FXML
	private Label lUsuarioError;
	
	@FXML
	public void handleSair() {
		Stage stage = (Stage)anchorPaneLogin.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void handleLogin() {
		if (testeEmptyUsuarioSenha()) {
			Usuario usuario = service.loginAtivo(tfUsuario.getText(), pfSenha.getText());
			if (usuario == null)
				showMenssagemError();
			else
				sucessLogin();
		}
	}
	
	@FXML
	public void handleDigitarUsuario() {
		testeUsuarioEmpty(true);
	}
	
	@FXML
	public void handleDigitarSenha() {
		testeSenhaEmpty(true);
	}
	
	public void sucessLogin() {
		System.out.println(service.find(1).getNome());
	}
	
	private boolean testeUsuarioEmpty(boolean teste) {
		lUsuarioEmpty.setVisible(false);
		if (tfUsuario.getText().trim().isEmpty()) {
			teste = false;
			lUsuarioEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeSenhaEmpty(boolean teste) {
		lSenhaEmpty.setVisible(false);
		if (pfSenha.getText().trim().isEmpty()) {
			teste = false;
			lSenhaEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeEmptyUsuarioSenha() {
		boolean teste = true;
		
		lUsuarioError.setVisible(false);
		
		teste = testeUsuarioEmpty(teste);
		teste = testeSenhaEmpty(teste);
		
		return teste;
	}
	
	private void showMenssagemError() {
		lUsuarioError.setVisible(true);
	}
	
}
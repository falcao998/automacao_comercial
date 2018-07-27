package com.sys.automacao.comercial.view;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class LoginViewController {
	
	private UsuarioDaoService service = new UsuarioDaoService();
	
	private ExchangeStage exchangeStage = new ExchangeStage();
	
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
		System.exit(0);
	}
	
	@FXML
	public void handleLogin() {
		if (testeEmptyUsuarioSenha()) {
			Usuario usuario = service.login(tfUsuario.getText(), pfSenha.getText());
			if (usuario == null)
				showMenssagemError();
			else
				sucessLogin();
		}
	}
	
	@FXML
	public void handleDigitarUsuario(KeyEvent e) {
		if(e.getCode().equals(KeyCode.ENTER))
	    	handleLogin();
		else
			testeUsuarioEmpty(true);
	}
	
	@FXML
	public void handleDigitarSenha(KeyEvent e) {
		if(e.getCode().equals(KeyCode.ENTER))
	    	handleLogin();
		else
			testeSenhaEmpty(true);
	}
	
	public void sucessLogin() {
		exchangeStage.exchange("../view/Principal.fxml", StageStyle.UNDECORATED, anchorPaneLogin, true, "SYS - AUTOMAÇÃO COMERCIAL");
	}
	
	private boolean testeUsuarioEmpty(boolean teste) {
		lUsuarioEmpty.setVisible(false);
		hideMenssagemError();
		if (tfUsuario.getText().trim().isEmpty()) {
			teste = false;
			lUsuarioEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeSenhaEmpty(boolean teste) {
		lSenhaEmpty.setVisible(false);
		hideMenssagemError();
		if (pfSenha.getText().trim().isEmpty()) {
			teste = false;
			lSenhaEmpty.setVisible(true);
		}
		return teste;
	}
	
	private boolean testeEmptyUsuarioSenha() {
		boolean teste = true;
		
		hideMenssagemError();
		
		teste = testeUsuarioEmpty(teste);
		teste = testeSenhaEmpty(teste);
		
		return teste;
	}
	
	private void showMenssagemError() {
		lUsuarioError.setVisible(true);
	}
	
	private void hideMenssagemError() {
		lUsuarioError.setVisible(false);
	}
	
}
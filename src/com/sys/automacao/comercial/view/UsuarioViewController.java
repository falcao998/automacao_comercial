package com.sys.automacao.comercial.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UsuarioViewController {
	
	ExchangeStage exchangeStage = new ExchangeStage();
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	JFXTextField tfMatricula;
	
	@FXML
	JFXTextField tfNome;
	
	@FXML
	JFXTextField tfSenha;
	
	@FXML
	JFXTextField tfEmail;
	
	@FXML
	JFXComboBox cbNivel;
	
	@FXML
	JFXComboBox cbStatus;
	
	@FXML
	JFXButton butSair;
	
	@FXML
	JFXButton butSalvar;
	
	@FXML
	public void handleSair() {
		exchangeStage.closePanelIntern(anchorPane);
	}
}
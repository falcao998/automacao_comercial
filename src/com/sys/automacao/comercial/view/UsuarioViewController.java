package com.sys.automacao.comercial.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.NivelUsuarioEnum;
import com.sys.automacao.comercial.model.StatusUsuarioEnum;
import com.sys.automacao.comercial.model.Usuario;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UsuarioViewController {
	
	ExchangeStage exchangeStage = new ExchangeStage();
	
	UsuarioDaoService service = new UsuarioDaoService();
	
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
	JFXComboBox<NivelUsuarioEnum> cbNivel;
	
	@FXML
	JFXComboBox<StatusUsuarioEnum> cbStatus;
	
	@FXML
	JFXButton butSair;
	
	@FXML
	JFXButton butSalvar;
	
	@FXML
	public void initialize() {
		cbStatus.setItems( FXCollections.observableArrayList( StatusUsuarioEnum.values()));
		cbNivel.setItems( FXCollections.observableArrayList( NivelUsuarioEnum.values()));
	}
	
	@FXML
	public void handleSair() {
		exchangeStage.closePanelIntern(anchorPane);
	}
	
	@FXML
	public void handleSalvar() {
		service.save(tfMatricula.getText(), tfNome.getText(), tfSenha.getText(), tfEmail.getText(), cbStatus.getValue().toString(), cbNivel.getValue().toString());
	}
}
package com.sys.automacao.comercial.view.cliente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Cliente;
import com.sys.automacao.comercial.model.NivelUsuarioEnum;
import com.sys.automacao.comercial.model.StatusUsuarioEnum;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ClienteViewController {
	
	private Cliente cliente;
	
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
	JFXButton butApagar;
	
	public ClienteViewController(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@FXML
	public void initialize() {
		cbStatus.setItems( FXCollections.observableArrayList( StatusUsuarioEnum.values()));
		
		if(cliente != null) {
			tfMatricula.setText(cliente.getCodigo());
			tfNome.setText(cliente.getNome());
			tfSenha.setText(cliente.getCep());
			tfEmail.setText(cliente.getEmail());
			cbNivel.setValue(NivelUsuarioEnum.valueOf(cliente.getBairro()));
			cbStatus.setValue(StatusUsuarioEnum.valueOf(cliente.getStatus()));
			butApagar.setDisable(false);
			
		}
	}
	
	@FXML
	public void handleDeletar() {
		service.remove(cliente.getId());
		exchangeStage.closePanelIntern(anchorPane);
	}
	
	@FXML
	public void handleSair() {
		exchangeStage.closePanelIntern(anchorPane);
	}
	
	@FXML
	public void handleSalvar() {
		service.save((cliente != null ? cliente.getId() : null), tfMatricula.getText(), tfNome.getText(), tfSenha.getText(), tfEmail.getText(),
					 cbStatus.getValue().toString(), cbNivel.getValue().toString());
		exchangeStage.closePanelIntern(anchorPane);
	}
}

package com.sys.automacao.comercial.view.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sys.automacao.comercial.dao.service.ClienteDaoService;
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
	
	ClienteDaoService service = new ClienteDaoService();
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	JFXTextField tfCodigo;
	
	@FXML
	JFXTextField tfNome;
	
	/*@FXML
	JFXDatePicker dataCadastro;*/
	
	@FXML
	JFXTextField telefone1;
	
	@FXML
	JFXTextField telefone2;
	
	@FXML
	JFXTextField telefone3;
	
	@FXML
	JFXTextField tfEmail;
	
	@FXML
	JFXTextField site;
	
	/*@FXML
	JFXTextField limiteCredito;*/
	
	@FXML
	JFXTextArea observacao;
	
	@FXML
	JFXTextField vendedorPreferencial;
	
	@FXML
	JFXTextField codigoRegimeTributario;
	
	@FXML
	JFXTextField ibge;
	
	/*@FXML
	JFXTextField fotoCLiente;*/
	
	/*@FXML
	JFXTextField dataNascimento;*/
	
	@FXML
	JFXTextField cep;
	
	@FXML
	JFXTextField endereco;
	
	@FXML
	JFXTextField numero;
	
	@FXML
	JFXTextField complemento;
	
	@FXML
	JFXTextField bairro;
	
	@FXML
	JFXTextField cidade;
	
	@FXML
	JFXTextField estado;
	
	/*@FXML
	JFXTextField pessoaFIsica;*/
	
	@FXML
	JFXTextField cpf;
	
	@FXML
	JFXTextField identidade;
	
	@FXML
	JFXTextField cnpj;
	
	@FXML
	JFXTextField inscricaoEstaual;
	
	@FXML
	JFXTextField tfSenha;
	
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
			tfCodigo.setText(cliente.getCodigo());
			tfNome.setText(cliente.getNome());
			tfSenha.setText(cliente.getCep());
			tfEmail.setText(cliente.getEmail());
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
//		service.save((cliente != null ? cliente.getId() : null), tfCodigo.getText(), tfNome.getText(), tfSenha.getText(), tfEmail.getText(),cbStatus.getValue().toString(), cbNivel.getValue().toString());
		exchangeStage.closePanelIntern(anchorPane);
	}
}

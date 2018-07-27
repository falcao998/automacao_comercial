package com.sys.automacao.comercial.view;

import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class UsuarioListarViewController {
	
	UsuarioDaoService service = new UsuarioDaoService();
	
	ObservableList<Usuario> data = FXCollections.observableArrayList(service.findAll());
	
	ExchangeStage exchange = new ExchangeStage();
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	TableView<Usuario> tableView;
	
	@FXML
	TableColumn<Usuario, Integer> colId;
	
	@FXML
	TableColumn<Usuario, String> colMatricula;
  		
  	@FXML
  	TableColumn<Usuario, String> colNome;
  		
  	@FXML
  	TableColumn<Usuario, String> colEmail;
  	
  	@FXML	
  	TableColumn<Usuario, String> colStatus;
  		
  	@FXML
  	TableColumn<Usuario, String> colNivel;

	
	@FXML
	public void initialize() {
		colId.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("id"));
		colMatricula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("matricula"));
		colNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));
		colStatus.setCellValueFactory(new PropertyValueFactory<Usuario, String>("status"));
		colNivel.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nivel"));
		tableView.setItems(data);
	}
	
	@FXML
	public void handleSair() {
		exchange.closePanelIntern(anchorPane);
	}
	
	@FXML
	public void handleCadastrar() {
		exchange.exchange("../view/Usuario.fxml", StageStyle.DECORATED,"NOVO USUÁRIO");
	}
	
	@FXML
	public void handleAlterar() {
		System.out.println(tableView.getSelectionModel().getSelectedItem().getId());
	}
	
	@FXML
	public void handleDeletar() {
		System.out.println(tableView.getSelectionModel().getSelectedItem().getId());
	}
}
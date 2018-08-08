package com.sys.automacao.comercial.view.cliente;

import com.sys.automacao.comercial.dao.service.ClienteDaoService;
import com.sys.automacao.comercial.model.Cliente;
import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;

public class ClienteListarViewController {
	
	ExchangeStage exchangeStage = new ExchangeStage();
	
	ClienteDaoService service = new ClienteDaoService();
	
	ObservableList<Cliente> data;
	
	ExchangeStage exchange = new ExchangeStage();
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	TableView<Cliente> tableView;
	
	@FXML
	TableColumn<Cliente, Integer> colId;
	
	@FXML
	TableColumn<Cliente, String> colCodigo;
  		
  	@FXML
  	TableColumn<Cliente, String> colNome;
  		
  	@FXML
  	TableColumn<Cliente, String> colEmail;
  	
  	@FXML	
  	TableColumn<Cliente, String> colStatus;
  		
  	@FXML
  	TableColumn<Cliente, String> colTelefone;
	
	@FXML
	TextField textPesquisar;

	@FXML
	public void handleSair() {
		exchangeStage.closePanelIntern(anchorPane);
	}
	
	@FXML
	public void handleSearch() {
		preencherTable(textPesquisar.getText());
	}
	
	@FXML
	public void handleCadastrar() {
		exchange.exchange("/com/sys/automacao/comercial/view/cliente/Cliente.fxml", StageStyle.DECORATED,"NOVO CLIENTE",new ClienteViewController(null));
	}
	
	@FXML
	public void handleAlterar() {
		if(tableView.getSelectionModel().getSelectedItem() != null)
			exchange.exchange("/com/sys/automacao/comercial/view/cliente/Cliente.fxml", StageStyle.DECORATED,"NOVO CLIENTE", new ClienteViewController(tableView.getSelectionModel().getSelectedItem()));
	}
	
	@FXML
	public void handleDeletar() {
		if(tableView.getSelectionModel().getSelectedItem() != null) {
//			service.remove(tableView.getSelectionModel().getSelectedItem().getId());
			preencherTable(textPesquisar.getText());
		}
	}
	
	@FXML
	public void initialize() {
		colId.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
		colCodigo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("codigo"));
		colNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
		colStatus.setCellValueFactory(new PropertyValueFactory<Cliente, String>("status"));
		colTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone1"));
		tableView.setOnMouseClicked( event -> {
			if( event.getClickCount() == 2 ) {
				handleAlterar();
		}});
	}
	
	public void preencherTable(String pesquisa) {
		data = FXCollections.observableArrayList(service.search(pesquisa));
		tableView.setItems(data);
		tableView.refresh();
	}
}

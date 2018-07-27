package com.sys.automacao.comercial.view;

import com.sys.automacao.comercial.dao.service.UsuarioDaoService;
import com.sys.automacao.comercial.model.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuarioListarViewController {
	
	UsuarioDaoService service = new UsuarioDaoService();
	
	ObservableList<Usuario> data = FXCollections.observableArrayList(service.findAll());
	
	@FXML
	TableView<Usuario> tableView;
	
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
		colMatricula.setCellValueFactory(new PropertyValueFactory<Usuario, String>("matricula"));
		colNome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));
		colEmail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));
		colStatus.setCellValueFactory(new PropertyValueFactory<Usuario, String>("status"));
		colNivel.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nivel"));
		tableView.setItems(data);
	}
}

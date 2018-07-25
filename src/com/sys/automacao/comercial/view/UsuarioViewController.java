package com.sys.automacao.comercial.view;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UsuarioViewController {
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	public void handleSair() {
		Stage screen = (Stage)anchorPane.getScene().getWindow();
		screen.close();
	}
}

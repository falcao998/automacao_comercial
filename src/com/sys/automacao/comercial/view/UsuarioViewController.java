package com.sys.automacao.comercial.view;

import com.sys.automacao.comercial.util.ExchangeStage;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class UsuarioViewController {
	
	ExchangeStage exchangeStage = new ExchangeStage();
	
	@FXML
	AnchorPane anchorPane;
	
	@FXML
	public void handleSair() {
		exchangeStage.closePanelIntern(anchorPane);
	}
}
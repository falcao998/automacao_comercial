package com.sys.automacao.comercial.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExchangeStage {
	
	public void exchange(String screenName, StageStyle style, Pane pane, boolean maximezed) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(screenName));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage login = (Stage)pane.getScene().getWindow();
			login.close();
			Stage stage = new Stage(style);
			stage.setScene(scene);
			stage.centerOnScreen();
			if(maximezed) {
				stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
				stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			}
			stage.show();
		}catch(IOException e) {}
	}
	
	public void exchange(String screenName, StageStyle style) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(screenName));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage stage = new Stage(style);
			stage.setScene(scene);
			stage.centerOnScreen();
			stage.show();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void closePanelIntern(Pane pane) {
		Stage screen = (Stage)pane.getScene().getWindow();
		screen.close();
	}
}
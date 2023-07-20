package com.example.encryptprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EndScreenController {
	@FXML
	private Label resultText;
	@FXML
	private AnchorPane Pane;

	public void exit(ActionEvent e){
		Stage stage = (Stage) Pane.getScene().getWindow();
		stage.close();
	}

	public void displayStatus(String status){
		resultText.setText(status);
	}
}

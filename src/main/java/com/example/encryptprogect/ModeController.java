package com.example.encryptprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeController {

	public void CaesarStart(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("caesar.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void BruteStart(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("brute-force.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
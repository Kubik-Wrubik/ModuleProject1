package com.example.encryptprogect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class CaesarController extends Encryptor{
	@FXML
	TextField inputPath, outputPath, textKey;
	@FXML
	RadioButton button1, button2;

	public void solve(ActionEvent e) throws IOException{
		if(inputPath.getText().equals("") || outputPath.getText().equals("") || textKey.getText().equals("")){
			return;
		}
		String status = "";
		try{

			char[] charText = readTextFromFile(inputPath.getText());
			int key = Integer.parseInt(textKey.getText());

			if(button1.isSelected()){
				status = "encrypted!";
				writeTextIntoFile(outputPath.getText(), encrypt(charText, key));
			}
			else if(button2.isSelected()){
				status = "deciphered!";
				writeTextIntoFile(outputPath.getText(), encrypt(charText, -key));
			}
			else{
				return;
			}
		}catch(IOException exception){
			status = "failed!";
		}

		FXMLLoader loader = new FXMLLoader(getClass().getResource("end-screen.fxml"));
		Parent root = loader.load();

		EndScreenController endScreenController = loader.getController();
		endScreenController.displayStatus(status);

		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

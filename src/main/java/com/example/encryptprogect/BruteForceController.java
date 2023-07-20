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

public class BruteForceController extends Encryptor{
	@FXML
	TextField inputPath, outputPath;

	public void solve(ActionEvent e) throws IOException{
		if(inputPath.getText().equals("") || outputPath.getText().equals("")){
			return;
		}
			char[] encryptedCharText = readTextFromFile(inputPath.getText());
			int maxChar = 256, maxWords = Integer.MIN_VALUE;
			int resultKey = 0;
			char[] decipherChars;
			for(int key = 0; key < maxChar; key++){
				decipherChars = encrypt(encryptedCharText,key);
				int wordCount = new String(decipherChars).split(" ").length;
				if(wordCount > maxWords){
					maxWords = wordCount;
					resultKey = key;
				}
			}

			final char[] decipherResult = encrypt(encryptedCharText, resultKey);
			writeTextIntoFile(outputPath.getText(), decipherResult);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("end-screen.fxml"));
		Parent root = loader.load();

		EndScreenController endScreenController = loader.getController();
		endScreenController.displayStatus("Encrypted: key is " + resultKey);

		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}

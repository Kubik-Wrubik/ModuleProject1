package com.example.encryptprogect;

import java.io.*;

public class Encryptor {

	public char[] encrypt(char[] chars, int key){
		char[] encryptChars = new char[chars.length];
		for(int i = 0; i < chars.length; i++){
			encryptChars[i] = (char) (((int) chars[i] + 128 + key) % 256 - 128);
		}
		return encryptChars;
	}

	public char[] readTextFromFile(String filename) throws IOException{
		StringBuilder text = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
			while(reader.ready()){
				text.append(reader.readLine());
			}
		}
		return text.toString().toCharArray();
	}

	public void writeTextIntoFile(String filename, char[] text) throws IOException{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
			writer.write(text);
		}
	}
}

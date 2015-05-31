package com.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileOperation {

	public void readFile() throws IOException {
		InputStream resourceAsStream = FileOperation.class
				.getResourceAsStream("/com/uday/file/Text.txt");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resourceAsStream));
		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);
		}

	}

	public void wireFile() throws IOException {

		File f = new File("c:\\text2.txt");

		if (f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileWriter fileWriter = new FileWriter(f)) {

			BufferedWriter bw = new BufferedWriter(fileWriter);
			int i = 0;
			while (i != 5) {
				bw.write("Hello ");
				i++;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		new FileOperation().readFile();
		new FileOperation().wireFile();
	}
}

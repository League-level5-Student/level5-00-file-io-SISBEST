package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		// Create a program that takes a message from the user and saves it to a file.
		String message = JOptionPane.showInputDialog(null, "Enter a message to be file-written:", "Samuel's MAGICAL SAVER!", JOptionPane.INFORMATION_MESSAGE);
		try {
			FileWriter fw = new FileWriter("src/beep.txt");
			fw.write(message + " - Printed by Samuel MAGICAL Printer!");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

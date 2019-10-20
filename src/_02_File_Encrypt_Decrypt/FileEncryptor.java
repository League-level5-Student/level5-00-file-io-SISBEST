package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter Message to be encrypted:");
		message = message.replace('a', '$');
		message = message.replace('z', '*');
		message = message.replace('c', '&');
		message = message.replace('b', '^');
		message = message.replace('r', '%');
		message = message.replace('t', '~');
		message = message.replace('m', ']');
		System.out.println(message);
		StringBuilder m = new StringBuilder(message);
		m.reverse();
		String encrypted = new String(m);
		try {
			FileWriter fw = new FileWriter("src/enc.txt");
			System.out.println(encrypted);
			fw.write(encrypted);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

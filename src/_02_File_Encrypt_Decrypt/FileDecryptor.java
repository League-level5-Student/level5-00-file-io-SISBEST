package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/enc.txt"));
			
			String line = br.readLine();
			while(line != null){
				line = line.replace('$', 'a');
				line = line.replace('*', 'z');
				line = line.replace('&', 'c');
				line = line.replace('^', 'b');
				line = line.replace('%', 'r');
				line = line.replace('~', 't');
				line = line.replace(']', 'm');
				System.out.println(line);
				StringBuilder m = new StringBuilder(line);
				m.reverse();
				String deencrypted = new String(m);
				JOptionPane.showMessageDialog(null, "De-encryped message is: " + deencrypted);
				line = br.readLine();
			}
			
			br.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

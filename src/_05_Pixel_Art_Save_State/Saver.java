package _05_Pixel_Art_Save_State;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Saver implements Serializable{
	Saver(Pixel[][] pixels, int windowWidth, int windowHeight){
		try (FileOutputStream fos = new FileOutputStream(new File("src/art.dat"));
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(new Saver(pixels, windowWidth, windowHeight));
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class leerArchivo {
	private File archivo;
	private guardarArchivoTxt2 j;
	
	public leerArchivo(File archivo) throws FileNotFoundException {
		
		try {
			FileInputStream fis =new FileInputStream(archivo);
			Scanner scanner = new Scanner(fis);
			

			scanner.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

package game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerArchivo {
	private File archivo;
	private GuardarArchivoTxt j;
	
	public LeerArchivo(File archivo) throws FileNotFoundException {
		
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

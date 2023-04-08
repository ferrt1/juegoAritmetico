package game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GuardarArchivoTxt {

	public GuardarArchivoTxt(String s)throws IOException {
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			OutputStreamWriter out = new OutputStreamWriter(fos);
			out.write(s);
			out.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	}


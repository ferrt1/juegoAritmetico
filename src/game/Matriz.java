package game;

import java.util.LinkedList;

import javax.swing.JTextField;

public class Matriz {
	

	public int[] crearArreglo(int n) {
		int[] arreglo = new int[n];
		for(int i = 0; i < arreglo.length; i++) {
			int aleatorio = (int) (Math.floor(Math.random()*(20-50+1)+50));
			arreglo[i] = aleatorio;
		}
		return arreglo;
	}

	public int[][] crearArreglosSumaFilaYColumna() {
		int[][] arregloRandom = new int[4][2];
		int[][] matrizAleatoria = new int[4][4];
		for(int i = 0; i < matrizAleatoria.length; i ++) {
			for(int j = 0; j < matrizAleatoria.length; j++) {
				int aleatorio =  (int) (Math.random()*10 + 1);
				matrizAleatoria[i][j] = aleatorio;
			}
		}
		for(int i = 0; i < 4; i++) {
			arregloRandom[i][0] = sumarCol(matrizAleatoria, i);
		}
		for(int i = 0; i < 4; i++) {
			arregloRandom[i][1] = sumarFilas(matrizAleatoria, i);
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j<4;j++) {
				System.out.print(matrizAleatoria[i][j] + " ");		
			}	
			System.out.println();
		}
		System.out.println();

		
		return arregloRandom;
	}
	
	public int[] obtenerResultadoColumnasDeNivel(int[][] matriz) {
		int[] filaNivel = new int[4];
		for(int i = 0; i < 4; i++) {
			filaNivel[i] = matriz[i][1];
			
		}
		for(int i = 0; i < 4; i++) {
			System.out.println("fila:" + filaNivel[i]);
		}
		return filaNivel;
	}
	
	public int[] obtenerResultadoFilasDeNivel(int[][] matriz) {
		int[] columnaNivel = new int[4];
		for(int i = 0; i < 4; i++) {
			columnaNivel[i] = matriz[i][0];
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.println("columna:" + columnaNivel[i]);
		}
		
		return columnaNivel;
	}
	


	public int[][] agregarNumerosDeListaAMatriz(int[][] matriz, LinkedList<JTextField> textFieldLista){
		int listaPosicion = 0;
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length;j++) {
				if(listaPosicion < textFieldLista.size())
					matriz[i][j] = Integer.parseInt(textFieldLista.get(listaPosicion++).getText());
			}
		}
		return matriz;
	}

	private static int sumarFilas(int[][] mat, int fila) {
		int suma = 0;
		for (int col = 0; col < mat[0].length; col++) {
			suma += mat[fila][col];
		}
		return suma;
	}

	private static int sumarCol(int[][] mat, int nColum) {
		int suma = 0;
		for(int fila = 0; fila < mat.length; fila++) {
			suma += mat[fila][nColum];
		}
		return suma;
	}

	public boolean verificarSumaFila(int[][] mat, int fila, int valorArray) {
		return valorArray == sumarFilas(mat, fila);
	}

	public boolean verificarSumaColumna(int[][] mat, int col, int valorArray) {
		return valorArray == sumarCol(mat, col);
	}

	public String esGanador(boolean variable) {
		if(variable!=true) {
			return "Hay valores que no corresponden";
		}
		else {
			return "Ganaste!";
		}
	}

}

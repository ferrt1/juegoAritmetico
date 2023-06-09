package game;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextField;

public class JuegoMatriz {
	
	
	private int[][] matrizRecibida = new int [4][4];
	private int[][] matrizAleatoria = crearArreglosSumaFilaYColumna();

	private int[] arregloDerecha = obtenerResultadoFilasDeNivel(matrizAleatoria);
	private int[] arregloAbajo = obtenerResultadoColumnasDeNivel(matrizAleatoria);

	
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
	


	public int[][] agregarNumerosDeListaAMatriz(List<Integer> numeros){
        int listaPosicion = 0;
        for(int i = 0; i < matrizRecibida.length; i++) {
            for(int j = 0; j < matrizRecibida[i].length;j++) {
                if(listaPosicion < numeros.size())
                	matrizRecibida[i][j] = numeros.get(listaPosicion++);
            }
        }
        return matrizRecibida;
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
	
	public boolean comprobarSumaFilas() {
		boolean comprobar = true;
		for(int i = 0; i < 4; i++) {
			if(!verificarSumaFila(0,  arregloAbajo[0])) 
				comprobar = false;
			System.out.println("la primera fila es: " + comprobar);
		}
		for(int i = 4; i < 8; i++) {
			if(!verificarSumaFila(1,  arregloAbajo[1]))
				comprobar = false;
			System.out.println("la segunda fila es: " + comprobar);

		}
		for(int i = 8; i < 12; i++) {
			if(!verificarSumaFila(2,  arregloAbajo[2])) 
				comprobar = false;
			System.out.println("la 3era fila es: " + comprobar);

		}
		for(int i = 12; i < 16; i++) {
			if(!verificarSumaFila(3,  arregloAbajo[3]))
				comprobar = false;
			System.out.println("la 4ta fila es: " + comprobar);

		}
		return comprobar;
	}
	
	public boolean comprobarSumaColumnas() {
		boolean comprobar = true;
		for(int i = 0; i < 16; i+=4) {
			if(!verificarSumaColumna(0, arregloDerecha[0])) {
				comprobar = false;
			}
		}
		for(int i = 1; i < 16; i+=4) {
			if(!verificarSumaColumna(1, arregloDerecha[1])){
				comprobar = false;
		}
		}
		for(int i = 2; i < 16; i+=4) {
			if(!verificarSumaColumna(2, arregloDerecha[2])) {
				comprobar = false;
			}
		}
		for(int i = 3; i < 16; i+=4) {
			if(!verificarSumaColumna(3, arregloDerecha[3])) {
				comprobar = false;
			}
		}
		return comprobar;
	}

	public boolean comprobarTodoJuego() {
		return comprobarSumaColumnas() && comprobarSumaFilas();
	}

	public boolean verificarSumaFila(int fila, int valorArray) {
		return valorArray == sumarFilas(matrizRecibida, fila);
	}

	public boolean verificarSumaColumna(int col, int valorArray) {
		return valorArray == sumarCol(matrizRecibida, col);
	}
	

	public int[][] getMatrizRecibida() {
		return matrizRecibida;
	}

	public void setMatrizRecibida(int[][] matrizRecibida) {
		this.matrizRecibida = matrizRecibida;
	}

	public int[][] getMatrizAleatoria() {
		return matrizAleatoria;
	}

	public int[] getArregloDerecha() {
		return arregloDerecha;
	}

	public int[] getArregloAbajo() {
		return arregloAbajo;
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

package game;

import java.util.LinkedList;

import javax.swing.JTextField;

public class Matriz {

	//debo pasar como n el largo de la matriz
	//en el main debo crear dos arreglos el primero para la matriz que sera siempre cuadrada se supone
	//el primer arreglo es para filas y el segundo para columnas
	
	int[] arregloArmadoFilas = {10,7,10,8};
	
	int[] arregloArmadoColumnas = {9,9,8,9};
	
	public int[] crearArreglo(int n) {
		int[] arreglo = new int[n];
		for(int i = 0; i < arreglo.length; i++) {
			int aleatorio = (int) (Math.floor(Math.random()*(20-50+1)+50));
			arreglo[i] = aleatorio;
		}
		return arreglo;
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
	
	public int sumarFilas(int[][] mat, int fila) {
		int suma = 0;
	        for (int col = 0; col < mat[0].length; col++) {
	            suma += mat[fila][col];
	        }
		    return suma;
	    }
	
	public int sumarCol(int[][] mat, int nColum) {
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

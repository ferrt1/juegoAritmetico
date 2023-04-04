package game;

public class Niveles {
	
//	El primer arreglo son la suma de las filas y el segundo la suma de las columnas
	
	private int[][] nivel_1 = {{5, 7, 8, 8},
								{8,8,6,6}};
	
	private int[][] nivel_2 = {{10,7,10,8},
								{9,9,8,9}};
	
	private int[][] nivel_3 = {{15, 18, 13, 17},
								{18, 17, 14, 14}}; 
	
	private int[][] nivel_4  = 	{{21, 20, 19, 23},
								{18, 14, 23, 28}};
	
	private int[][] nivel_5 = 	{{31, 47, 35, 28},
								{41, 38, 29, 33}};
	
	
	private int[] obtenerResultadoFilasDeNivel(int[][] nivel) {
		int[] filaNivel = new int[4];
		for(int i = 0; i < 4; i++) {
			filaNivel[i] = nivel[0][i];
		}
		return filaNivel;
	}
	
	private int[] obtenerResultadoColumnasDeNivel(int[][] nivel) {
		int[] columnaNivel = new int[4];
		for(int i = 0; i < 4; i++) {
			columnaNivel[i] = nivel[1][i];
		}
		return columnaNivel;
	}
	
	public int[] cambiarNivelFila(int nivel) {
		if(nivel == 1) {
			return obtenerResultadoFilasDeNivel(nivel_1);
		} 
		if(nivel == 2){
			return obtenerResultadoFilasDeNivel(nivel_2);
		} 
		if(nivel == 3) {
			return obtenerResultadoFilasDeNivel(nivel_3);
		} 
		if(nivel == 4) {
			return obtenerResultadoFilasDeNivel(nivel_4);
		}
		else {
			return obtenerResultadoFilasDeNivel(nivel_5);
		}
	}
	
	
	public int[] cambiarNivelColumna(int nivel) {
		if(nivel == 1) {
			return obtenerResultadoColumnasDeNivel(nivel_1);
		}
		if(nivel == 2){
			return obtenerResultadoColumnasDeNivel(nivel_2);
		}
		if(nivel == 3) {
			return obtenerResultadoColumnasDeNivel(nivel_3);
		}	
		if(nivel == 4) {
			return obtenerResultadoColumnasDeNivel(nivel_4);
		}
		else {
			return obtenerResultadoColumnasDeNivel(nivel_5);
		}
	}
	
	public int[][] getNivel_1() {
		return nivel_1;
	}
	
	public int[][] getNivel_2() {
		return nivel_2;
	}
	
	public int[][] getNivel_3() {
		return nivel_3;
	}
	public int[][] getNivel_4() {
		return nivel_4;
	}
	public int[][] getNivel_5() {
		return nivel_5;
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < 4; i++) {
			s = nivel_1[i].toString();
		}
		return s;
	}
	
}

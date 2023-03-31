package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatrizTest {
	
	Matriz sistema;
	int[][] matrizTestIncompleta = new int [1][4];

	@Before
	public void setUp() {
		sistema = new Matriz();
		matrizTestIncompleta[0][0] = 1; matrizTestIncompleta[0][2] = 4; matrizTestIncompleta[0][3] = 2;
	}
	
	@Test
	public void SumaFilaTest() {
		matrizTestIncompleta[0][1] = 5;
		
		assertTrue(sistema.verificarSumaFila(matrizTestIncompleta, 0, 12));
	}
	
	@Test
	public void SumaColumnaTest() {
		int[][] matrizTest = new int [4][1];
		matrizTest[0][0] = 1; matrizTest[1][0] = 5;matrizTest[2][0] = 4;matrizTest[3][0] = 3;
		
		assertTrue(sistema.verificarSumaColumna(matrizTest, 0, 13));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noSePermitenLetras() {
		matrizTestIncompleta[0][1] = 'e';
		
		sistema.verificarSumaFila(matrizTestIncompleta, 0, 7);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noSePermitenNegativos() {
		matrizTestIncompleta[0][1] = -1;
		
		sistema.verificarSumaFila(matrizTestIncompleta, 0, 6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void noSePermitenCeros() {
		matrizTestIncompleta[0][1] = 0;
		
		sistema.verificarSumaFila(matrizTestIncompleta, 0, 7);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hayEspaciosVacios() {
		matrizTestIncompleta[0][1] = ' ';
		
		sistema.verificarSumaFila(matrizTestIncompleta, 0, 7);
	}
}

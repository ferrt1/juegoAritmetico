package game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MatrizTest {
	
	Matriz sistema;

	@Before
	public void setUp() {
		sistema = new Matriz();
		
	}
	
	@Test
	public void SumaFilaTest() {
		int[][] matrizTest = new int [1][4];
		matrizTest[0][0] = 1; matrizTest[0][1] = 5; matrizTest[0][2] = 4; matrizTest[0][3] = 2;
		
		assertTrue(sistema.verificarSumaFila(matrizTest, 0, 12));
	}
	
	@Test
	public void SumaColumnaTest() {
		int[][] matrizTest = new int [4][1];
		matrizTest[0][0] = 1; matrizTest[1][0] = 5;matrizTest[2][0] = 4;matrizTest[3][0] = 3;
		
		assertTrue(sistema.verificarSumaColumna(matrizTest, 0, 13));
	}
	
}

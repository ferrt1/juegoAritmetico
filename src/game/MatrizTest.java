package game;

import static org.junit.Assert.*;

import java.util.LinkedList;

import javax.swing.JTextField;

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
    @Test
    public void testAgregarNumerosDeListaAMatriz() {
        int[][] matriz = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        LinkedList<JTextField> textFieldLista = new LinkedList<JTextField>();
        textFieldLista.add(new JTextField("9"));
        textFieldLista.add(new JTextField("10"));
        textFieldLista.add(new JTextField("11"));
        textFieldLista.add(new JTextField("12"));
        int[][] resultado = sistema.agregarNumerosDeListaAMatriz(matriz, textFieldLista);
        assertEquals(1, resultado[0][0]);
        assertEquals(2, resultado[0][1]);
        assertEquals(3, resultado[1][0]);
        assertEquals(4, resultado[1][1]);
        assertEquals(5, resultado[2][0]);
        assertEquals(6, resultado[2][1]);
        assertEquals(7, resultado[3][0]);
        assertEquals(8, resultado[3][1]);
        assertEquals(9, resultado[0][2]);
        assertEquals(10, resultado[1][2]);
        assertEquals(11, resultado[2][2]);
        assertEquals(12, resultado[3][2]);
    }
    
    @Test
    public void testCrearArreglosSumaFilaYColumna() {
        int[][] arregloRandom = sistema.crearArreglosSumaFilaYColumna();
        assertEquals(4, arregloRandom.length);
        assertEquals(2, arregloRandom[0].length);
        for (int i = 0; i < 4; i++) {
            assertTrue(arregloRandom[i][0] >= 10 && arregloRandom[i][0] <= 40);
            assertTrue(arregloRandom[i][1] >= 4 && arregloRandom[i][1] <= 40);
        }
    }
    
    @Test
    public void testObtenerResultadoColumnasDeNivel() {
        int[][] matriz = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[] resultado = sistema.obtenerResultadoColumnasDeNivel(matriz);
        assertEquals(4, resultado.length);
        assertEquals(2, resultado[0]);
        assertEquals(4, resultado[1]);
        assertEquals(6, resultado[2]);
        assertEquals(8, resultado[3]);
    }
    
    @Test
    public void testObtenerResultadoFilasDeNivel() {
        int[][] matriz = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[] resultado = sistema.obtenerResultadoFilasDeNivel(matriz);
        assertEquals(4, resultado.length);
        assertEquals(1, resultado[0]);
        assertEquals(3, resultado[1]);
        assertEquals(5, resultado[2]);
        assertEquals(7, resultado[3]);
    }
    
    @Test
    public void testVerificarSumaFila() {
        Matriz m = new Matriz();
        int[][] matriz = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertTrue(m.verificarSumaFila(matriz, 0, 10));
        assertFalse(m.verificarSumaFila(matriz, 0, 11));
        assertTrue(m.verificarSumaFila(matriz, 1, 26));
        assertFalse(m.verificarSumaFila(matriz, 1, 27));
        assertTrue(m.verificarSumaFila(matriz, 2, 42));
        assertFalse(m.verificarSumaFila(matriz, 2, 43));
        assertTrue(m.verificarSumaFila(matriz, 3, 58));
        assertFalse(m.verificarSumaFila(matriz, 3, 59));
    }

    
}

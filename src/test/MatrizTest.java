package test;

import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import game.*;

import static org.junit.Assert.*;

public class MatrizTest {

    @Test
    public void testCrearArreglo() {
        JuegoMatriz juegoMatriz = new JuegoMatriz();
        int[] arreglo = juegoMatriz.crearArreglo(5);
        assertEquals(5, arreglo.length);
    }

    @Test
    public void testCrearArreglosSumaFilaYColumna() {
        JuegoMatriz juegoMatriz = new JuegoMatriz();
        int[][] arregloRandom = juegoMatriz.crearArreglosSumaFilaYColumna();
        assertEquals(4, arregloRandom.length);
        assertEquals(2, arregloRandom[0].length);
    }


    @Test
    public void testAgregarNumerosDeListaAMatriz() {
        JuegoMatriz juegoMatriz = new JuegoMatriz();
        List<Integer> numeros = new LinkedList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        int[][] matrizRecibida = juegoMatriz.agregarNumerosDeListaAMatriz(numeros);
        int[][] expected = {{1, 2, 3, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        assertArrayEquals(expected, matrizRecibida);
    }

    @Test
    public void testVerificarSumaFila() {
        JuegoMatriz juegoMatriz = new JuegoMatriz();
        int[][] matrizRecibida = {{1, 2, 3, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        juegoMatriz.setMatrizRecibida(matrizRecibida);
        assertTrue(juegoMatriz.verificarSumaFila(0, 10));
        assertFalse(juegoMatriz.verificarSumaFila(0, 9));
    }

    @Test
    public void testVerificarSumaColumna() {
        JuegoMatriz juegoMatriz = new JuegoMatriz();
        int[][] matrizRecibida = {{1, 2, 3, 4}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        juegoMatriz.setMatrizRecibida(matrizRecibida);
        assertTrue(juegoMatriz.verificarSumaColumna(0, 1));
        assertFalse(juegoMatriz.verificarSumaColumna(0, 2));
    }
    
}

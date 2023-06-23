package cl.camila;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalcuTest {

    private static Calculadora calculadora = mock(Calculadora.class);
    private static Logger logger = Logger.getLogger("cl.camila");

    private static final float x = 10.0f;
    private static final float y = 5.0f;

    @BeforeAll
    static void setUp() {
        logger.info("Iniciando");
    }

    @Test
    @DisplayName("Test sumar")
    public void testSumar() {
        logger.info("Ejecutando test sumar");
        when(calculadora.sumar(x, y)).thenReturn((float) 15);
        float respuesta = calculadora.sumar(x, y);

        assertEquals(15.0f, respuesta);
        verify(calculadora).sumar(x, y);
    }

    @Test
    @DisplayName("Test restar")
    public void testRestar() {
        logger.info("Ejecutando test restar");
        when(calculadora.restar(x, y)).thenReturn((float) 5);
        float respuesta = calculadora.restar(x, y);
        assertEquals(5.0f, respuesta);
        verify(calculadora).restar(x, y);
    }

    @Test
    @DisplayName("Test multiplicar")
    public void testMultiplicar() {
        logger.info("Ejecutando test multiplicar");
        when(calculadora.multiplicar(x, y)).thenReturn(50.0f);
        float respuesta = calculadora.multiplicar(x, y);
        assertEquals(50.0f, respuesta);
        verify(calculadora).multiplicar(x, y);
    }

    @Test
    @DisplayName("Test dividir")
    public void testDividir() {
        logger.info("Ejecutando test multiplicar");
        when(calculadora.dividir(x, y)).thenReturn(2.0f);
        float respuesta = calculadora.dividir(x, y);
        assertEquals(2.0f, respuesta);
        verify(calculadora).dividir(x, y);
    }

}

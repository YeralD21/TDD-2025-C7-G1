package service;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceDTest {
    private final ServiceD morseService = new ServicioDImpl();

    @Test
    public void testTextoAMorse() {
        assertEquals(".- .-.. .-   -- .- -- .-", morseService.convert("ALA MAMA"));
    }

    @Test
    public void testMorseATexto() {
        assertEquals("SOS", morseService.convert("... --- ..."));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEntradaInvalida() {
        morseService.convert("Hola@Mundo"); // Carácter no soportado
    }

    @Test
    public void testEspaciosEntrePalabras() {
        assertEquals(".- .-.. .-   -- .- -- .-", morseService.convert("ALA MAMA"));
    }

    @Test
    public void testNumerosAMorse() {
        assertEquals("-----", morseService.convert("0"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMorseInvalido() {
        morseService.convert(".-.-.-.-"); // Morse no existente
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMorseInvalidoConEspacios() {
        morseService.convert(".- .-.-.- .-"); // Morse válido e inválido mezclado
    }
}
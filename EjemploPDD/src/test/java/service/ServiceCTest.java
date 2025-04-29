package service;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceCTest {
    private final ServiceC temperatureService = new ServicioCImpl();

    // 1. Tests de conversión válida
    @Test
    public void testConversionValida_CelsiusAFahrenheit() {
        assertEquals("77.0°F", temperatureService.convertTemperature("25°C"));
        assertEquals("32.0°F", temperatureService.convertTemperature("0°C"));  // Punto de congelación
        assertEquals("-40.0°F", temperatureService.convertTemperature("-40°C")); // Mismo en ambas escalas
    }

    @Test
    public void testConversionValida_FahrenheitACelsius() {
        assertEquals("25.0°C", temperatureService.convertTemperature("77°F"));
        assertEquals("0.0°C", temperatureService.convertTemperature("32°F"));  // Punto de congelación
        assertEquals("-40.0°C", temperatureService.convertTemperature("-40°F")); // Mismo en ambas escalas
    }

    @Test
    public void testValoresDecimales() {
        assertEquals("98.6°F", temperatureService.convertTemperature("37°C")); // Temperatura corporal
        assertEquals("37.0°C", temperatureService.convertTemperature("98.6°F"));
    }

    // 2. Tests de formato inválido
    @Test
    public void testEntradaNull() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature(null));
    }

    @Test
    public void testSimboloFaltante() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("30F"));
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("30"));
    }

    @Test
    public void testEntradaMuyCorta() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("°"));
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("C"));
    }

    @Test
    public void testFormatoIncompleto() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("°C"));
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("°F"));
    }

    @Test
    public void testFormatoConMultiplesSimbolosGrado() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("25°C°extra"));
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("25°°C"));
    }

    @Test
    public void testEspaciosEnBlanco() {
        assertEquals("77.0°F", temperatureService.convertTemperature("  25  °  C  ")); // Válido con espacios
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("  °  C  ")); // Inválido
    }

    // 3. Tests de unidad inválida
    @Test
    public void testUnidadInvalida() {
        assertEquals("Error: Unidad no válida (use C o F)", temperatureService.convertTemperature("25°X"));
        assertEquals("Error: Unidad no válida (use C o F)", temperatureService.convertTemperature("25°celsius"));
    }

    // 4. Tests de valor numérico inválido
    @Test
    public void testValorNoNumerico() {
        assertEquals("Error: Valor numérico inválido", temperatureService.convertTemperature("ABC°C"));
        assertEquals("Error: Valor numérico inválido", temperatureService.convertTemperature("25,5°C")); // Coma inválida
        assertEquals("Error: Valor numérico inválido", temperatureService.convertTemperature("25.5.5°C")); // Puntos múltiples
    }

    @Test
    public void testValorVacio() {
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature("°C"));
        assertEquals("Error: Formato incorrecto", temperatureService.convertTemperature(" ° F"));
    }
}
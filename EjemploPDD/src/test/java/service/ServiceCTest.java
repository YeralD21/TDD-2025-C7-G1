package service;

import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceCTest {
    private final ServiceC temperatureService = new ServicioCImpl();

    @Test
    public void testEntradaInvalida_SimboloFaltante() {
        String resultado = temperatureService.convertTemperature("30F");
        assertEquals("Error: Formato incorrecto", resultado);
    }

    @Test
    public void testConversionValida_CelsiusAFahrenheit() {
        String resultado = temperatureService.convertTemperature("25°C");
        assertEquals("77.0°F", resultado);
    }

    @Test
    public void testConversionValida_FahrenheitACelsius() {
        String resultado = temperatureService.convertTemperature("77°F");
        assertEquals("25.0°C", resultado);
    }

    @Test
    public void testUnidadInvalida() {
        String resultado = temperatureService.convertTemperature("25°X");
        assertEquals("Error: Unidad no válida (use C o F)", resultado);
    }
}
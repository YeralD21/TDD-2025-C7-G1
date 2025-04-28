package service;

public interface ServiceC {
    /**
     * Convierte entre grados Celsius y Fahrenheit
     * @param temperature Cadena con formato "XX°C" o "XX°F"
     * @return Resultado convertido o mensaje de error
     */
    String convertTemperature(String temperature);
}
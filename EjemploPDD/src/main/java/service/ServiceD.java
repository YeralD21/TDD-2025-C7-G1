package service;

public interface ServiceD {
    /**
     * Convierte entre texto natural y código morse automáticamente
     * @param input Texto o morse a convertir
     * @return Resultado convertido
     * @throws IllegalArgumentException Si el formato no es válido
     */
    String convert(String input) throws IllegalArgumentException;
}
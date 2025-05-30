package service;

public class ServicioCImpl implements ServiceC {

    @Override
    public String convertTemperature(String temperature) {
        // Validar formato básico
        if (temperature == null || !temperature.contains("°") || temperature.length() < 2) {
            return "Error: Formato incorrecto";
        }

        // Separar componentes
        String[] parts = temperature.split("°");

        // Validar que haya exactamente 2 partes y que la primera no esté vacía
        if (parts.length != 2 || parts[0].trim().isEmpty()) {
            return "Error: Formato incorrecto";
        }

        try {
            double value = Double.parseDouble(parts[0].trim());
            String unit = parts[1].trim().toUpperCase();

            // Validar unidad y convertir
            if (unit.equals("C")) {
                double fahrenheit = (value * 9/5) + 32;
                return String.format("%.1f°F", fahrenheit);
            } else if (unit.equals("F")) {
                double celsius = (value - 32) * 5/9;
                return String.format("%.1f°C", celsius);
            } else {
                return "Error: Unidad no válida (use C o F)";
            }
        } catch (NumberFormatException e) {
            return "Error: Valor numérico inválido";
        }
    }
}
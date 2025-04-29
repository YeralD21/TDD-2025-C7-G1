package service;

import java.util.HashMap;
import java.util.Map;

public class ServicioDImpl implements ServiceD {
    private static final Map<Character, String> TEXT_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_TEXT = new HashMap<>();

    static {
        // Mapeo completo de texto a Morse (alfabeto internacional)
        TEXT_TO_MORSE.put('A', ".-");
        TEXT_TO_MORSE.put('B', "-...");
        TEXT_TO_MORSE.put('C', "-.-.");
        TEXT_TO_MORSE.put('D', "-..");
        TEXT_TO_MORSE.put('E', ".");
        TEXT_TO_MORSE.put('F', "..-.");
        TEXT_TO_MORSE.put('G', "--.");
        TEXT_TO_MORSE.put('H', "....");
        TEXT_TO_MORSE.put('I', "..");
        TEXT_TO_MORSE.put('J', ".---");
        TEXT_TO_MORSE.put('K', "-.-");
        TEXT_TO_MORSE.put('L', ".-..");
        TEXT_TO_MORSE.put('M', "--");
        TEXT_TO_MORSE.put('N', "-.");
        TEXT_TO_MORSE.put('O', "---");
        TEXT_TO_MORSE.put('P', ".--.");
        TEXT_TO_MORSE.put('Q', "--.-");
        TEXT_TO_MORSE.put('R', ".-.");
        TEXT_TO_MORSE.put('S', "...");
        TEXT_TO_MORSE.put('T', "-");
        TEXT_TO_MORSE.put('U', "..-");
        TEXT_TO_MORSE.put('V', "...-");
        TEXT_TO_MORSE.put('W', ".--");
        TEXT_TO_MORSE.put('X', "-..-");
        TEXT_TO_MORSE.put('Y', "-.--");
        TEXT_TO_MORSE.put('Z', "--..");
        TEXT_TO_MORSE.put('0', "-----");
        TEXT_TO_MORSE.put('1', ".----");
        TEXT_TO_MORSE.put('2', "..---");
        TEXT_TO_MORSE.put('3', "...--");
        TEXT_TO_MORSE.put('4', "....-");
        TEXT_TO_MORSE.put('5', ".....");
        TEXT_TO_MORSE.put('6', "-....");
        TEXT_TO_MORSE.put('7', "--...");
        TEXT_TO_MORSE.put('8', "---..");
        TEXT_TO_MORSE.put('9', "----.");
        TEXT_TO_MORSE.put(' ', " ");

        // Mapeo inverso (Morse a texto)
        for (Map.Entry<Character, String> entry : TEXT_TO_MORSE.entrySet()) {
            MORSE_TO_TEXT.put(entry.getValue(), entry.getKey());
        }
    }

    @Override
    public String convert(String input) throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Entrada vacía");
        }

        // Detectar automáticamente si es texto o Morse
        if (input.matches("^[a-zA-Z0-9\\s]+$")) {
            return convertTextToMorse(input.toUpperCase());
        } else if (input.matches("^[.\\-\\s]+$")) {
            return convertMorseToText(input);
        } else {
            throw new IllegalArgumentException("Formato no reconocido");
        }
    }

    private String convertTextToMorse(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                String morseChar = TEXT_TO_MORSE.get(c);
                if (morseChar != null) {
                    result.append(morseChar).append(" ");
                }
            }
            if (i < words.length - 1) {
                result.append("  "); // Doble espacio entre palabras
            }
        }

        return result.toString().trim();
    }
    //AQUI CAMBIE
    private String convertMorseToText(String morse) {
        StringBuilder result = new StringBuilder();
        String[] words = morse.split("\\s{2,}"); // Separar palabras

        for (String word : words) {
            String[] letters = word.split("\\s");
            for (String letter : letters) {
                Character textChar = MORSE_TO_TEXT.get(letter);
                if (textChar == null) {
                    throw new IllegalArgumentException("Código Morse inválido: " + letter);
                }
                result.append(textChar);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
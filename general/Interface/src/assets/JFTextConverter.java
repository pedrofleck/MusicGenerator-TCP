//package general.Interface.src.assets;
//
//import org.jfugue.pattern.Pattern;
//import java.util.Random;
//
//public class JFTextConverter {
//    private static final int DEFAULT_VOLUME = 50;
//    private static final int DEFAULT_OCTAVE = 4;
//    private static final int DEFAULT_BPM = 120;
//    private int volume = DEFAULT_VOLUME;
//    private int octave = DEFAULT_OCTAVE; // oitava padrão
//    private int bpm = DEFAULT_BPM; // BPM padrão
//    private String instrument;
//
//
//    public Pattern convertTextToMusic(String text) {
//        StringBuilder patternBuilder = new StringBuilder();
//        Random randomNumber = new Random();
//        boolean inInstrumentBlock = false;
//        StringBuilder instrumentBuilder = new StringBuilder();
//
//        octave = DEFAULT_OCTAVE;
//        patternBuilder.append("T").append(DEFAULT_BPM).append(" "); // Inicia com BPM padrão
//        patternBuilder.append("I[Piano] ");
//
//        for (int currentChar = 0; currentChar < text.length(); currentChar++) {
//            char c = text.charAt(currentChar);
//            if (inInstrumentBlock) {
//                if (c == '*') {
//                    // Conclui o bloco de instrumento
//                    inInstrumentBlock = false;
//                    instrument = instrumentBuilder.toString();
//                    patternBuilder.append("I[").append(instrument).append("] ");
//                    instrumentBuilder.setLength(0); // Limpa o buffer do instrumento
//                } else {
//                    // Adiciona ao buffer do instrumento
//                    instrumentBuilder.append(c);
//                }
//            }
//            else {
//                switch (c) { // Itera sobre todos os caracteres e converte-os para o padrão equivalente
//                    case 'A': case 'a':
//                        patternBuilder.append("A").append(octave).append(" ");
//                        break;
//                    case 'B': case 'b':
//                        patternBuilder.append("B").append(octave).append(" ");
//                        break;
//                    case 'C': case 'c':
//                        patternBuilder.append("C").append(octave).append(" ");
//                        break;
//                    case 'D': case 'd':
//                        patternBuilder.append("D").append(octave).append(" ");
//                        break;
//                    case 'E': case 'e':
//                        patternBuilder.append("E").append(octave).append(" ");
//                        break;
//                    case 'F': case 'f':
//                        patternBuilder.append("F").append(octave).append(" ");
//                        break;
//                    case 'G': case 'g':
//                        patternBuilder.append("G").append(octave).append(" ");
//                        break;
//                    case ' ':
//                        patternBuilder.append("R "); // R para pausa
//                        break;
//                    case '+':
//                        volume *= 2;
//                        // Não sei o porquê do 7 mas o segundo item muda o volume
//                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
//                        break;
//                    case '-':
//                        volume = DEFAULT_VOLUME;
//                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
//                        break;
//                    case 'R':
//                        if (currentChar + 1 < text.length()) {
//                            char nextChar = text.charAt(currentChar + 1);
//                            if (nextChar == '+') {
//                                octave++;
//                            } else if (nextChar == '-') {
//                                octave--;
//                            }
//                            currentChar++;
//                        }
//                        break;
//                    case '?':
//                        char randomNote = (char) ('A' + randomNumber.nextInt(7));
//                        patternBuilder.append(randomNote).append(octave).append(" ");
//                        break;
//                    case '\n':
//                        // Garante que estamos fora de um bloco de instrumento
//                        if (inInstrumentBlock) {
//                            inInstrumentBlock = false;
//                            if (instrumentBuilder.length() > 0) {
//                                instrument = instrumentBuilder.toString();
//                                patternBuilder.append("I[").append(instrument).append("] ");
//                                instrumentBuilder.setLength(0); // Limpa o buffer do instrumento
//                            }
//                        }
//                        break;
//                    case '*':
//                        // Marca que estamos começando um bloco de instrumento
//                        if (!inInstrumentBlock) {
//                            inInstrumentBlock = true;
//                        }
//                        break;
//                    case ';':
//                        bpm = randomNumber.nextInt(300) + 60; // Valor aleatório entre 40 e 360
//                        patternBuilder.append("T").append(bpm).append(" ");
//                        break;
//                    default:
//                        patternBuilder.append("NOP ");
//                }
//            }
//        }
//
//        // Adiciona o final do padrão
//        patternBuilder.append(" | ");
//
//        // Converte o padrão para o formato JFugue
//        System.out.println(patternBuilder.toString()); // coloquei essa saída como teste, TODO: tirar no fim
//        return new Pattern(patternBuilder.toString());
//    }
//}


package general.Interface.src.assets;

import org.jfugue.pattern.Pattern;
import java.util.Random;

public class JFTextConverter {
    private static final int DEFAULT_VOLUME = 50;
    private static final int DEFAULT_OCTAVE = 4;
    private static final int DEFAULT_BPM = 120;
    private int volume = DEFAULT_VOLUME;
    private int octave = DEFAULT_OCTAVE; // oitava padrão
    private int bpm = DEFAULT_BPM; // BPM padrão
    private String instrument;


    public Pattern convertTextToMusic(String text) {
        StringBuilder patternBuilder = new StringBuilder();
        Random randomNumber = new Random();
        boolean inInstrumentBlock = false;
        StringBuilder instrumentBuilder = new StringBuilder();

        octave = DEFAULT_OCTAVE;
        patternBuilder.append("T").append(DEFAULT_BPM).append(" "); // Inicia com BPM padrão
        patternBuilder.append("I[Piano] ");

        for (int currentChar = 0; currentChar < text.length(); currentChar++) {
            char c = text.charAt(currentChar);
            if (inInstrumentBlock) {
                if (c == '*') {
                    // Conclui o bloco de instrumento
                    inInstrumentBlock = false;
                    instrument = instrumentBuilder.toString();
                    patternBuilder.append("I[").append(instrument).append("] ");
                    instrumentBuilder.setLength(0); // Limpa o buffer do instrumento
                } else {
                    // Adiciona ao buffer do instrumento
                    instrumentBuilder.append(c);
                }
            }
            else {
                switch (c) { // Itera sobre todos os caracteres e converte-os para o padrão equivalente
                    case 'A': case 'a':
                        patternBuilder.append("A").append(octave).append(" ");
                        break;
                    case 'B': case 'b':
                        patternBuilder.append("B").append(octave).append(" ");
                        break;
                    case 'C': case 'c':
                        patternBuilder.append("C").append(octave).append(" ");
                        break;
                    case 'D': case 'd':
                        patternBuilder.append("D").append(octave).append(" ");
                        break;
                    case 'E': case 'e':
                        patternBuilder.append("E").append(octave).append(" ");
                        break;
                    case 'F': case 'f':
                        patternBuilder.append("F").append(octave).append(" ");
                        break;
                    case 'G': case 'g':
                        patternBuilder.append("G").append(octave).append(" ");
                        break;
                    case ' ':
                        patternBuilder.append("R "); // R para pausa
                        break;
                    case '+':
                        volume *= 2;
                        // Não sei o porquê do 7 mas o segundo item muda o volume
                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
                        break;
                    case '-':
                        volume = DEFAULT_VOLUME;
                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
                        break;
                    case 'R':
                        if (currentChar + 1 < text.length()) {
                            char nextChar = text.charAt(currentChar + 1);
                            if (nextChar == '+') {
                                octave++;
                            } else if (nextChar == '-') {
                                octave--;
                            }
                            currentChar++;
                        }
                        break;
                    case '?':
                        char randomNote = (char) ('A' + randomNumber.nextInt(7));
                        patternBuilder.append(randomNote).append(octave).append(" ");
                        break;
                    case '\n':
                        // Garante que estamos fora de um bloco de instrumento
                        if (inInstrumentBlock) {
                            inInstrumentBlock = false;
                            if (instrumentBuilder.length() > 0) {
                                instrument = instrumentBuilder.toString();
                                patternBuilder.append("I[").append(instrument).append("] ");
                                instrumentBuilder.setLength(0); // Limpa o buffer do instrumento
                            }
                        }
                        break;
                    case '*':
                        // Marca que estamos começando um bloco de instrumento
                        if (!inInstrumentBlock) {
                            inInstrumentBlock = true;
                        }
                        break;
                    case ';':
                        bpm = randomNumber.nextInt(300) + 60; // Valor aleatório entre 40 e 360
                        patternBuilder.append("T").append(bpm).append(" ");
                        break;
                    default:
                        patternBuilder.append("NOP ");
                }
            }
        }

        // Adiciona o final do padrão
        patternBuilder.append(" | ");

        // Converte o padrão para o formato JFugue
        System.out.println(patternBuilder.toString()); // coloquei essa saída como teste, TODO: tirar no fim
        return new Pattern(patternBuilder.toString());
    }
}

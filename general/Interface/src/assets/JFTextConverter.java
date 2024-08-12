package general.Interface.src.assets;

import org.jfugue.pattern.Pattern;
import java.util.Random;

public class JFTextConverter {
    private int volume = 100;
    private int octave = 4; // oitava padrão
    private int bpm = 120; // BPM padrão TODO: acho que dá pra trabalhar com isso
    private String instrument = "Piano"; // instrumento padrão

    public Pattern convertTextToMusic(String text) {
        StringBuilder patternBuilder = new StringBuilder();
        Random randomNumber = new Random();

        for (int currentChar = 0; currentChar < text.length(); currentChar++) {
            char c = text.charAt(currentChar);
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
                    patternBuilder.append("V").append(volume).append(" ");
                    break;
                case '-':
                    volume = 100; // volume default
                    patternBuilder.append("V").append(volume).append(" ");
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
                case ';':
                    bpm = randomNumber.nextInt(120) + 60; // Valor aleatório entre 60 e 180
                    patternBuilder.append("T").append(bpm).append(" ");
                    break;
                case 'N':
                    if (currentChar + 1 < text.length() && text.charAt(currentChar + 1) == 'L') {
                        patternBuilder.append("I[").append(instrument).append("] ");
                        currentChar++;
                    }
                    break;

                default:
                    patternBuilder.append("NOP ");
            }
        }

        // Adiciona o final do padrão
        patternBuilder.append(" | ");

        // Converte o padrão para o formato JFugue
        System.out.println(patternBuilder.toString()); // coloquei essa saída como teste, TODO: tirar no fim
        return new Pattern(patternBuilder.toString());
    }
}

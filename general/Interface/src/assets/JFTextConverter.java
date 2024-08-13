package general.Interface.src.assets;

import org.jfugue.pattern.Pattern;

import java.util.Random;
public class JFTextConverter {
    public String PatternText;
    private static final int DEFAULT_VOLUME = 50;
    private static final int MAX_VOLUME = 100;
    private static final int DEFAULT_OCTAVE = 4;
    private static final int DEFAULT_BPM = 120;
    private static final int DEFAULT_BPM_RAISE = 80;
    private int volume = DEFAULT_VOLUME;
    private static final char[] mainNotes = {'A', 'a', 'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g'};

    public Pattern convertTextToMusic(String text) {
        StringBuilder patternBuilder = new StringBuilder();
        Random randomNumber = new Random();
        boolean inInstrumentBlock = false;
        StringBuilder instrumentBuilder = new StringBuilder();


        int octave = DEFAULT_OCTAVE; // oitava padrão
        int bpm = DEFAULT_BPM; // BPM padrão

        patternBuilder.append("T").append(bpm).append(" "); // Inicia com BPM padrão
        patternBuilder.append("I[Piano] ");
        patternBuilder.append(":CON(7, ").append(DEFAULT_VOLUME).append(") ");

        for (int currentChar = 0; currentChar < text.length(); currentChar++) {
            char c = text.charAt(currentChar);
            char nextChar;
            String instrument;
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
                    case 'B':
                        if (currentChar + 1 < text.length()) {
//                            nextChar = text.charAt(currentChar + 1);
                            if (handleBPM(text.substring(currentChar))) {
                                bpm += DEFAULT_BPM_RAISE;
                                patternBuilder.append("T").append(bpm).append(" ");
                                currentChar += 3; // Pular os caracteres "BPM+" (ou o que for equivalente)
                                break;
                            }
                        }
                        patternBuilder.append("B").append(octave).append(" ");
                        break;
                    case 'b':
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
                        if (volume <= DEFAULT_VOLUME)
                            volume *= 2;
                        else
                            volume = MAX_VOLUME;
                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
                        break;
                    case '-':
                        volume = DEFAULT_VOLUME;
                        patternBuilder.append(":CON(7, ").append(volume).append(") ");
                        break;
                    case 'I': case 'i': case 'O': case 'o': case 'U': case 'u': // Vogais restantes
                        char previousChar = text.charAt(currentChar - 1);
                        boolean foundAVowel = false;
                        for (char mainNote : mainNotes) { // Se o caracter é uma nota musical
                            if (previousChar == mainNote) {
                                patternBuilder.append(mainNote).append(octave).append(" "); // Toca novamente a última nota
                                foundAVowel = true;
                            }
                        }
                        if (!foundAVowel) // Senão, toca duas notas de telefone
                            patternBuilder.append("I[TELEPHONE_RING] A4 A4");
                        break;
                    case 'R':
                        if (currentChar + 1 < text.length()) {
                            nextChar = text.charAt(currentChar + 1);
                            if (nextChar == '+') {
                                if (octave <= 10)
                                    octave++;
                            } else if (nextChar == '-') {
                                if (octave >= 0)
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
                        // Verifica o próximo caractere para iniciar o bloco de instrumento
                        if (currentChar + 1 < text.length()) {
                            nextChar = text.charAt(currentChar + 1);
                            if (nextChar == '*') {
                                inInstrumentBlock = true;
                                currentChar++; // Pular o próximo caractere '*'
                            }
                        }
                        // Adiciona o bloco de instrumento ao padrão se for o caso
                        if (inInstrumentBlock && !instrumentBuilder.isEmpty()) {
                            instrument = instrumentBuilder.toString();
                            patternBuilder.append("I[").append(instrument).append("] ");
                            instrumentBuilder.setLength(0); // Limpa o buffer do instrumento
                        }
                        break;
                    case ';':
                        bpm = randomNumber.nextInt(300) + 60; // Valor aleatório entre 60 e 360
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
        PatternText = patternBuilder.toString();
        System.out.println(PatternText); // coloquei essa saída como teste, TODO: tirar no fim
        return new Pattern(PatternText);
    }

    boolean handleBPM(String text) {
        return text.startsWith("BPM+");
    }
}

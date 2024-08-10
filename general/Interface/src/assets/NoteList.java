package general.Interface.src.assets;

import java.util.HashMap;
import java.util.Map;

public class NoteList {

    private static final int BASE_OCTAVE = 1; // Oitava base
    private static final int MAX_OCTAVES = 8; // Máximo de oitavas suportadas
    private static final Map<Character, Integer> NOTE_MAP = new HashMap<>();

    static {
        NOTE_MAP.put('A', 21);  // A1
        NOTE_MAP.put('B', 23);  // B1
        NOTE_MAP.put('C', 25);  // C1
        NOTE_MAP.put('D', 26);  // D1
        NOTE_MAP.put('E', 28);  // E1
        NOTE_MAP.put('F', 29);  // F1
        NOTE_MAP.put('G', 31);  // G1
    }

    public static int getNoteOctaved(char c, int octave) {
        Integer baseNote = NOTE_MAP.get(c);
        if (baseNote != null) {
            // Ajusta a nota para a oitava especificada
            int note = baseNote + (octave - BASE_OCTAVE) * 12;
            return note;
        }
        return -1;
    }

    public static Map<Character, Integer> getNoteMap(){
        return NOTE_MAP;
    }

    public static int getBaseOctave(){
        return BASE_OCTAVE;
    }

    public static int getMaxOctaves(){
        return MAX_OCTAVES;
    }
}
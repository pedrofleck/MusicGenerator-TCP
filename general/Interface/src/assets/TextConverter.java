package general.Interface.src.assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextConverter {

    private int currentOctave = 1;
    private int volume = 15;

    private static final int MIN_VOLUME = 15;
    private static final int MAX_VOLUME = 120;
    private final Map<Character, Integer> noteList = NoteList.getNoteMap();

    public List<MusicCommand> generateMusicCommands(String text) {
        List<MusicCommand> commands = new ArrayList<>();
        String converted = text.toUpperCase(); // TODO: acho que precisamos tirar isso pra considerar maiúsculas e minúsculas

        for (char c : converted.toCharArray()) {
            if (c == '?') {
                increaseOctave();
            } else if (c == ' ') {
                doubleVolume();
            } else {
                Integer note = noteList.get(c);
                if (note != null) {
                    int octavedNote = NoteList.getNoteOctaved(c, currentOctave);
                    commands.add(new MusicCommand(octavedNote, volume));
                }
            }
        }

        resetOctave();
        resetVolume();

        return commands;
    }

    private void increaseOctave() {
        currentOctave++;
        if (currentOctave > NoteList.getMaxOctaves()) {
            resetOctave();
        }
    }

    private void resetOctave() {
        currentOctave = NoteList.getBaseOctave();
    }

    private void doubleVolume() {
        volume *= 2;
        if (volume > MAX_VOLUME) {
            resetVolume();
        }
    }

    private void resetVolume() {
        volume = MIN_VOLUME;
    }
}

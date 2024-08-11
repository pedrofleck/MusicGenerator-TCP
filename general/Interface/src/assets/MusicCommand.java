package general.Interface.src.assets;

public class MusicCommand {

    private final int note;
    private final int volume;

    public MusicCommand(int note, int volume) {
        this.note = note;
        this.volume = volume;
    }

    public int getNote() {
        return note;
    }

    public int getVolume() {
        return volume;
    }
}
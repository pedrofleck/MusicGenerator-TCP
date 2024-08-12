package general.Interface.src.assets;

import org.jfugue.pattern.Pattern;
import org.jfugue.realtime.RealtimePlayer;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;

public class JFMusicPlayer {
    private RealtimePlayer player;
    private Pattern pattern;
    private boolean playerWorking = false;

    public JFMusicPlayer() {
        createPlayer();
    }

    public void createPlayer() {
        try {
            this.player = new RealtimePlayer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao reproduzir.");
        }
        playerWorking = true;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public void play() {
        if (!playerWorking) {
            createPlayer();
        }
        if (pattern != null) {
            player.play(pattern);
        }
    }

    public void stop() {
        playerWorking = false;
        player.close();
    }

    public void shutdown() {
        stop();
    }
}

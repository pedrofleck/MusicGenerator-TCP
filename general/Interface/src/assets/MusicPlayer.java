package general.Interface.src.assets;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

public class MusicPlayer {

    private Synthesizer synthesizer;
    private MidiChannel[] channels;
    private boolean keepPlaying = true;
    private Thread playbackThread; // Usando thread pra conseguir parar a música antes que acabe

    public MusicPlayer() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playCommands(List<MusicCommand> commands) {
        keepPlaying = true;
        playbackThread = new Thread(() -> {
            for (MusicCommand command : commands) {
                if (!keepPlaying) {
                    break; // Interrompe a reprodução se keepPlaying for false
                }
                playNote(command.getNote(), command.getVolume());
            }
        });
        playbackThread.start(); // Inicia a reprodução em uma nova thread
    }

    public void stop() {
        keepPlaying = false;
        if (playbackThread != null) {
            playbackThread.interrupt(); // Interrompe o thread de reprodução
        }
        for (MidiChannel channel : channels) {
            channel.allNotesOff(); // Desativa todas as notas em todos os canais
        }
    }

    private void playNote(int note, int volume) {
        if (synthesizer != null && keepPlaying) {
            for (MidiChannel channel : channels) {
                channel.noteOn(note, volume);
            }
            try {
                Thread.sleep(800); // Velocidade
            } catch (InterruptedException e) {
                // Interrompe a reprodução quando o thread é interrompido
                if (!keepPlaying) {
                    return;
                }
                e.printStackTrace();
            }
            for (MidiChannel channel : channels) {
                channel.noteOff(note);
            }
        }
    }

    public void close() {
        // TODO: Não sei se é necessário, deixei porque o João colocou
        stop ();
        if (synthesizer != null) {
            synthesizer.close();
        }
    }
}
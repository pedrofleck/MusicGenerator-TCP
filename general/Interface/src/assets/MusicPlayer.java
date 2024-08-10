package general.Interface.src.assets;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.Map;

public class MusicPlayer {

    private Synthesizer synthesizer;
    private MidiChannel[] channels;
    private int currentOctave = 1; // Oitava inicial
    private int volume = 15; // Valor inicial de volume

    private static final int MIN_VOLUME = 15; // Valor mínimo de volume
    private static final int MAX_VOLUME = 120; // Valor máximo de volume
    private final Map<Character, Integer> noteList = NoteList.getNoteMap();

    public MusicPlayer(){
        try{
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
        }catch(MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void convertText(String text){
        String converted = text.toUpperCase();
        for(char c : converted.toCharArray()){
            if(c == '?'){
                this.increaseOctave();
            }else if(c == ' '){
                this.doubleVolume();
            }else{
                Integer note = noteList.get(c);
                if(note != null){
                    this.playNote(NoteList.getNoteOctaved(c, currentOctave));
                }
            }
        }
        this.resetOctave();
        this.resetVolume();
    }

    public void playNote(int note){
        if(synthesizer != null){
            for(MidiChannel channel : channels){
                channel.noteOn(note, this.volume);
            }
            try{
                Thread.sleep(800); // Velocidade
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            for(MidiChannel channel : channels) {
                channel.noteOff(note);
            }
        }
    }

    private void increaseOctave(){
        this.currentOctave++;
        // Se exceder o número máximo de oitavas, reinicia
        if(this.currentOctave > NoteList.getMaxOctaves()){
            this.resetOctave();
        }
    }

    private void resetOctave(){
        this.currentOctave = NoteList.getBaseOctave();
    }

    private void doubleVolume(){
        this.volume *= 2;
        // Se exceder o valor máximo de volume, reinicia
        if(this.volume > MAX_VOLUME){
            this.resetVolume();
        }
        // Atualiza o volume do canal MIDI
        for(MidiChannel channel : channels){
            channel.controlChange(7, this.volume); // CC 7 é o controle de volume
        }
    }

    private void resetVolume(){
        this.volume = MIN_VOLUME;
    }

    public void close() {
        if(synthesizer != null){
            synthesizer.close();
        }
    }
}
package general.Interface.src.assets;

import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.midi.MidiFileManager;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class SaveToFile {

    public void savePatternToMidiFile(Pattern pattern) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Arquivo MIDI");

        // Define o filtro para mostrar apenas arquivos MIDI
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Arquivos MIDI", "mid"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Inclui o final .mid independente do usuário
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".mid")) {
                filePath += ".mid";
                fileToSave = new File(filePath);
            }

            try {
                MidiFileManager.savePatternToMidi(pattern, fileToSave); // efetivamente gera o arquivo
                JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso em " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro ao salvar o arquivo MIDI.");
                JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo.");
            }
        }
    }
}

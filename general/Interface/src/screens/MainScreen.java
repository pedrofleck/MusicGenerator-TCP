package general.Interface.src.screens;

import general.Interface.src.components.Window;
import general.Interface.src.assets.JFMusicPlayer;
import general.Interface.src.assets.JFTextConverter;
import general.Interface.src.assets.SaveToFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfugue.pattern.Pattern;

public class MainScreen {
    private JPanel mainScreen;
    private JTextArea insertMusic;
    private JButton helpButton;
    private JButton generateButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JProgressBar progressBar;
    private JButton lowerVolumeButton;
    private JButton raiseVolumeButton;
    private JPanel mainPanel;
    private JPanel playPanel;
    private JTextArea notesTable;
    private JButton saveButton;
    private JSlider volumeSlider;

    private final JFTextConverter textConverter = new JFTextConverter();
    private final JFMusicPlayer musicPlayer = new JFMusicPlayer();
    private final SaveToFile saveToFile = new SaveToFile();

    private Pattern pattern; // Padrão usado pelo JFugue para reproduzir MIDI

    public MainScreen() {
        initializeComponents();
        setupListeners();
    }

    private void initializeComponents() {
        // Inicialização dos componentes

    }

    private void setupListeners() {
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Window(new QuestionScreen(), new Color(0xd9d9d9), "Music Generator - Ajuda");
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertedText = insertMusic.getText().trim();
                pattern = textConverter.convertTextToMusic(insertedText);
                musicPlayer.setPattern(pattern);
                if (insertedText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Insira algum texto para ser convertido."
                    );
                } else {
                    JOptionPane.showMessageDialog(null, "Texto convertido para música!");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile.savePatternToMidiFile(pattern);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.play();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.stop();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainScreen;
    }
}
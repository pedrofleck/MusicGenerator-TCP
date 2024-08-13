package general.Interface.src.screens;

import general.Interface.src.components.Window;
import general.Interface.src.assets.JFMusicPlayer;
import general.Interface.src.assets.JFTextConverter;
import general.Interface.src.assets.SaveToFile;
import general.Interface.src.assets.NotesMusicForUser;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JButton stopButton;
    private JButton lowerVolumeButton;
    private JButton raiseVolumeButton;
    private JPanel mainPanel;
    private JPanel playPanel;
    private JTextArea notesTable;
    private JButton saveButton;
    private JSlider volumeSlider;
    private JLabel informationTextArea;

    private final JFTextConverter textConverter = new JFTextConverter();
    private final JFMusicPlayer musicPlayer = new JFMusicPlayer();
    private final SaveToFile saveToFile = new SaveToFile();

    private static final int MIN_VOLUME = 0;
    private static final int MAX_VOLUME = 100;
    private static final int VOLUME_DEFAULT_STEP = 10;
    private static final Color SUCCESS_COLOR = new Color(0, 124, 8);
    private static final Color ATTENTION_COLOR = new Color(189, 148, 0);
    private static final Color ERROR_COLOR = new Color(189, 0, 16);


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
                new Window(new QuestionScreen(), new Color(0xd9d9d9), "Ajuda");
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String insertedText = insertMusic.getText().trim();
                pattern = textConverter.convertTextToMusic(insertedText);
                String patternText = pattern.toString();
                musicPlayer.setPattern(pattern);
                if (insertedText.isEmpty()) {
                    updateInformationTextArea("Insira algum texto para ser convertido.", ATTENTION_COLOR);
                } else {
                    updateInformationTextArea("Texto convertido para música!", SUCCESS_COLOR);
                    NotesMusicForUser notesMusicForUser = new NotesMusicForUser();
                    StringBuilder stringNova = notesMusicForUser.stringText(patternText);
                    notesTable.setText(stringNova.toString());                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePlace = saveToFile.savePatternToMidiFile(pattern);
                if (filePlace != null)
                    updateInformationTextArea("Arquivo salvo com sucesso em " + filePlace, SUCCESS_COLOR);
                else
                    updateInformationTextArea("Erro ao salvar o arquivo." + filePlace, ERROR_COLOR);

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

        volumeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int volume = volumeSlider.getValue();
                textConverter.updateVolume(volume);
            }
        });
        lowerVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentVolume = volumeSlider.getValue();
                int newVolume = Math.max(currentVolume - VOLUME_DEFAULT_STEP, MIN_VOLUME);
                volumeSlider.setValue(newVolume);
                textConverter.updateVolume(newVolume);
            }
        });
        raiseVolumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentVolume = volumeSlider.getValue();
                int newVolume = Math.min(currentVolume + VOLUME_DEFAULT_STEP, MAX_VOLUME);
                volumeSlider.setValue(newVolume);
                textConverter.updateVolume(newVolume);
            }
        });
    }

    private void updateInformationTextArea (String information, Color color) {
        informationTextArea.setText(information);
        informationTextArea.setForeground(color);
    }

    public JPanel getMainPanel() {
        return mainScreen;
    }
}
package general.Interface.src.screens;

import general.Interface.src.assets.MusicCommand;
import general.Interface.src.assets.TextConverter;
import general.Interface.src.components.Window;
import general.Interface.src.assets.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.List;

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
    private JTextArea textArea1;
    private JButton salvarButton;
    private JSlider volumeSlider;

    private final TextConverter textConverter = new TextConverter();
    private final MusicPlayer musicPlayer = new MusicPlayer();
    private List<MusicCommand> musicCommands;

    public MainScreen() {
        initializeComponents();
        setupListeners();
    }

    private void initializeComponents() {
        // Inicialização dos componentes e layout
        insertMusic.addComponentListener(new ComponentAdapter() {
        });
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
                musicCommands = textConverter.generateMusicCommands(insertMusic.getText());
                if (insertedText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Insira algum texto para ser convertido."
                    );
                } else {
                    musicCommands = textConverter.generateMusicCommands(insertedText);
                    JOptionPane.showMessageDialog(null, "Texto convertido para música!");
                }
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.playCommands(musicCommands);
//                if (musicCommands != null && !musicCommands.isEmpty()) {
//                    musicPlayer.playCommands(musicCommands);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Nenhum comando foi dado. Por favor, " +
//                            "converta o texto primeiro.");
//                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: não implementado, precisamos de um contador, isso inclui a barra de progresso.
                //  Vai ser complicado :')
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
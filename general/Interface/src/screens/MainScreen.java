package general.Interface.src.screens;

import general.Interface.src.components.Window;
import general.Interface.src.assets.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class MainScreen {

    private JPanel mainScreen;
    private JTextArea insertMusic;
    private JButton helpButton;
    private JButton generateButton;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JProgressBar progressBar1;
    private JButton button6;
    private JButton button7;
    private JPanel mainPanel;
    private JPanel playPanel;
    private JTextArea textArea1;

    private final MusicPlayer musicPlayer = new MusicPlayer();

    public MainScreen() {
        initializeComponents();
        setupListeners();
        insertMusic.addComponentListener(new ComponentAdapter() {
        });
    }

    private void initializeComponents() {
        // Inicialização dos componentes e layout

    }

    private void setupListeners() {
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Window(new QuestionScreen(), new Color(0xd9d9d9), "Music Generator - Ajuda");
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.convertText(insertMusic.getText());
            }
        });
    }

    public JPanel getMainPanel() {
        return mainScreen;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}


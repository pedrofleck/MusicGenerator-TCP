package general.Interface.src;

import general.Interface.src.assets.MusicPlayer;
import general.Interface.src.components.Window;
import general.Interface.src.screens.QuestionScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//todas as variaveis utilizadas com nome padrao
public class PrincipalScreen extends JDialog {
    private JPanel principal;
    private JPanel panelPlay;
    private JPanel panelLateral;
    private JTextArea writeText;
    private JButton playButton;
    private JButton exitMusicButton;
    private JButton pauseButton;
    private JProgressBar progressBar1;
    private JTextField titleTextField;
    private JButton questionButton;
    private JButton volumeDownButton;
    private JButton volumeUpButton;
    private JButton generateButton;
    private JTextPane showGenerateMusic;
    private JTextArea textArea1;

    private final MusicPlayer musicPlayer = new MusicPlayer();

    public JPanel getPrincipal() {
        return principal;
    }
//ativando o botao gerar
    public PrincipalScreen() {
        setContentPane(principal);
        setModal(true);
        getRootPane().setDefaultButton(generateButton);
//        gerar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            /*  public void windowClosing(WindowEvent e) {
            onCancel();
        }*/
    });

    // call onCancel() on ESCAPE
        principal.registerKeyboardAction(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            onCancel();
        }
    }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        questionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Window(new QuestionScreen(), new Color(0xd9d9d9), "Music Generator - Ajuda");
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String userContent =writeText.getText();
                // titleTextField.setText(userContent); only para aparecer no TÍTULO
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.convertText(writeText.getText());
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        PrincipalScreen dialog = new PrincipalScreen();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}








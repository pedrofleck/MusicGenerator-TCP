package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame{

    public Window(JPanel panel){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas esta janela
        setLocationByPlatform(true); // Sistema encontra a melhor posição inicial
        setMinimumSize(new Dimension(800, 600));
        setResizable(false); // Bloqueio de redimensionamento da tela
        setTitle("Music Generator - Ajuda");
        getRootPane().registerKeyboardAction( // Fechar a janela pelo ESC
                e -> dispose(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        pack();
        setVisible(true);
    }

}
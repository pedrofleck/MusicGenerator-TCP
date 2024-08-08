package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame{

    private final JPanel panel;
    private final Color color;

    public Window(JPanel panel, Color color){
        this.panel = panel;
        this.color = color;
        this.config();
    }

    private void config(){
        setBackground(this.color);
        setContentPane(this.panel);
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
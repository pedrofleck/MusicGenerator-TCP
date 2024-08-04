package general.Interface.src;

import javax.swing.*;
import java.awt.Dimension;

public class MainWindow {
    //como chamar a tela principal
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PrincipalScreen screen = new PrincipalScreen();
        frame.setContentPane(screen.getPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.pack();
        frame.setTitle("Trabalho TCP ");
        frame.setVisible(true);
    }
}

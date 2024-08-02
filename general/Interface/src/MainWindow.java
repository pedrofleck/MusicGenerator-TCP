package general.Interface.src;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PrincipalScreen principalScreen = new PrincipalScreen();
        frame.setContentPane(principalScreen.getPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.pack();
        frame.setTitle("Trabalho TCP ");
        frame.setVisible(true);
    }
}

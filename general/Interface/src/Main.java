package general.Interface.src;

import general.Interface.src.components.Window;
import general.Interface.src.screens.PrincipalScreen;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // frame = new JFrame();
        //PrincipalScreen screen = new PrincipalScreen();
        //frame.setContentPane(screen.getPrincipal());
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setMinimumSize(new Dimension(800, 600));
        //frame.pack();
        //frame.setTitle("Trabalho TCP ");
        //frame.setVisible(true);
        new Window(new PrincipalScreen(), new Color(0xd9d9d9), "Music Generator");
    }
}
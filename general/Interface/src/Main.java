package general.Interface.src;

import general.Interface.src.screens.MainScreen;
import general.Interface.src.components.Window;
import general.Interface.src.screens.PrincipalScreen;

import javax.swing.*;
import java.awt.*;

public class Main {

//    public static void main(String[] args) {
//        // Roda o programa com visual mais próximo do nativo do Sistema Operacional
//        try {
//            // Define o look and feel para o padrão do sistema operacional
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // frame = new JFrame();
//        //PrincipalScreen screen = new PrincipalScreen();
//        //frame.setContentPane(screen.getPrincipal());
//        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //frame.setMinimumSize(new Dimension(800, 600));
//        //frame.pack();
//        //frame.setTitle("Trabalho TCP ");
//        //frame.setVisible(true);
//        //new Window(new PrincipalScreen(), new Color(0xd9d9d9), "Music Generator");
//
//    }
//}
public static void main(String[] args) {
    // Roda o programa com visual mais próximo do nativo do Sistema Operacional
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Cria e configura o frame principal
    JFrame frame = new JFrame("Music Generator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.setMinimumSize(new Dimension(800, 600));
    frame.setContentPane(createMainScreenPanel());
    frame.pack();
    frame.setVisible(true);
    }

    private static JPanel createMainScreenPanel() {
        MainScreen mainScreen = new MainScreen();
        return mainScreen.getMainPanel();
    }
}
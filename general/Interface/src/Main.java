package general.Interface.src;

import general.Interface.src.screens.MainScreen;

import javax.swing.*;

public class Main {

public static void main(String[] args) {
    // Roda o programa com visual mais próximo do nativo do Sistema Operacional
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Cria e configura o frame principal
    JFrame frame = new JFrame("Music Generator");
    ImageIcon icon = new ImageIcon(Main.class.getResource("/general/Interface/png/icon.png"));
    frame.setIconImage(icon.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(createMainScreenPanel());
    frame.pack();
    frame.setVisible(true);
    }

    private static JPanel createMainScreenPanel() {
        MainScreen mainScreen = new MainScreen();
        return mainScreen.getMainPanel();
    }
}
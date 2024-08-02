package general.Interface.src;

import javax.swing.*;
import java.awt.event.*;

public class PrincipalScreen extends JDialog {
    private JPanel principal;
    private JButton buttonGerar;
    private JPanel PainelBotao;
    private JPanel PainelLateral;
    private JPanel Suport;
    private JTextArea escrevertexto;
    private JTextPane textPane1;

    public JPanel getPrincipal() {
        return principal;
    }

    public PrincipalScreen() {
        setContentPane(principal);
        setModal(true);
        getRootPane().setDefaultButton(buttonGerar);

        buttonGerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        principal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
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

package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionButton extends JButton {

    private String title;
    private Color color;

    public ActionButton(String title, Color color){
        this.title = title;
        this.color = color;
        this.config();
    }

    private void config(){
        setBackground(this.color);
        setText(this.title);
    }

    // Método para adicionar um ActionListener ao botão
    public void addActionListener(ActionListener listener) {
        super.addActionListener(listener);
    }

}
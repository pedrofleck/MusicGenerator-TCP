package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {

    private final String text;

    public TextLabel(String text){
        this.text = text;
        this.config();
    }

    private void config(){
        setFont(new Font("Arial", Font.BOLD, 15));
        setText(this.text);
    }
}
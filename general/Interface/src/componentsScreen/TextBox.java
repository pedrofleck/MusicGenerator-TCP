package general.Interface.src.componentsScreen;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JTextArea {

    public TextBox(){
        this.config();
    }

    private void config(){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
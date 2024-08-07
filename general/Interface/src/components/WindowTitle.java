package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class WindowTitle extends JLabel {

    public WindowTitle(String title){
        setFont(new Font("Arial", Font.BOLD, 20));
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(800, 50));
        setText(title);
    }

}
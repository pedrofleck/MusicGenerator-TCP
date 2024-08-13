package general.Interface.src.componentsScreen;

import javax.swing.*;
import java.awt.*;

public class WindowTitle extends JLabel {

    private final String title;

    public WindowTitle(String title){
        this.title = title;
        this.config();
    }

    private void config(){
        setFont(new Font("Arial", Font.BOLD, 20));
        setHorizontalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension(800, 50));
        setText(this.title);
    }
}
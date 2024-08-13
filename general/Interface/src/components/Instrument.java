package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class Instrument extends JPanel {

    private final MiniBox txt;

    public Instrument(String txt, int widthTxt){
        this.txt = new MiniBox(txt, new Color(0x78b7e4), new Dimension(widthTxt,30));
        this.config();
    }

    private void config(){
        add(this.txt);
    }
}
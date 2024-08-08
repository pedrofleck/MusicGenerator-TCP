package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class Instruction extends JPanel {

    private final MiniBox label;
    private final MiniBox txt;

    public Instruction(String label, String txt, int width){
        this.label = new MiniBox(label, new Color(0xEAEAEA), new Dimension(width, 30));
        this.txt = new MiniBox(txt, new Color(0x78b7e4), new Dimension(width,30));
        this.config();
    }

    private void config(){
        add(this.label);
        add(this.txt);
    }
}
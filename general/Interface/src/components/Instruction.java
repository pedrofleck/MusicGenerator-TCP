package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class Instruction extends JPanel {

    private MiniBox label;
    private MiniBox txt;

    public Instruction(String label, String txt){
        this.label = new MiniBox(label, new Color(0xEAEAEA), new Dimension(150, 50));
        this.txt = new MiniBox(txt, new Color(0x78b7e4), new Dimension(150,50));
        this.config();
    }

    private void config(){
        add(this.label);
        add(this.txt);
    }
}
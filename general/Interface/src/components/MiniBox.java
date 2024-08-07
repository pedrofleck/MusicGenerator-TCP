package general.Interface.src.components;

import javax.swing.*;
import java.awt.*;

public class MiniBox extends JLabel {

    private String txt;
    private Color color;
    private Dimension dimension;

    public MiniBox(String txt, Color color, Dimension dimension){
        this.txt = txt;
        this.color = color;
        this.dimension = dimension;
        this.config();
    }

    private void config(){
        setBackground(this.color);
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3)); // Espaçamento interno
        setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento do texto à esquerda
        setOpaque(true); // Necessário para exibir a cor de fundo
        setPreferredSize(dimension);
        setText(this.txt);
    }
}
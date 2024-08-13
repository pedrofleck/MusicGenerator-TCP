package general.Interface.src.componentsScreen;

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
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Adiciona uma borda de 1px preta
        setHorizontalAlignment(SwingConstants.CENTER); // Alinhamento do texto à esquerda
        setOpaque(true); // Necessário para exibir a cor de fundo
        setPreferredSize(dimension);
        setText(this.txt);
    }
}
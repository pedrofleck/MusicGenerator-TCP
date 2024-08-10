package general.Interface.src.screens;

import general.Interface.src.assets.MusicPlayer;
import general.Interface.src.components.ActionButton;
import general.Interface.src.components.TextBox;
import general.Interface.src.components.Window;
import general.Interface.src.components.WindowTitle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalScreen extends JPanel {

    private TextBox text;
    private final MusicPlayer musicPlayer = new MusicPlayer();

    public PrincipalScreen(){
        this.config();
        this.addComponents();
    }

    private void config(){
        setLayout(new BorderLayout());
    }

    private void addComponents(){
        JPanel header = this.createHeader();
        add(header, BorderLayout.NORTH);
        JPanel textBox = createTextBox();
        add(textBox, BorderLayout.CENTER);
        JPanel playerArea = createPlayerArea();
        add(playerArea, BorderLayout.SOUTH);
    }

    private JPanel createHeader(){
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        header.add(new WindowTitle("GERADOR DE MÚSICA ESCREVENDO TEXTO"), BorderLayout.WEST);
        ActionButton btn = new ActionButton("Ajuda", new Color(0xff6347));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Window(new QuestionScreen(), new Color(0xd9d9d9), "Music Generator - Ajuda");
            }
        });
        header.add(btn, BorderLayout.EAST);
        return header;
    }

    private JPanel createTextBox(){
        JPanel textBox = new JPanel(new BorderLayout());
        textBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        text = new TextBox(); // Alterado para TextBox
        textBox.add(new JScrollPane(text), BorderLayout.CENTER); // Adiciona um JScrollPane se o texto for maior que a área visível
        return textBox;
    }

    private JPanel createPlayerArea(){
        JPanel playerArea = new JPanel(new BorderLayout());
        playerArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ActionButton btn = new ActionButton("Play", Color.GREEN);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                musicPlayer.convertText(text.getText());
            }
        });
        playerArea.add(btn);
        return playerArea;
    }
}
package general.Interface.src;

import general.Interface.src.assets.InstructionsList;
import general.Interface.src.components.ListBox;
import general.Interface.src.components.TextLabel;
import general.Interface.src.components.WindowTitle;

import javax.swing.*;
import java.awt.*;

public class QuestionScreen extends JPanel {

    public QuestionScreen(){
        this.config();
        this.addComponents();
    }

    private void config(){
        setLayout(new BorderLayout()); // Definindo o layout como BorderLayout
    }

    private void addComponents(){
        // Texto na parte superior
        JPanel textPanel = this.createTextPanel();
        add(textPanel, BorderLayout.NORTH);
        // Painel principal que vai conter as listas
        JPanel listPanel = this.createListPanel();
        add(listPanel, BorderLayout.CENTER);
    }

    private JPanel createTextPanel(){ // Título da janela e instrução
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS)); // Define o layout vertical
        WindowTitle title = new WindowTitle("Instruções");
        title.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o título
        TextLabel text = new TextLabel("Escreva na caixa de texto para gerar a música.");
        text.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o texto
        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(10)); // Espaço entre o título e o texto
        textPanel.add(text);
        return textPanel;
    }

    private JPanel createListPanel(){
        JPanel listPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        // Painel flexível para lista 1 e lista 2
        JPanel topPanel = new JPanel(new GridLayout(1, 2, 2, 0));
        topPanel.add(new ListBox(new InstructionsList().getInstructions1()));
        topPanel.add(new ListBox(new InstructionsList().getInstructions2()));
        // Adiciona topPanel na primeira linha
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        listPanel.add(topPanel, gbc);
        // Adiciona lista 3 abaixo de lists 1 e lista 2
        gbc.weighty = 0.5; // Ajusta o peso vertical para dividir o espaço
        listPanel.add(new ListBox(new InstructionsList().getInstructions3()), gbc);
        return listPanel;
    }
}
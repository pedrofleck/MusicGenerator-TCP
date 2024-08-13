package general.Interface.src.screens;

import general.Interface.src.principalClasses.InstructionsList;
import general.Interface.src.componentsScreen.ListBox;
import general.Interface.src.componentsScreen.TextLabel;
import general.Interface.src.componentsScreen.WindowTitle;


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

    private JPanel createListPanel() {
        JPanel listPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento entre os componentes

        // Adiciona lista 1 e lista 2 lado a lado na primeira linha
        JPanel topPanel = new JPanel(new GridLayout(1, 2, 1, 0));
        topPanel.add(new ListBox(new InstructionsList().getInstructions1()));
        topPanel.add(new ListBox(new InstructionsList().getInstructions2()));

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2; // Ajusta o peso vertical para dividir o espaço
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza horizontalmente
        listPanel.add(topPanel, gbc);

        // Adiciona lista 3 embaixo das listas 1 e 2
        gbc.weighty = 0.2;
        listPanel.add(new ListBox(new InstructionsList().getInstructions3()), gbc);

        // Adiciona o título e a descrição abaixo das instruções
        gbc.weighty = 0.0; // Remove o peso vertical para o título e descrição
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza horizontalmente
        JPanel titleAndDescriptionPanel = new JPanel();
        titleAndDescriptionPanel.setLayout(new BoxLayout(titleAndDescriptionPanel, BoxLayout.Y_AXIS)); // Layout vertical
        titleAndDescriptionPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o conteúdo
        titleAndDescriptionPanel.add(new TextLabel("Exemplos de instrumentos. Mais estão disponíveis através do link."));
        listPanel.add(titleAndDescriptionPanel, gbc);

        // Adiciona lista 4, lista 5 e lista 6 lado a lado abaixo da descrição
        JPanel bottomPanel = new JPanel(new GridLayout(1, 6, 2, 0)); // Ajuste o número de colunas conforme necessário
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments1()));
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments2()));
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments3()));
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments4()));
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments5()));
        bottomPanel.add(new ListBox(new InstructionsList().getInstruments6()));

        gbc.weighty = 0.6; // Ajusta o peso vertical para dividir o espaço
        listPanel.add(bottomPanel, gbc);

        // Adiciona a mensagem com o link abaixo da listagem de instrumentos
        gbc.weighty = 0.0; // Remove o peso vertical para a mensagem
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza horizontalmente
        JPanel linkPanel = new JPanel();
        linkPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centraliza o conteúdo
        linkPanel.add(new JLabel("<html><a href='https://soundprogramming.net/file-formats/general-midi-instrument-list/'>https://soundprogramming.net/file-formats/general-midi-instrument-list/</a></html>"));
        listPanel.add(linkPanel, gbc);

        return listPanel;
    }



}
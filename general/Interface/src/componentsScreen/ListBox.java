package general.Interface.src.componentsScreen;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListBox extends JPanel {

    private List<JPanel> list;

    public ListBox(List list){
        this.list = list;
        this.setConfig();
        this.addItems();
    }

    private void addItems(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE; // Automaticamente incrementa a posição Y
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Faz com que o painel preencha horizontalmente
        gbc.insets = new Insets(0, 0, 0, 0); // Define margens (superior, esquerda, inferior, direita)
        for(JPanel item : list){
            add(item, gbc);
        }
    }

    private void setConfig(){
        setLayout(new GridBagLayout());
    }
}
package general.Interface.src;

import general.Interface.src.components.InstructionList;
import general.Interface.src.components.WindowTitle;

import javax.swing.*;
import java.awt.*;

public class QuestionScreen extends JPanel {

    public QuestionScreen(){
        setLayout(new BorderLayout()); // Definindo o layout como BorderLayout
        add(new WindowTitle("Instruções"), BorderLayout.NORTH);
        add(new InstructionList(), BorderLayout.CENTER);
    }

}
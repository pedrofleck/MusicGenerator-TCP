package general.Interface.src.components;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InstructionList extends JPanel {

    private List<Instruction> list = new ArrayList<>();

    public InstructionList(){
        this.setConfig();
        this.createInstructions();
        for(Instruction instruction : list){
            add(instruction);
        }
    }

    private void setConfig(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private void createInstructions(){
        this.list.add(new Instruction("Letra A maiúscula", "Nota Lá"));
        this.list.add(new Instruction("Letra B maiúscula", "Nota Si"));
        this.list.add(new Instruction("Letra C maiúscula", "Nota Dó"));
        this.list.add(new Instruction("Letra D maiúscula", "Nota Ré"));
        this.list.add(new Instruction("Letra E maiúscula", "Nota Mi"));
        this.list.add(new Instruction("Letra F maiúscula", "Nota Fá"));
        this.list.add(new Instruction("Letra G maiúscula", "Nota Sol"));
    }
}
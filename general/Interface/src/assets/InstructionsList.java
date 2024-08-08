package general.Interface.src.assets;

import general.Interface.src.components.Instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionsList {

    public List getInstructions1(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Letra A maiúscula", "Nota Lá", 150));
        list.add(new Instruction("Letra B maiúscula", "Nota Si", 150));
        list.add(new Instruction("Letra C maiúscula", "Nota Dó", 150));
        list.add(new Instruction("Letra D maiúscula", "Nota Ré", 150));
        list.add(new Instruction("Letra E maiúscula", "Nota Mi", 150));
        list.add(new Instruction("Letra F maiúscula", "Nota Fá", 150));
        list.add(new Instruction("Letra G maiúscula", "Nota Sol", 150));
        return list;
    }

    public List getInstructions2(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Número", "Instr. General MIDI", 150));
        list.add(new Instruction("Letras I, i, O, o, U, u", "Instr. Harpsichord", 150));
        list.add(new Instruction("Ponto Exclamação (!)", "Instr. Agogo", 150));
        list.add(new Instruction("Ponto e Vírgula (;)", "Instr. Pan Flute", 150));
        list.add(new Instruction("Vírgula (,)", "Instr. Church Organ", 150));
        list.add(new Instruction("Tecla NL (Enter)", "Instr. Tubular Bells", 150));
        list.add(new Instruction("Ponto Interrogação (?)", "Aumenta uma oitava", 150));
        return list;
    }

    public List getInstructions3(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Tecla Espaço", "Aumenta o volume para o DOBRO", 320));
        list.add(new Instruction("Letras a, b, c, d, e, f, g minúsculas", "Se caractere anterior era nota, repete, senão, pausa", 320));
        list.add(new Instruction("Qualquer outra consoante", "Se caractere anterior era nota, repete, senão, pausa", 320));
        list.add(new Instruction("Qualquer outra coisa", "Se caractere anterior era nota, repete, senão, pausa", 320));
        return list;
    }
}
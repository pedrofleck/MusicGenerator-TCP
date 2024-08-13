package general.Interface.src.assets;

import general.Interface.src.components.Instruction;
import general.Interface.src.components.Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstructionsList {

    public List getInstructions1(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Letra A ou a", "Nota Lá", 80, 90));
        list.add(new Instruction("Letra B ou b", "Nota Si", 80, 90));
        list.add(new Instruction("Letra C ou c", "Nota Dó", 80, 90));
        list.add(new Instruction("Letra D ou d", "Nota Ré", 80, 90));
        list.add(new Instruction("Letra E ou e", "Nota Mi", 80, 90));
        list.add(new Instruction("Letra F ou f", "Nota Fá", 80, 90));
        list.add(new Instruction("Letra G ou g", "Nota Sol", 80, 90));
        list.add(new Instruction("Caractere ?", "Nota randômica",80, 90));
        return list;
    }

    public List getInstructions2(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Caractere Espaço", "Silêncio ou pausa", 140, 210));
        list.add(new Instruction("Caractere +", "Aumenta o volume para o DOBRO", 140, 210));
        list.add(new Instruction("Caractere -", "O volume volta para o valor padrão",140, 210));
        list.add(new Instruction("Caracteres R+", "Aumenta UMA oitava",140, 210));
        list.add(new Instruction("Caracteres R-", "Diminui UMA oitava",140, 210));
        list.add(new Instruction("Caracteres BPM+", "Aumenta o BPM em 80 unidades",140, 210));
        list.add(new Instruction("Caractere ;", "BPM randômico",140, 210));
        list.add(new Instruction("Outro caractere", "Continua o anterior",140, 210));
        return list;
    }

    public List getInstructions3(){
        List<Instruction> list = new ArrayList<>();
        list.add(new Instruction("Outras vogais (I, i, O, o, U, u)", "Se caractere anterior era nota, repete, se não, som de telefone",180, 400));
        list.add(new Instruction("Troca de instrumento", "Nova linha (enter) e digitar o nome do instrumento entre asteríscos (*)",180, 400));
        return list;
    }

    public List getInstruments1(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*acoustic_grand_piano*", 120));
        list.add(new Instrument("*electric_grand_piano*", 120));
        list.add(new Instrument("*clavinet*", 120));
        return list;
    }

    public List getInstruments2(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*celesta*", 120));
        list.add(new Instrument("*xylophone*", 120));
        list.add(new Instrument("*music-box*", 120));
        return list;
    }

    public List getInstruments3(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*church-organ*", 120));
        list.add(new Instrument("*rock-organ*", 120));
        list.add(new Instrument("*tango-accordion*", 120));
        return list;
    }

    public List getInstruments4(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*overdriven-guitar*", 120));
        list.add(new Instrument("*distortion-guitar*", 120));
        list.add(new Instrument("*contrabass*", 120));
        return list;
    }

    public List getInstruments5(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*violin*", 120));
        list.add(new Instrument("*soprano-sax*", 120));
        list.add(new Instrument("*flute*", 120));
        return list;
    }

    public List getInstruments6(){
        List<Instrument> list = new ArrayList<>();
        list.add(new Instrument("*bird_tweet*", 120));
        list.add(new Instrument("*helicopter*", 120));
        list.add(new Instrument("*gunshot*", 120));
        return list;
    }
}
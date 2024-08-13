package general.Interface.src.assets;

public class NotesTable {

    public NotesTable() {

    }
    public NotesTable(String TextMusic) {
        //tratando as mensagens recebidas
        String NewText ;
        for (int currentChar = 0; currentChar < TextMusic.length(); currentChar++) {
            char c = TextMusic.charAt(currentChar);
            switch (c) {
                case 'A': case 'a':
                    NewText = "Lá ";
                    break;
            }
        }
    }
}
package general.Interface.src.assets;

public class NotesMusicForUser {
    StringBuilder NewText = new StringBuilder();

    private static StringBuilder getStringBuilder(StringBuilder NewText) {
        return NewText;
    }

    public StringBuilder setNewText(StringBuilder newText) {
        NewText = newText;
        return newText;
    }

    private StringBuilder StringText (String TextMusic) {
        //tratando as mensagens recebidas
        for (int currentChar = 0; currentChar < TextMusic.length(); currentChar++) {
            char c = TextMusic.charAt(currentChar);
            switch (c) {
                case 'A': case 'a':
                    NewText.append("Lá ");
                    break;
                case 'B': case 'b':
                    NewText.append("Si ");
                    break;
                case 'C': case 'c':
                    NewText.append("Dó ");
                    break; case 'D': case 'd':
                    NewText.append("Ré  ");
                    break;
                case 'E': case 'e':
                    NewText.append("Mi ");
                    break;
                case 'F': case 'f':
                    NewText.append("Fá ");
                    break;

                case 'G': case 'g':
                    NewText.append("Sol ");
                    break;
                default: NewText.append(c);
            }
        }
        return NewText;
    }

}


package general.Interface.src.principalClasses;

public class NotesMusicForUser {

    public StringBuilder stringText (String TextMusic) {
        //show the messages receive
        StringBuilder newText = new StringBuilder();
        for (int currentChar = 0; currentChar < TextMusic.length(); currentChar++) {
            char c = TextMusic.charAt(currentChar);
            switch (c) {
                case 'A': case 'a':
                    newText.append("Lá ");
                    break;
                case 'B': case 'b':
                    newText.append("Si ");
                    break;
                case 'C': case 'c':
                    newText.append("Dó ");
                    break; case 'D': case 'd':
                    newText.append("Ré  ");
                    break;
                case 'E': case 'e':
                    newText.append("Mi ");
                    break;
                case 'F': case 'f':
                    newText.append("Fá ");
                    break;

                case 'G': case 'g':
                    newText.append("Sol ");
                    break;
                default :
                    break;
            }
        }
        return newText;
    }

}


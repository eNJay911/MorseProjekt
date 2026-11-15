package assignment;

import java.util.HashMap;

public class MorseConverter {

    // Här sparar vi översättningarna.
    // Till exempel betyder "E" samma sak som ".".
    private HashMap<String, String> map;

    public MorseConverter() {
        map = new HashMap<>();

        // Engelska bokstäver till morsekod.
        map.put("A", ".-");
        map.put("B", "-...");
        map.put("C", "-.-.");
        map.put("D", "-..");
        map.put("E", ".");
        map.put("F", "..-.");
        map.put("G", "--.");
        map.put("H", "....");
        map.put("I", "..");
        map.put("J", ".---");
        map.put("K", "-.-");
        map.put("L", ".-..");
        map.put("M", "--");
        map.put("N", "-.");
        map.put("O", "---");
        map.put("P", ".--.");
        map.put("Q", "--.-");
        map.put("R", ".-.");
        map.put("S", "...");
        map.put("T", "-");
        map.put("U", "..-");
        map.put("V", "...-");
        map.put("W", ".--");
        map.put("X", "-..-");
        map.put("Y", "-.--");
        map.put("Z", "--..");

        // Morsekod till engelska bokstäver.
        // Om vi bara hade lagt in bokstav till morsekod
        // skulle programmet inte kunna översätta tillbaka.
        map.put(".-", "A");
        map.put("-...", "B");
        map.put("-.-.", "C");
        map.put("-..", "D");
        map.put(".", "E");
        map.put("..-.", "F");
        map.put("--.", "G");
        map.put("....", "H");
        map.put("..", "I");
        map.put(".---", "J");
        map.put("-.-", "K");
        map.put(".-..", "L");
        map.put("--", "M");
        map.put("-.", "N");
        map.put("---", "O");
        map.put(".--.", "P");
        map.put("--.-", "Q");
        map.put(".-.", "R");
        map.put("...", "S");
        map.put("-", "T");
        map.put("..-", "U");
        map.put("...-", "V");
        map.put(".--", "W");
        map.put("-..-", "X");
        map.put("-.--", "Y");
        map.put("--..", "Z");
    }

    public String toMorse(String text) {
        // Om användaren inte skriver något säger vi till.
        // Annars skulle metoden bara ge ett tomt resultat.
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva någon text.");
        }

        String result = "";

        // Gör om texten till stora bokstäver först.
        // Då fungerar till exempel både "hej" och "HEJ".
        text = text.toUpperCase();

        // Vi går igenom texten en bokstav i taget.
        for (int i = 0; i < text.length(); i++) {
            String letter = Character.toString(text.charAt(i));

            // Om tecknet är ett mellanslag hoppar vi över det.
            // Då blir "HELLO WORLD" kodat som "HELLOWORLD".
            if (letter.equals(" ")) {
                continue;
            }

            // Vi letar upp bokstaven i HashMap.
            String morseLetter = map.get(letter);

            // Om bokstaven inte finns i map är den ogiltig.
            // Till exempel finns inte "!" bland bokstäverna A-Z.
            if (morseLetter == null) {
                throw new IllegalArgumentException(
                        "Tecknet " + letter + " stöds inte. Använd A-Z.");
            }

            // Om resultatet redan har en morsebokstav lägger vi till ett mellanslag.
            // Exempel: H och E blir ".... ." och inte "........".
            if (!result.isEmpty()) {
                result += " ";
            }

            result += morseLetter;
        }

        // Om användaren bara skrev mellanslag blev inget kvar att översätta.
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Skriv minst en bokstav från A till Z.");
        }

        return result;
    }

    public String toEnglish(String morse) {
        // Om användaren inte skriver morsekod säger vi till.
        if (morse == null || morse.trim().isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva morsekod.");
        }

        String result = "";

        // Split delar upp morsekoden vid mellanslag.
        // Exempel: ".... . .---" blir tre delar: "....", "." och ".---".
        String[] morseLetters = morse.trim().split("\\s+");

        // Vi går igenom en morsegrupp i taget.
        for (int i = 0; i < morseLetters.length; i++) {
            // Vi letar upp morsekoden i map.
            String letter = map.get(morseLetters[i]);

            // Om morsekoden inte finns i map är den ogiltig.
            // Exempel: "..-.-" finns inte i vår tabell.
            if (letter == null) {
                throw new IllegalArgumentException(
                        "Morsekoden " + morseLetters[i] + " finns inte i tabellen.");
            }

            result += letter;
        }

        return result;
    }
}
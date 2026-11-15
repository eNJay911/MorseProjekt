package assignment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MorseConverterTest {

    // Om vi översätter F ska svaret bli ..-.
    @Test
    public void testFToMorse() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toMorse("F");
        assertEquals("..-.", result);
    }

    // Om vi översätter EH ska det bli två morsegrupper.
    @Test
    public void testEHToMorse() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toMorse("EH");
        assertEquals(". ....", result);
    }

    // Om vi skriver små bokstäver ska de också fungera.
    @Test
    public void testLowercaseToMorse() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toMorse("hej");
        assertEquals(".... . .---", result);
    }

    // Om texten har ett mellanslag hoppar programmet över det.
    @Test
    public void testHelloWorldToMorse() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toMorse("HELLO WORLD");
        assertEquals(".... . .-.. .-.. --- .-- --- .-. .-.. -..", result);
    }

    // Om vi skriver en punkt ska vi få bokstaven E.
    @Test
    public void testMorseToE() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toEnglish(".");
        assertEquals("E", result);
    }

    // Om vi skriver morsekod för HEJ ska vi få texten HEJ.
    @Test
    public void testMorseToHej() {
        MorseConverter converter = new MorseConverter();
        String result = converter.toEnglish(".... . .---");
        assertEquals("HEJ", result);
    }

    // Om texten har ett tecken utanför A-Z ska det bli ett fel.
    @Test
    public void testInvalidTextCharacter() {
        MorseConverter converter = new MorseConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.toMorse("HI!"));
    }

    // Om morsekoden inte finns i tabellen ska det bli ett fel.
    @Test
    public void testInvalidMorseCode() {
        MorseConverter converter = new MorseConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.toEnglish("..-.-"));
    }

    // Om texten är tom ska det bli ett fel.
    @Test
    public void testEmptyText() {
        MorseConverter converter = new MorseConverter();
        assertThrows(IllegalArgumentException.class, () -> converter.toMorse(""));
    }
}
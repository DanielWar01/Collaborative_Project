package Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class String_managementTest {

    @Test
    void convertToOwnName() {
        assertEquals("Hola y Que Tal", String_management.convertToOwnName("hola y que tal"));
    }

    @Test
    void searchWords() {
        assertEquals(1, String_management.searchWords("Juan carlos rojas", "juan"));
    }

    @Test
    void countVowels() {
        assertEquals(8, String_management.countVowels("que tal amigo día"));
    }

    @Test
    void newYear() {
        assertEquals(170, String_management.newYear("21:10"));
    }

    @Test
    void fillCharString() {
        assertEquals("lllsogamoso", String_management.fillCharString("sogamoso", 'l', false, 3));
        assertEquals("sogamoso, boyacaRRRR", String_management.fillCharString("sogamoso, boyaca", 'R', true, 4));
    }

    @Test
    void deleteChar() {
        assertEquals("jun", String_management.deleteChar("juaaan", "a"));
    }

    @Test
    void intersectionStrings() {
        assertEquals("hcosla", String_management.intersectionStrings("hola", "cosa"));
    }

    @Test
    void deleteRepeat() {
        assertEquals("daniel jro gu mñz", String_management.deleteRepeat("daniel alejandro guerra muñoz"));
    }

    @Test
    void countWords() {
        assertEquals(11, String_management.countWords("este metodo debe contar la cantidad, de palabras en la cadena"));
    }

    @Test
    void validateEmail() {
        assertTrue(String_management.validateEmail("guerra.daniel@uptc.edu.co"));
        assertFalse(String_management.validateEmail("guerra.daniel@uptc.edu.com"));
    }
}
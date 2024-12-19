import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


@Test
@DisplayName("Teilenummertest auf True")
@Tag("TeilenummerTrue")

void testaufTeilenummer1(){
    Eingabe e = new Eingabe();

    assertTrue(e.pruefeTeileNr("1234567889"));
    assertTrue(e.pruefeTeileNr("1002345689"));
}

    @Test
    @DisplayName("Teilenummertest auf False")
    @Tag("TeilenummerFaLSE")

    void testaufTeilenummer2(){
        Eingabe e = new Eingabe();

        assertFalse(e.pruefeTeileNr("9876543210"));
        assertFalse(e.pruefeTeileNr("0123456789"));


    }

}
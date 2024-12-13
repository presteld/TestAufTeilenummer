import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


@Test
@DisplayName("Teilenummertest")
@Tag("Teilenummer")

void testaufTeilenummer(){

    Eingabe e = new Eingabe();

    assertTrue(e.pruefeTeileNr("1234567889"));
}

}
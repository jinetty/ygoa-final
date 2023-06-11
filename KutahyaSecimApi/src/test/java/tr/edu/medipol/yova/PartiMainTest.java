package tr.edu.medipol.yova;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PartiMainTest {

    @Before
    public void setUp() {
        Parti.setPartiAOy(0);
        Parti.setPartiBOy(0);
        Parti.setPartiCOy(0);
    }

    @Test
    public void testPartiOyArttir() {
        Parti.partiOyArttir("A");
        assertEquals(1, Parti.getPartiAOy());

        Parti.partiOyArttir("B");
        assertEquals(1, Parti.getPartiBOy());

        Parti.partiOyArttir("C");
        assertEquals(1, Parti.getPartiCOy());
    }

    @Test
    public void testPartiOyAzalt() {
        Parti.partiOyArttir("A");
        Parti.partiOyArttir("B");
        Parti.partiOyArttir("C");

        Parti.partiOyAzalt("A");
        assertEquals(0, Parti.getPartiAOy());

        Parti.partiOyAzalt("B");
        assertEquals(0, Parti.getPartiBOy());

        Parti.partiOyAzalt("C");
        assertEquals(0, Parti.getPartiCOy());

        // Test if the vote count remains at 0 when trying to decrease further
        Parti.partiOyAzalt("A");
        assertEquals(0, Parti.getPartiAOy());

        Parti.partiOyAzalt("B");
        assertEquals(0, Parti.getPartiBOy());

        Parti.partiOyAzalt("C");
        assertEquals(0, Parti.getPartiCOy());
    }

    @Test
    public void testPartiListele() {
        Parti.partiOyArttir("A");
        Parti.partiOyArttir("B");
        Parti.partiOyArttir("C");

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Parti.partiListele();

        String expectedOutput = "Kutahya Il Milletvekili sonuclari\nA Partisi: 1\nB Partisi: 1\nC Partisi: 1\n\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset System.out
        System.setOut(System.out);
    }

    @Test
    public void testReadResultsFromFile() {
        Parti.partiOyArttir("A");
        Parti.partiOyArttir("B");
        Parti.partiOyArttir("C");

        // Save the current results to a file
        Parti.updateResultsFile();

        // Reset vote counts
        Parti.setPartiAOy(0);
        Parti.setPartiBOy(0);
        Parti.setPartiCOy(0);

        // Read the results from the file
        Parti.readResultsFromFile();

        assertEquals(1, Parti.getPartiAOy());
        assertEquals(1, Parti.getPartiBOy());
        assertEquals(1, Parti.getPartiCOy());
    }
}

import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void testIsPrimeV1() {
        PrimeV1 p1 = new PrimeV1();

        assertFalse(p1.isPrime(-1));
        assertFalse(p1.isPrime(0));
        assertFalse(p1.isPrime(1));
        assertTrue(p1.isPrime(2));
        assertTrue(p1.isPrime(3));
        assertFalse(p1.isPrime(4));
        assertTrue(p1.isPrime(5));
    }

    @Test
    public void testPrimeTo100kV1() {
        PrimeV1 p1 = new PrimeV1();
        ArrayList<Integer> r;

        r = p1.generatePrimeTo(100000);
        assertEquals(getPrimesFromFile().subList(0,r.size()),r);
    }

    @Test
    public void reliabilityTestV2() {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        for (int i=0 ; i<20 ; i++) {
            assertEquals(getPrimesFromFile().subList(0,168),p2.generatePrimeTo(1000));
        }
    }

    @Test
    public void testPrimeTo10kV2() {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(10000);
        assertEquals(getPrimesFromFile().subList(0,r.size()),r);
    }

    @Test
    public void testPrimeTo100kV2() {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(100000);
        assertEquals(getPrimesFromFile().subList(0,r.size()),r);
    }

    @Test
    public void testPrimeTo1000kV2() {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(1000000);
        r.sort(Comparator.naturalOrder());
        assertEquals(getPrimesFromFile().subList(0,r.size()),r);
    }



    public ArrayList<Integer> getPrimesFromFile() {
        ArrayList<Integer> out = new ArrayList<>();
        ArrayList<String> tempStringList = readFromFile("Prime numbers 0-1M.txt");
        String tempString = "";

        for (String string : tempStringList) {
            tempString += string;
        }

        tempString = tempString.replace("\n","");
        String[] temp = tempString.split(",");

        for (String string : temp) {
            out.add(Integer.parseInt(string));
        }
        return out;
    }

    public ArrayList<String> readFromFile(String file) {
        ArrayList<String> out = new ArrayList<String>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                out.add((line + "\n"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return out;
    }
}

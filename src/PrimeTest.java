import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class PrimeTest {

    @Test
    public void testIsPrimeV1() {
        PrimeV1 p1 = new PrimeV1();

        assertEquals(p1.isPrime(-1),false);
        assertEquals(p1.isPrime(0),false);
        assertEquals(p1.isPrime(1),false);
        assertEquals(p1.isPrime(2),true);
        assertEquals(p1.isPrime(3),true);
        assertEquals(p1.isPrime(4),false);
        assertEquals(p1.isPrime(5),true);
    }

    @Test
    public void testPrimeTo100kV1() {
        PrimeV1 p1 = new PrimeV1();
        ArrayList<Integer> r;

        r = p1.generatePrimeTo(100000);
        assertEquals(r,getPrimesFromFile().subList(0,r.size()));
    }

    @Test
    public void reliabilityTest() throws InterruptedException {
        for (int i=0 ; i<20 ; i++) {
            assertEquals(primeTo1kV2(),getPrimesFromFile().subList(0,168));
        }
    }

    public ArrayList<Integer> primeTo1kV2() throws InterruptedException {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(1000);
        return r;
    }

    @Test
    public void testPrimeTo10kV2() throws InterruptedException {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(10000);
        assertEquals(r,getPrimesFromFile().subList(0,r.size()));
    }

    @Test
    public void testPrimeTo100kV2() throws InterruptedException {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(100000);
        assertEquals(r,getPrimesFromFile().subList(0,r.size()));
    }

    @Test
    public void testPrimeTo1000kV2() throws InterruptedException {
        PrimeV2 p2 = new PrimeV2();
        ArrayList<Integer> r;

        r = p2.generatePrimeTo(1000000);
        r.sort(Comparator.naturalOrder());
        assertEquals(r,getPrimesFromFile().subList(0,r.size()));
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

import java.util.ArrayList;

public class PrimeV1 {

    public String benchmarkTo(int i) {
        Long t1 = System.currentTimeMillis();
        System.out.println(generatePrimeTo(i));
        Long t2 = System.currentTimeMillis();
        return t2-t1 + "ms";
    }

    public ArrayList<Integer> generatePrimeTo(int n) {
        ArrayList<Integer> out = new ArrayList<>();
        if(n<2) {
            return out;
        }
        for (int i = 2; i<=n; i++) {
            if(isPrime(i)) {
                out.add(i);
            }
        }
        return out;
    }

    public boolean isPrime(int n) {
        for (int i = n-1 ; i>1 ; i--) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
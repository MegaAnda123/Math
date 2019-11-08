import java.util.ArrayList;
import java.util.Comparator;

public class PrimeV2 {
    public ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String args[]) throws InterruptedException {
        PrimeV1 p1 = new PrimeV1();
        PrimeV2 p2 = new PrimeV2();
        System.out.println(p1.benchmarkTo(50000));
        System.out.println(p2.benchmarkTo(50000));
        ArrayList<Integer> r1 = p1.generatePrimeTo(100000);
        ArrayList<Integer> r2 = p2.generatePrimeTo(100000);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1.equals(r2));
    }

    public String benchmarkTo(int i) throws InterruptedException {
        Long t1 = System.currentTimeMillis();
        System.out.println(generatePrimeTo(i));
        Long t2 = System.currentTimeMillis();
        return t2-t1 + "ms";
    }

    public ArrayList<Integer> generatePrimeTo(int n) throws InterruptedException {
        primes.clear();
        if(n<2) {
            return primes;
        }
        if(n>1) {
            primes.add(2);
        }
        for (int i = 3; i<=n; i+=2) {
            Thread t = new Thread(new isPrime(this,i));
            t.start();
        }
        while (Thread.currentThread().getThreadGroup().activeCount() > 2) {
        }
        Thread.sleep(n/100);
        try {
            primes.sort(Comparator.naturalOrder());
        }
        catch (NullPointerException e) {
            System.out.println("It fucked up, trying again");
            this.generatePrimeTo(n);
        }
        return primes;
    }

    static class isPrime implements Runnable {
        PrimeV2 p;
        int n;
        boolean isPrime = true;

        isPrime(PrimeV2 p, int n) {
            this.p = p;
            this.n = n;
        }

        public void run() {
            for (int i = n - 1; i > 1; i--) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                p.primes.add(n);
            }
        }
    }
}

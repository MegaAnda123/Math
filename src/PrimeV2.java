import java.util.ArrayList;

public class PrimeV2 {
    public ArrayList<Integer> primes = new ArrayList<>();
    public boolean[] primesBool;

    public String benchmarkTo(int i) {
        Long t1 = System.currentTimeMillis();
        System.out.println(generatePrimeTo(i));
        Long t2 = System.currentTimeMillis();
        return t2-t1 + "ms";
    }

    public ArrayList<Integer> generatePrimeTo(int n) {
        primes.clear();

        primesBool = new boolean[n+1];

        if(n<2) {
            return primes;
        }
            primes.add(2);
        for (int i = 3; i<=n; i+=2) {
            Thread t = new Thread(new isPrime(this,i));
            t.start();
        }
        while (Thread.currentThread().getThreadGroup().activeCount() > 2) {}
        for(int i = 0; i<=n ; i++) {
            if(primesBool[i]) {
                primes.add(i);
            }
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
            p.primesBool[n] = isPrime;
        }
    }
}
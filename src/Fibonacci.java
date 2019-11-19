import java.util.ArrayList;

public class Fibonacci {

    public static void main(String args[]) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacciTo(500));
        System.out.println(recursive(20,0,1));
    }

    public ArrayList<Integer> fibonacciTo(int i) {
        ArrayList<Integer> out = new ArrayList<>();
        out.add(0);
        int n = 1;

        while (i>n) {
            out.add(n);
            int e = out.size();
            n = out.get(e-1) + out.get(e-2);
        }
        return out;
    }

    public static int recursive(int n, int a, int b) {
        n--;

        if(n<0) {
            return a;
        }
        a = a+b;
        return recursive(n,b,a);
    }
}

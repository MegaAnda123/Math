public class Pi {
    public static void main(String[] args) {
        Pi pi = new Pi();
    }

    public Pi() {
        double x = 0;

        for(int i = 0; i<1000000000; i++) {
            x += Math.pow((-1),i)/(2*i+1);

            System.out.println(4*x);
        }

    }

}

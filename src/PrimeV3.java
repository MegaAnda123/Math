import jcuda.*;
import jcuda.runtime.*;

public class PrimeV3 {

    public static void main(String args[]) {
        Pointer pointer = new Pointer();
        JCuda.cudaMalloc(pointer, 4);
        System.out.println("Pointer: " + pointer);
        JCuda.cudaFree(pointer);

        boolean a = false;

        System.out.println("skal folk dø? " + (a ? "yes" : "no"));
    }
}

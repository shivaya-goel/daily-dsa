package bitManipulation;

public class PowerOf2 {

    public static void main(String[] args) {
        PowerOf2 powerOf2 = new PowerOf2();
        System.out.println(powerOf2.isPowerOfTwo(8));
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

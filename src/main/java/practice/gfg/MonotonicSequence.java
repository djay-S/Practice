package practice.gfg;

//https://www.geeksforgeeks.org/find-element-position-in-given-monotonic-sequence/
public class MonotonicSequence {
    public static void main(String[] args) {
        System.out.println(test(2, 1, 1, 12168587437017l));
    }

    private static int test(int a, int b, int c, long k) {
        double val = 0;
        int res = 1;
        while (val < k) {
            val = a*res + b*res*Math.log10(res)/Math.log10(2) + c*Math.pow(res, 3);
            res++;
        }
        return --res;
    }
}

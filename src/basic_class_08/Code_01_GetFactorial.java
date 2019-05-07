package basic_class_08;

public class Code_01_GetFactorial {
    public static int getFactorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static int getFactorial2(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getFactorial2(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(10));
        System.out.println(getFactorial2(10));

    }
}

package basic_class_08;

public class Code_05_CowNumber {
    public static int cowNumber1(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 1 || N == 2 || N == 3) {
            return N;
        }
        return cowNumber1(N - 1) + cowNumber1(N - 3);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(cowNumber1(n));
    }
}

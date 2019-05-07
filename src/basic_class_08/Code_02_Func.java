package basic_class_08;

public class Code_02_Func {
    public static void func(int N, String from, String help, String to) {
        if (N == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            func(N - 1, from, to, help);
            System.out.println("Move " + N + " from " + from + " to " + to);
            func(N - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        func(3, "左", "中", "右");
    }
}

package basic_class_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Code_05_TwoStackQueue {
    private Stack<Integer> stack;
    private Stack<Integer> help;

    public Code_05_TwoStackQueue() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void add(int num) {
        stack.push(num);
    }

    public int poll() {
        if (help.isEmpty()) {
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.pop();
    }

    public int peek() {
        if (help.isEmpty()) {
            if (stack.isEmpty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            while (!stack.isEmpty()) {
                help.push(stack.pop());
            }
        }
        return help.peek();
    }

    public static void main(String[] argn) throws IOException {
        Code_05_TwoStackQueue queue = new Code_05_TwoStackQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = br.readLine()) != null) {
            if (read.equals("-")) {
                int pop = queue.poll();
                System.out.println("出队：" + pop);
            } else if (read.equals("+")) {
                int peek = queue.peek();
                System.out.println("队顶元素：" + peek);
            } else {
                queue.add(Integer.valueOf(read));
                System.out.println("入队：" + read);
            }
        }
    }
}

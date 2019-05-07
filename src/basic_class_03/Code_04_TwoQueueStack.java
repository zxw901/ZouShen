package basic_class_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Code_04_TwoQueueStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public Code_04_TwoQueueStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int num) {
        queue.add(num);
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        swapName();
        return help.poll();
    }

    public Integer peek() {
        if (queue.isEmpty()) {
            return null;
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        int res = queue.peek();
        help.add(queue.poll());
        swapName();
        return res;
    }

    public void swapName() {
        Queue<Integer> tmp = queue;
        queue = help;
        help = tmp;
    }

    public static void main(String[] argn) throws IOException {
        Code_04_TwoQueueStack stack = new Code_04_TwoQueueStack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = br.readLine()) != null) {
            if (read.equals("-")) {
                int pop = stack.pop();
                System.out.println("出栈：" + pop);
            } else if (read.equals("+")) {
                int peek = stack.peek();
                System.out.println("栈顶元素：" + peek);
            } else {
                stack.push(Integer.valueOf(read));
                System.out.println("入栈：" + read);
            }
        }
    }
}

package basic_class_07;

import java.util.PriorityQueue;

public class Code_03_LessMoney {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cur = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(lessMoney(arr));
    }
}

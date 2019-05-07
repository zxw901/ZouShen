package basic_class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_04_FindMaximizedCapital {
    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public static int findMaximizedCapital(int[] capital, int[] profits, int k, int w) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }
        PriorityQueue<Node> minCost = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < capital.length; i++) {
            minCost.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().c <= w) {
                maxProfit.add(minCost.poll());
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll().p;
        }
        return w;
    }
}

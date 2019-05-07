package basic_class_02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_05_FindMedian {
    public static class MedianHolder {
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeap());
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeap());

        private void modifyTwoHeapSize() {
            if (this.maxHeap.size() == this.minHeap.size() + 2) {
                this.minHeap.add(this.maxHeap.poll());
            }
            if (this.minHeap.size() == this.maxHeap.size() + 2) {
                this.maxHeap.add(this.minHeap.poll());
            }
        }

        public void addNumber(int num) {
            if (this.maxHeap.isEmpty()) {
                this.maxHeap.add(num);
                return;
            }
            if (this.maxHeap.peek() >= num) {
                this.maxHeap.add(num);
            } else {
                this.minHeap.add(num);
            }
            modifyTwoHeapSize();
        }

        public Integer getMedian() {
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();
            if (((minHeapSize + maxHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }

        public static class MinHeap implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }

        }

        public static class MaxHeap implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }

    }

    public static void main(String[] args) {
        MedianHolder median = new MedianHolder();
        int[] array = {8, 4, 9, 10, 1, 3, 5, 7};
        for (int a : array) {
            median.addNumber(a);
        }
        int res = median.getMedian();
        System.out.println(res);
    }
}




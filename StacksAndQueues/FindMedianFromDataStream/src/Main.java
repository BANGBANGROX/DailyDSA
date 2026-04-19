import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> maxHeap;
    private final PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(final int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        balance();
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return -1;
        }

        if (maxHeap.size() == minHeap.size()) {
            return (1.0 * maxHeap.peek() + minHeap.peek()) / 2;
        }

        return maxHeap.peek();
    }

    private void balance() {
        if (maxHeap.size() == minHeap.size() || maxHeap.size() == minHeap.size() + 1) {
            return;
        }

        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else {
            maxHeap.add(minHeap.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 *///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(final String[] args) {
        final MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(4);

        System.out.println(medianFinder.findMedian());
    }
}
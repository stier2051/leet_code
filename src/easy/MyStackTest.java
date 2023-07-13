package easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class MyStack {

    static int elementCount;
    static MyStack myStack = new MyStack();
    public MyStack() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }

    public void push(int x) {

    }

    public int pop() {

        return 0;
    }

    public int top() {
        return 0;
    }

    public boolean empty() {
        return size() == 0;
    }

    public PriorityQueue<Integer> reverseQueue(PriorityQueue<Integer> queueA) {
        PriorityQueue<Integer> queueB = new PriorityQueue<>();
        int count = queueA.size();
        int[] array = new int[count];
        for (int i = count-1; i >= 0; i--) {
            array[i] = queueA.peek();
            queueA.poll();
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < count; i++) {
            queueB.add(array[i]);
        }
        return queueB;
    }

    public int size() {
        return elementCount;
    }

    public void addElement(int element) {
        elementCount++;
//        myStack.reverseQueue()

    }
}

public class MyStackTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(3);
        queue.add(5);
        queue.add(6);
//        System.out.println(queue.size());
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        queue.poll();
//        System.out.println(queue);
//        System.out.println(queue.element());
//
//        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
//        System.out.println(queue1.peek());

        MyStack myStack = new MyStack();
        PriorityQueue<Integer> queue2 = myStack.reverseQueue(queue);
        System.out.println(queue2);
        System.out.println(queue2.peek());
    }
}

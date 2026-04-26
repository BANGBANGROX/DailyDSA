import java.util.Objects;
import java.util.Stack;

class MinStack {
    private final Stack<Integer> originalStack;
    private final Stack<Integer> minValueStack;

    public MinStack() {
        originalStack = new Stack<>();
        minValueStack = new Stack<>();
    }

    public void push(final int val) {
        originalStack.push(val);

        if (minValueStack.isEmpty() || minValueStack.peek() >= val) {
            minValueStack.push(val);
        }
    }

    public void pop() {
        if (Objects.equals(minValueStack.peek(), originalStack.pop())) {
            minValueStack.pop();
        }
    }

    public int top() {
        return originalStack.peek();
    }

    public int getMin() {
        return minValueStack.peek();
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(final String[] args) {
        final MinStack minStack = new MinStack();

        minStack.push(1);
        minStack.push(2);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
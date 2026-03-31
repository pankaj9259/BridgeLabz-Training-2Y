import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) {
        s1.push(x);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}

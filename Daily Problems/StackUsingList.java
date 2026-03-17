package Stack;

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingList
{
    Node top;

    void push(int x)
    {
        Node temp = new Node(x);

        temp.next = top;
        top = temp;
    }

    int pop()
    {
        if(top == null)
        {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = top.data;
        top = top.next;
        return val;
    }

    int peek()
    {
        if(top == null)
        {
            System.out.println("Stack Empty");
            return -1;
        }

        return top.data;
    }

    boolean isEmpty()
    {
        return top == null;
    }

    void display()
    {
        Node temp = top;

        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        StackUsingList st = new StackUsingList();

        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Pop: " + st.pop());
        System.out.println("Top: " + st.peek());

        st.display();
    }
}